package sg.edu.nus.iss.app.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


import static sg.edu.nus.iss.app.server.NumSort.*;

public class ServerApp {
    private static final String ARG_MESSAGE = 
        "usage: java sg.edu.nus.iss.app.server.ServerApp " 
        + " <port no>" + " <result file>";
    public static void main( String[] args )
    {
        Socket sock = null;
        InputStream is = null;
        OutputStream os = null;

        try{
            // Get server port from java cli first argument
            String serverPort = args[0];
            System.out.println(serverPort);
            // Name the result file with second arg
            String resultFile = args[1];
            System.out.println(resultFile);

            System.out.printf("Cookie Server started at %s\n"
                    , serverPort);
            // Instantiate server socket object pass in the server
            ServerSocket server = 
                    new ServerSocket(Integer.parseInt(serverPort)); 
            while(true){
                // Client connect to the server ... this is the line where 
                // the server accept a connection from the client
                sock = server.accept(); 
                
                // Get the input data from the client program in byte
                is = sock.getInputStream();
                DataInputStream dis= new DataInputStream(is);

                // Write and response
                os = sock.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);

                // reading data stream assign to a variable where data is String
                while(true){
                    try{

                        //Get data from client. 
                        String dataFromClient = dis.readUTF();

                            for (int i = 0; i < dataFromClient.length(); i++) {
                                if (Character.isDigit(dataFromClient.charAt(i)) ||dataFromClient.charAt(i) == ' ') {
                                continue;
                                }
                                else{dos.writeUTF("Please enter integers.");
                                dataFromClient = dis.readUTF();
                                }
                            }
                        

                        int[] result = getNumSort(dataFromClient);

                        for(int i = 0; i<result.length; i++)
                        {
                            System.out.println(result[i]);
                        } 
                        
                        String str = Arrays.toString(result);
                        // dos.writeUTF("Result is_" + result);
                        dos.writeUTF("Sorted result is_" + str);

                        //Convert int[] result to List<String>
                        //Step 1:Convert int[] to List<Integer>
                        List<Integer> list = new ArrayList<Integer>();
                        for (int a : result)
                            list.add(a);
                        //Step 2:Convert List<Integer> to List<String>
                        List<String> newList = list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());

                        PrintList p = new PrintList();
                        p.print2file(newList, args[1]);


                    }catch (EOFException e) {
                        System.out.println("Client disconnected");
                        sock.close();
                        break;
                    }   
                }
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
            // validate arguments array must be more than 1 arg value
            System.out.println(ARG_MESSAGE);
            System.exit(1);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}
