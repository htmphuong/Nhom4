import java.io.*;
import java.net.*;

public class ChatClient {  
	public static void main(String[] args ){  
	  try {  
	     Socket s = new Socket(args[0],Integer.parseInt(args[1]));
         BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		 BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter out = new PrintWriter(s.getOutputStream(), true /* autoFlush */);
         System.out.println("Client");
		 System.out.println(in.readLine());

         boolean done = false;
         while (!done){
            System.out.print("Client: ");
		    String fromClient = kbd.readLine();
            out.println("Client: " + fromClient);
            String fromServer= in.readLine();
			System.out.println(fromServer);
			if (fromServer.trim().equals("Server: BYE") || fromClient.equals("BYE"))  done = true;
        }
        s.close();
      }
      catch (Exception e) {  
			System.out.println(e);
      }
   }
}


