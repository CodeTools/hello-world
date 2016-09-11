import java.net.*;
import java.io.*;

public class GreetingClient
{
   public static void main(String [] args)
   {
      String serverName = args[0];   // Take the server name most likely it is a localhost
      int port = Integer.parseInt(args[1]);   // Take the port number 
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port); // Dump the port number and the serve name to the Screen

         Socket client = new Socket(serverName, port);     // Client gets instantiated with a host name and a port number
         System.out.println("Just connected to "   + client.getRemoteSocketAddress()); // Print that you are connected

         OutputStream outToServer = client.getOutputStream();         // Get the output Stream
         DataOutputStream out = new DataOutputStream(outToServer); /// Pipe the socket output Stream to the Data output Stream

         out.writeUTF("Hello from "  + client.getLocalSocketAddress()); // Write anything but make sure it is UTF as our server understands only UTF
         InputStream inFromServer = client.getInputStream();  // get the client inputStream 

         DataInputStream in =  new DataInputStream(inFromServer);  // Get the reply of the Server 
         System.out.println("Server says " + in.readUTF()); // And Print the Smae here


         client.close();

      } catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}