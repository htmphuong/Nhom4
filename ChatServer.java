import java.io.*;
import java.net.*;

public class ChatServer {  
	public static void main(String[] args )  {  
	  try {  
		 ServerSocket s = new ServerSocket(9189);
         Socket incoming = s.accept( );
         BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
		 BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter out = new PrintWriter(incoming.getOutputStream(), true /* autoFlush */);
         System.out.println("Server");
		 out.println( "Hello! Enter BYE to exit." );

         boolean done = false;
         while (!done) {  
			String fromClient = in.readLine();
			System.out.println(fromClient);
			System.out.print("Server: ");
			String fromServer= kbd.readLine();
			out.println("Server: " + fromServer);
            if (fromClient.trim().equals("Client: BYE") || fromServer.equals("BYE"))  done = true;
         }
         incoming.close();
      } catch (Exception e) {  
			System.out.println(e);
      }
   }
}