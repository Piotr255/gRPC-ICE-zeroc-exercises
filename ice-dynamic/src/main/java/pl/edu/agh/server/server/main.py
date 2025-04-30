import Ice
import sys
import Demo
import time

class CalcI(Demo.Calc):
    a = 0
    def add(self, a, b, current=Ice.Current):
        if a == 15 and b == 11:
          time.sleep(5)   
        print(f"Add: {a} + {b}")
        return a + b
    
    def subtract(self, a, b, current=Ice.Current):
        if a == 15 and b == 11:
          time.sleep(5)      
        print(f"Subtract: {a} - {b}")
        return a - b
    
    def op(self, a1, b1, current=Ice.Current):
        print(f"op for {a1} and {b1}")
        self.a += 1
        print(self.a)
    
    def avg(self, numberList, current=Ice.Current):
        print(f"Calculating avg: {numberList}")
        max_avg = float('-inf')
        best_d_string = ""
        for elem in numberList:
            current_avg = (elem.a + elem.b + elem.c) / 3.0
            if current_avg > max_avg:
                max_avg = current_avg
                best_d_string = elem.d

        return best_d_string

def main():
    with Ice.initialize(sys.argv) as communicator:
        adapter = communicator.createObjectAdapterWithEndpoints(
            "CalcAdapter", "default -h 127.0.0.2 -p 10000")
  
        servant = CalcI()
        
        proxy = adapter.add(servant, communicator.stringToIdentity("calculator"))
        print(f"Endpoint: {proxy}")
        
        adapter.activate()
        try:
            communicator.waitForShutdown()
        except KeyboardInterrupt:
            print("Caught Ctrl+C, exiting...")

if __name__ == "__main__":
    main()