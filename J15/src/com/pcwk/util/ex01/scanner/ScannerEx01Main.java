/**
* <pre>
* com.pcwk.util.ex01.scanner
* Class Name : ScannerEx01Main.java
* Description:
* Author: baghun
* Since: 2022/02/23
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/02/23 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.util.ex01.scanner;

import java.util.*;

public class ScannerEx01Main {
	
	//	Scanner통한 무한 입력
	// 프로그램 종료

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] argArr = null;
		
		while(true) {
			System.out.println("q를 입력하면 프로그램 종료.");
			String prompt = ">>";
			System.out.print(prompt);
			
			// Line단위 입력
			String input = scanner.nextLine();
			
			input = input.trim();	// 앞뒤공백 제거
			// abc 1234 678
			argArr = input.split(" +");	// 입력받은 내용을 공백을 구분자로 자른다.
			
			// 제일 앞 문자를 잘라 낸다.
			String command = argArr[0].trim();
			if("".equals(command)) {	// command가 공백이면 다시 입
				continue;
			}
			
			// 명령어를 소문자로 변환
			command = command.toLowerCase();
			
			if("q".equals(command)) {
				System.out.println("프로그램을 종료!");
				System.exit(0);	// 0번을 정상, 그 이외는 비정상
			}
			else {
				for(int i=0; i<argArr.length; i++) {
					System.out.println(argArr[i]);
				}
			}
		}
	}

}
