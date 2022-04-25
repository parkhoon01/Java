/**
* <pre>
* com.pcwk.ex06.file
* Class Name : FileDirectoryEx02.java
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
package com.pcwk.ex06.file;

import java.io.*;

public class FileDirectoryEx02 {

	// Directory 다루기
	public static void main(String[] args) {
		// /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home 
		// /Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J20/src/com/pcwk/ex06/file
		if(args.length != 1) {	// param이 없으면 종료
			System.out.println("파라메터를 입력 하세요.");
			System.exit(0);
		}
		
		System.out.println("param: " + args[0]);
		
		File dir = new File(args[0]);
		
		// 디렉토리가 아니면 종료, 존재하지 않으면 종료.
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}
		else {
			File[] files = dir.listFiles();	// 디렉토리 내부에 있는 파일 정보 File[] return
			for(int i=0; i<files.length; i++) {
				String fileName = files[i].getName();
				System.out.println(files[i].isDirectory() ? "[" +fileName+ "]" : fileName);
			}
		}
		
	}

}
