package com.pcwk.exercise;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		int port = 8888;
		
		try {
			
			serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			System.out.println("ip: " + socket.getInetAddress());
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeUTF("hi");
			
			dos.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
