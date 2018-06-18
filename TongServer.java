package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TongServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(5001);
			System.out.println("Server started");
			Socket socketServer = serverSocket.accept();
			
			//tao luong Stream de nhan data tu client
			DataInputStream inputSever = new DataInputStream(socketServer.getInputStream());
			String a =inputSever.readLine();
			String b = inputSever.readLine();
			int so1=Integer.parseInt(a);
			int so2=Integer.parseInt(b);
			int tong =so1+so2;
			
			//tao luong Stream de dua data len client
			DataOutputStream outputServer = 
					new DataOutputStream(socketServer.getOutputStream());
			outputServer.writeBytes(String.valueOf(tong));
			socketServer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
