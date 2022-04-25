package com.pcwk.ex05.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer05 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8887;
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println(getTime() + "서버가 준비 되었습니다.");
			
			socket = serverSocket.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}// --main

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
}
