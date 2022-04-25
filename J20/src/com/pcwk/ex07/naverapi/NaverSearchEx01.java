/**
* <pre>
* com.pcwk.ex07.naverapi
* Class Name : NaverSearchEx01.java
* Description:
* Author: baghun
* Since: 2022/03/03
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/03/03 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ex07.naverapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NaverSearchEx01 {

	public static void main(String[] args) {
		String clientId = "znSLW9a7nM8PofmTBZ0U"; // ClientID
		String clientSecret = "m6TQD0zKob"; // ClientSecret

		if(args.length != 1) {	// param이 없으면 종료
			System.out.println("파라메터를 입력 하세요.");
			System.exit(0);
		}
		
		String text = args[0]; // 검색어
		BufferedReader br = null;
		try {
			text = URLEncoder.encode(text, "UTF-8");
			System.out.println("text: " + text);
//			블로그 json		
//			String apiURL = "https://openapi.naver.com/v1/search/blog?query="+text;
			// 뉴스
//			String apiURL = "https://openapi.naver.com/v1/search/news.json?query="+text;
			// 책: json
//			String apiURL = "https://openapi.naver.com/v1/search/book.json?query="+text;
			// 책: xml
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;
			System.out.println("apiURL: " + apiURL);

			URL url = new URL(apiURL); // URL

			// clientId, clientSecret 적용을 위한 HttpURLConnection
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET"); // GET방식으로 접근
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			// 200: 성공, 401: 인증실패
			int responseCode = con.getResponseCode();
			System.out.println("responseCode: " + responseCode);

			if (200 == responseCode) { // 성공
				// byteStream을 charStream으로 연결
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				// 가져온 데이터를 출력
				String line = "";
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} else {
				System.out.println("clientId와 clientSecret을 확인하세요.");
				return;
			}

		} catch (IOException e) {
			System.out.println("==================================================");
			System.out.println("IOException : " + e.getMessage());
			System.out.println("==================================================");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
