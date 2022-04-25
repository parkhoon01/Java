package com.pcwk.ex02.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnectionEx02 {

	public static void main(String[] args) {
		URL url = null;
		String address = "http://sinchon.koreaisacademy.com/?dGubun=1&_ga=2.28977851.600780303.1646616004-285336498.1638953022";
		
		BufferedReader input = null;
		
		try(FileWriter fw = new FileWriter("index.html");
			BufferedWriter output = new BufferedWriter(fw);	) {
			
			url = new URL(address);
			String line = "";
			// 버퍼(byte 스트림을 char(InputStream))
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// index.html
			while( (line = input.readLine() ) != null) {
				System.out.println(line);
				output.write(line+ "\n");
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
