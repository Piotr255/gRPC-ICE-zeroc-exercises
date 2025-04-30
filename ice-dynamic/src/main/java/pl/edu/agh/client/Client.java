package pl.edu.agh.client;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.InputStream;
import com.zeroc.Ice.LocalException;
import com.zeroc.Ice.Object;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.OperationMode;
import com.zeroc.Ice.OutputStream;
import com.zeroc.Ice.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CompletableFuture;

public class Client {


    public static void main(String[] args) {
        Communicator communicator = null;
        int status = 0;
        boolean continueFlag = true;
        try {
            communicator = Util.initialize(args);
            ObjectPrx base1 = communicator.stringToProxy("calculator:tcp -h 127.0.0.2 -p 10000  : udp -h 127.0.0.2 -p 10000 ");
            if (base1 == null) {
                throw new RuntimeException("Problem with connection string");
            }

            ObjectPrx obj1 = ObjectPrx.checkedCast(base1);
            String line = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while(continueFlag) {
                System.out.print("==> ");
                try {
                line = in.readLine();
                switch (line) {
                    case "add": {
                        OutputStream out = new OutputStream(communicator);
                        out.startEncapsulation();
                        out.writeInt(8);
                        out.writeInt(3);
                        out.endEncapsulation();
                        byte[] inParams = out.finished();
                        Object.Ice_invokeResult result = obj1.ice_invoke("add", OperationMode.Idempotent, inParams);
                        InputStream inputStream = new InputStream(communicator, result.outParams);
                        inputStream.startEncapsulation();
                        int resultInt = inputStream.readInt();
                        inputStream.endEncapsulation();
                        System.out.println("Wynik:" +  resultInt);
                        break;

                    }
                    case "subtract": {
                        OutputStream out = new OutputStream(communicator);
                        out.startEncapsulation();
                        out.writeInt(15);
                        out.writeInt(11);
                        out.endEncapsulation();
                        byte[] inParams = out.finished();
                        CompletableFuture<Object.Ice_invokeResult> resultFuture = obj1.ice_invokeAsync("subtract", OperationMode.Idempotent, inParams);
                        Communicator finalCommunicator = communicator;
                        resultFuture.thenAccept(result -> {
                            try {
                                InputStream inputStream = new InputStream(finalCommunicator, result.outParams);
                                inputStream.startEncapsulation();
                                int resultInt = inputStream.readInt();
                                inputStream.endEncapsulation();
                                System.out.println("Result: " + resultInt);
                            } catch (Exception e) {
                                System.out.printf(e.getMessage());
                            }
                        });
                        break;
                    }
                    case "avg": {
                        OutputStream out = new OutputStream(communicator);
                        out.startEncapsulation();
                        out.writeSize(2);
                        out.writeFloat(10.0f);
                        out.writeFloat(20.0f);
                        out.writeFloat(30.0f);
                        out.writeString("first");
                        out.writeFloat(5.0f);
                        out.writeFloat(15.0f);
                        out.writeFloat(25.0f);
                        out.writeString("second");
                        out.endEncapsulation();
                        byte[] inParams = out.finished();
                        Object.Ice_invokeResult result = obj1.ice_invoke("avg", OperationMode.Idempotent, inParams);
                        InputStream inputStream = new InputStream(communicator, result.outParams);
                        inputStream.startEncapsulation();
                        String bestD = inputStream.readString();
                        inputStream.endEncapsulation();
                        System.out.println("Best d value: " + bestD);
                        break;
                    } case "op": {
                        OutputStream out = new OutputStream(communicator);
                        out.startEncapsulation();
                        out.writeFloat(10.0f);
                        out.writeFloat(20.0f);
                        out.writeFloat(30.0f);
                        out.writeString("first");
                        out.writeShort((short) 5);
                        out.endEncapsulation();
                        byte[] inParams = out.finished();
                        obj1.ice_invoke("op", OperationMode.Normal, inParams);
                        break;
                    }
                    case "end": {
                        continueFlag = false;
                        break;
                    }
                }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (LocalException e) {
            e.printStackTrace();
            status = 1;
        } finally {
            if(communicator != null) {
                communicator.destroy();
            }
        }
        System.exit(status);

    }
}

