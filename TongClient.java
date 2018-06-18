package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TongClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socketClient = new Socket("localhost", 5001);
			Scanner key = new Scanner(System.in);
			System.out.println("Nhap a=");
			String a=key.nextLine();
			System.out.println("Nhap b=");
			String b = key.nextLine();
			
			//tao luong du lieu de gui di Server
			DataOutputStream outputClient = 
			new DataOutputStream(socketClient.getOutputStream());
			outputClient.writeBytes(a+"\n");
			outputClient.writeBytes(b+"\n");
			
			DataInputStream inputClient = 
				new DataInputStream(socketClient.getInputStream());
			String tong = inputClient.readLine();
			System.out.println("Tong la "+ tong);
			
			socketClient.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
