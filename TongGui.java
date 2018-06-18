package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TongGui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket skGui = new DatagramSocket();
			System.out.println("Connecting");
			Scanner key = new Scanner(System.in);
			System.out.println("Nhap so 1");
			String so1 = key.nextLine();
			System.out.println("Nhap so 2");
			String so2 = key.nextLine();
			
			//tao packet de gui so 1
			byte[] a = so1.getBytes();
			byte[] b = so2.getBytes();
			//lay dia chi cua may gui
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket packetSo1 = new DatagramPacket(a, a.length, address, 5221);
			DatagramPacket packetSo2 = new DatagramPacket(b, b.length, address, 5221);
			skGui.send(packetSo1);
			skGui.send(packetSo2);
			
			byte[] tongNhan=new byte[1024];
			DatagramPacket packetNhan  = new DatagramPacket(tongNhan, tongNhan.length);
			skGui.receive(packetNhan);
			byte[] tong =packetNhan.getData();
			String kq = (new String(tong, tong.length)).trim();
			System.out.println("Tong la"+kq);
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
