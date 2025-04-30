import path from 'path';
const PROTO_PATH = path.join(import.meta.dirname, '../../protos/events.proto');
import grpc from '@grpc/grpc-js';
import protoLoader from '@grpc/proto-loader';
import { Mutex } from 'async-mutex';
import { v4 as uuidv4 } from 'uuid';
import { faker } from '@faker-js/faker';

var packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {keepCase: true,
     longs: String,
     enums: Number,
     defaults: true,
     oneofs: true
    });

var protoDescriptor = grpc.loadPackageDefinition(packageDefinition);
var events = protoDescriptor.events;
var users = []
const usersMutex = new Mutex();

async function prepareTopics(userInfo) {
  const release = await usersMutex.acquire();

  try {

  if(users.some(user => user.name === userInfo.name)) {
    const user = users.find(user => user.name === userInfo.name)
    return [1, {id: user.id, topics:["food", "music", "books"]}];
    //return [0, {code: grpc.status.ALREADY_EXISTS, details: 'name is already taken'}]
  }
  const id = uuidv4();
  users.push({id: id, name: userInfo.name, subscriptions: [], buffer: []})
  return [1, {id: id, topics:["food", "music", "books"]}];
  } finally {
    release();
  }
}

async function getTopics(call, callback) {
  const [type, answer] =  await prepareTopics(call.request);
  if (type === 1) {
    callback(null, answer);
  } else {
    callback(answer);
  }
  
}

async function addSubscriptions(topics) {
  const release = await usersMutex.acquire();
  try {
    const userIndex = users.findIndex(user => user.id === topics.id);
    if(userIndex === -1) {
      return [0, {code: grpc.status.INVALID_ARGUMENT, details: 'no user with this id'}]
    }
    const filtered_topics = topics.topics.filter(topic => ["food", "music", "books"].includes(topic))
    users[userIndex].subscriptions = users[userIndex].subscriptions.concat(filtered_topics.filter(topic => !users[userIndex].subscriptions.includes(topic)));
    } finally {
      release();
    }
    return [1, undefined];
}
async function removeSubsciptions(topics) {
  const release = await usersMutex.acquire();
  try {
    const userIndex = users.findIndex(user => user.id === topics.id);
    if(userIndex === -1) {  
      return [0, {code: grpc.status.INVALID_ARGUMENT, details: 'no user with this id'}]
    }
    users[userIndex].subscriptions = users[userIndex].subscriptions.filter(subscription => !topics.topics.includes(subscription));
    } finally {
      release();
    }
    return [1, undefined];
}

async function Unsubscribe(call, callback) {
  const [type, answer] = await removeSubsciptions(call.request);
  if (type === 1) {
    callback(null, answer);
  } else {
    callback(answer);
  }
  
}

async function SubscribeTopics(call, callback) {
  const [type, answer] = await addSubscriptions(call.request);
  if (type === 1) {
    callback(null, answer);
  } else {
    callback(answer);
  }
};

async function endUser(call){
  const release = await usersMutex.acquire();
  try {
    const userIndex = users.findIndex(user => user.id === call.id);
    if(userIndex === -1) {  
      return [0, {code: grpc.status.INVALID_ARGUMENT, details: 'no user with this id'}]
    }
    users = users.filter(user => user.id !== call.id);
  } finally {
    release();
  }
  return [1, undefined];
}

async function EndService(call, callback) {
  const [type, answer] = await endUser(call.request);
  if (type === 1) {
    callback(null, answer);
  } else {
    callback(answer);
  } 
}




function getServer() {
  var server = new grpc.Server();
  server.addService(events.Events.service, {
    getTopics: getTopics,
    SubscribeTopics: SubscribeTopics,
    getNews: getNews,
    Unsubscribe: Unsubscribe,
    EndService: EndService
  });
  return server;
}

const newsMutex = new Mutex();

async function getNews(call) {
  const userId = call.request.id;
  while(true) {
    if(call.cancelled) {
      call.end();
      break;
    }
    const release = await usersMutex.acquire();
    const userIndex = users.findIndex(user => user.id === userId);
    if(userIndex === -1) {
      call.end();
      break;
    }
    const user = users[userIndex];
    try {
    if(user.hasChanged) {
      users[userIndex].hasChanged = false; 
      const newsRelease = await newsMutex.acquire();
      try {
      //const result = news.filter(single => user.subscriptions.includes(single.topic));
      const result = user.buffer;
      if(result.length > 0) {
        users[userIndex].buffer = []
        call.write({news: result});
      }
      } finally {
        newsRelease();
      }
    }
    } finally {
      release();
    }
    await new Promise(resolve => setTimeout(resolve, 300));
  }
} 

let news = []
let articleNumber = 1;

function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

async function generateNews() {
  const release1 = await newsMutex.acquire();
  news = [];
  for(let i = 0; i < 3; i++) {
    let random = getRandomInt(3);
    let enumVal = events.NewsImportance.type.value[random].name;
    news.push({topic: "food", newsTopic: faker.food.dish(), articleNumber, newsImportance: enumVal});
    articleNumber++;
  }
  for(let i = 0; i < 3; i++) {
    let random = getRandomInt(3);
    let enumVal = events.NewsImportance.type.value[random].name;
    news.push({topic: "music", newsTopic: faker.music.album(), articleNumber, newsImportance: enumVal});
    articleNumber++;
  }
  for(let i = 0; i < 3; i++) {
    let random = getRandomInt(3);
    let enumVal = events.NewsImportance.type.value[random].name;
    news.push({topic: "books", newsTopic:faker.book.title(), articleNumber, newsImportance: enumVal});
    articleNumber++;
  }
  release1();
  const release = await usersMutex.acquire();
  try {
    users.forEach(user =>{
      user.hasChanged = true;
      user.buffer = user.buffer.concat(news.filter(single => user.subscriptions.includes(single.topic)));
    });
    
  } finally {
    release();
  }
}

var routeServer = getServer();
routeServer.bindAsync('localhost:50051', grpc.ServerCredentials.createInsecure({
  'grpc.keepalive_time_ms': 10000,    
  'grpc.keepalive_timeout_ms': 5000,      
  'grpc.keepalive_permit_without_calls': 1, 
  'grpc.http2.min_time_between_pings_ms': 5000 
}), () => {
  setInterval(generateNews, 10000);
});






