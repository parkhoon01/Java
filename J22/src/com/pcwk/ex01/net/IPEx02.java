package com.pcwk.ex01.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPEx02 {

	public static void main(String[] args) {
		
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName: " + ip.getHostName());
			System.out.println("getHostAddress: " + ip.getHostAddress());

			ipArr = InetAddress.getAllByName("www.daum.net");
			
			for(int i=0; i<ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
