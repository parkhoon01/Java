package com.pcwk.ex04.net;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class TcpServer02 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 7770;	// server port
		
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println(getTime() + "서버가 준비되었습니다.");
		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				//서버소켓
				System.out.println(getTime() + "연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();
				
				System.out.println(getTime() + socket.getInetAddress() 
				+ "로 부터 요청이 들어왓습니다.");	// client ip
				
				// 포트 정보
				// 서버포트: socket.getLoclaPort() : 7777
				// client: socket.getPort()
				System.out.println("서버포트: " +socket.getLocalPort());
				System.out.println("클라이언트 포트: " + socket.getPort());
				
				// 소켓의 출력 스트림 생성
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 클라이언트로 데이터 전송
				dos.writeUTF(getTime() + "Test Message from Server.");
				System.out.println(getTime() + "데이터를 전송 했습니다.");
				
				// 자원반납:
				dos.close();
				socket.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}// --while
		
		
	}//--main
	
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}

}//--class
