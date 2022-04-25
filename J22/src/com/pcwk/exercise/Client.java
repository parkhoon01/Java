package com.pcwk.exercise;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		
		String ipAddress = "127.0.0.1";
		int port = 8888;
		
		try {
			Socket socket = new Socket(ipAddress, port);
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			System.out.println(dis.readUTF());
			
			is.close();
			dis.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
