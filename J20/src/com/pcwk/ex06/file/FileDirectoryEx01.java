/**
* <pre>
* com.pcwk.ex06.file
* Class Name : FileDirectoryEx01.java
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

public class FileDirectoryEx01 {

	public static void main(String[] args) throws IOException {
		
//		String filePath = "/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J20/src/com/pcwk/ex06/file/FileDirectoryEx01.bak";
		
		// 파일 객체 생성
		//File file = new File(filePath);
//		File file = new File("/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J20/src/com/pcwk/ex06/file", "FileDirectoryEx01.bak");
		File dir = new File("/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J20/src/com/pcwk/ex06/file");
		File file = new File(dir, "FileDirectoryEx01.bak");
		
		
		// 신규 파일 생성
		file.createNewFile();
		
		// File 객체는 파일과 디렉토리를 처리
		System.out.println("파일 여부: " + file.isFile());
		System.out.println("디렉토리 여부: " + file.isDirectory());
		
		System.out.println("경로를 제외한 파일명: " + file.getName());// 셩로를 제외한 파일명: FileDirectory
		System.out.println("파일이 속해 있는 디렉토리: " + file.getParent());
		
		System.out.println("파일에 절대 경로 : " + file.getAbsolutePath());
		
		//OS별 PathSeparator
		System.out.println("path Separator: " + file.pathSeparator);
		System.out.println("path Separator: " + file.separator);
		System.out.println("========================");
		System.out.println("파일 read: " + file.canRead());
		System.out.println("파일 write: " + file.canWrite());
		System.out.println("파일 실행: " + file.canExecute());
		
	
	}

}
