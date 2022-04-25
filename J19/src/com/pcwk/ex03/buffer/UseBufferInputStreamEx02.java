/**
* <pre>
* com.pcwk.ex03.buffer
* Class Name : NonBufferInputStreamEx01.java
* Description:
* Author: baghun
* Since: 2022/03/02
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/03/02 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ex03.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UseBufferInputStreamEx02 {

	public static void main(String[] args) {
		
		String filePath = "/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J19/big_output3.txt";
		System.out.println("filePath: " + filePath);
		
		long start = System.currentTimeMillis();
		
		try(FileInputStream fis = new FileInputStream(filePath);
			BufferedInputStream bis = new BufferedInputStream(fis);) {
			
			int data = 0;
			while( (data=bis.read()) != -1) {
				char ch = (char) data;
				System.out.print(ch);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
		long end = System.currentTimeMillis();
		System.out.println("");
		System.out.println("=========================");
		System.out.println("경과시간: " + (end - start) +" ms");
		System.out.println("============종료==========");
		System.out.println("=========================");
		
	}

}
