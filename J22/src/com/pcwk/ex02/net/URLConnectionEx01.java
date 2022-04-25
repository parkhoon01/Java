package com.pcwk.ex02.net;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionEx01 {

	public static void main(String[] args) {
		URL url = null;
		String address = "http://sinchon.koreaisacademy.com/?dGubun=1&_ga=2.28977851.600780303.1646616004-285336498.1638953022";
		
		BufferedReader input = null;
		FileWriter fw = null;
		try {
			url = new URL(address);
			// 버퍼(byte 스트림을 char(InputStream))
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = "";
			while( (line = input.readLine() ) != null) {
				System.out.println(line);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
