package com.pcwk.ex05.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
// DataOutputStream을 통한 전송
public class Sender extends Thread {
	
	Socket socket;			// socket
	DataOutputStream out;	
	String name;
	
	public Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";	// [127.0.0.1:7777]
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// message입력, 전
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(out != null) {
			try {
				out.writeUTF(name+" "+scanner.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// --while
	}
	
	

}
