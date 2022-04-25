package com.pcwk.ex01.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPEx01 {

	public static void main(String[] args) {
		// InetAddress
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
			// host 이름을 출력
			System.out.println("getHostName: " + ip.getHostName());
			
			// 호스트 주소를 출력
			System.out.println("getHostAddress: "+ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
