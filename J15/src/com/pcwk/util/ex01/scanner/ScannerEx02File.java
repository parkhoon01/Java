/**
* <pre>
* com.pcwk.util.ex01.scanner
* Class Name : ScannerEx02File.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx02File {

	// Scanner를 통해서 파일 읽기
	public static void main(String[] args) {
		// /Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J15/src/com/pcwk/util/ex01/scanner/data.txt
		try {
//			Scanner scanner = new Scanner(new File("/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J15/src/com/pcwk/util/ex01/scanner/data.txt"));
			Scanner scanner = new Scanner(new File("data.txt"));
			int sum = 0;	// 합
			int cnt = 0;	// 읽은 라인
			
			while(scanner.hasNextInt()) {	// 데이터가 있으면 true, 더이상 데이터가 없으면 false
				sum += scanner.nextInt();
				cnt++;
			}
			System.out.println("sum: " + sum);
			System.out.println("cnt: " + cnt);
			System.out.println("avg: " + (sum/(double)cnt));
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
