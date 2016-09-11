// File Name GreetingServer.java

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port); // Create a Server Socket 
      System.out.println("This server would wait for a Socket client for 2 minutes");
      serverSocket.setSoTimeout(100 *  1000);   // Set the Socket TimeOut  to 100 secs which is a little less than 2 minutes
   }

   public void run()
   {
      while(true)   // While there is no server time out run
      {
         try
         {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "..."); // Provide details on where the client should connect
            Socket server = serverSocket.accept();   // Accept the connection if and when there is a client trying to connect to the server

            System.out.println("Just connected to "  + server.getRemoteSocketAddress());  // Get the remote address of the Socket
            DataInputStream in = new DataInputStream(server.getInputStream());    // Get a DataInputStream out of the Socket stream

            System.out.println(in.readUTF());  // Read the Java Basic data types from the Stream if it is UTF
            DataOutputStream out =  new DataOutputStream(server.getOutputStream());  // Pipe the Output to the client socket
            out.writeUTF("Thank you for connecting to "  + server.getLocalSocketAddress() + "\nGoodbye!"); // Write out in UTF

            server.close();   // close the client server
         } catch(SocketTimeoutException s)
         {
            System.err.println("Socket timed out!");
            break;
         } catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      try
      {
         Thread t = new GreetingServer(port);
         t.start();
      } catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}