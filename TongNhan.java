package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TongNhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket skNhan = new DatagramSocket(5221);
			System.out.println("Server started");
			
			byte[] a = new byte[1024];
			byte[] b = new byte[1024];
			DatagramPacket packetNhan1 = new DatagramPacket(a, a.length);
			skNhan.receive(packetNhan1);
			byte[] so1 = packetNhan1.getData();
			
			DatagramPacket packetNhan2 = new DatagramPacket(b, b.length);
			skNhan.receive(packetNhan2);
			byte [] so2= packetNhan2.getData();
			
			String num1 = (new String(so1, so1.length)).trim();
			String num2 = (new String(so2,so2.length)).trim();
			
			int tong = Integer.parseInt(num1)+Integer.parseInt(num2);
			
			//dua tong ve lai cho sender
			InetAddress address = packetNhan1.getAddress();
			// doi tu int sang String ->byte
			byte[] tongGui =String.valueOf(tong).getBytes();
			int port = packetNhan1.getPort();
			DatagramPacket packetTong = new DatagramPacket(tongGui, tongGui.length, address, port);
			skNhan.send(packetTong);		
			skNhan.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
