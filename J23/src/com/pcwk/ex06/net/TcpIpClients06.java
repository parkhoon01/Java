package com.pcwk.ex06.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 메시지 보내기, 메시지 받기
public class TcpIpClients06 {

	public static void main(String[] args) {
		// 대화명 입력
		if (args.length != 1) {
			System.out.println("대화명을 입력하세요.");
			System.exit(0);
		}

		String serverIp = "192.168.3.101";
		int port = 8888;
		String name = args[0];

		try {
			Socket socket = new Socket(serverIp, port);

			Thread thread01 = new Thread(new ClientSender(socket, name));
			Thread thread02 = new Thread(new ClientReceiver(socket));
			
			thread01.start();
			thread02.start();
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// --main

	// Scanner에서 데이터 입력해서 서버로 전송
	public static class ClientSender extends Thread {
		Socket socket;
		String name;
		DataOutputStream out;

		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}

		@Override
		public void run() {
			Scanner scanner = new Scanner(System.in);
			
			try {
				if(out != null) {	// 최초 이름 보내기
					out.writeUTF(name);
				}
				
				while(out != null) {	// 채팅하기
					out.writeUTF("["+name+"]"+scanner.nextLine());
				}
				
			}catch(IOException e) {
				System.out.println("----------------------");
				System.out.println(e.getMessage());
			}
		}
	}// --ClientSender

	public static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
			}
		}
			
			@Override
			public void run(){
				while(in != null) {
					try {
						System.out.println(in.readUTF());
					} catch (IOException e) {
					}
				}
				
			}
	}// --ClientReceiver

}// --class
