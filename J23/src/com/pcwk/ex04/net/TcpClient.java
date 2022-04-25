package com.pcwk.ex04.net;

import java.net.*;
import java.io.*;

public class TcpClient {

	public static void main(String[] args) {
		// 서버 ip, port 번호
		String serverIp = "192.168.3.22";
		int serverPort = 7777;
		
		// Socket생성
		try {
			Socket socket = new Socket(serverIp, serverPort);
			
			// 소켓의 input 스트림 생성
			InputStream in =socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//소켓의 입력을 출력한다.
			System.out.println("서버로 부터 받은 메시지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
			// 스트림과 소켓을 닫는다.
			dis.close();
			in.close();
			socket.close();
			System.out.println("연결이 종료 되었습니다.");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
