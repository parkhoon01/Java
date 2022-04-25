/**
* <pre>
* com.pcwk.ex04.inputstreamreader
* Class Name : InputStreamReaderEx01.java
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
package com.pcwk.ex04.inputstreamreader;

import java.io.*;

import com.pcwk.cmn.LoggerManager;


public class InputStreamReaderEx01 implements LoggerManager{
	
	public static void main(String[] args) {
		String filePath = "/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J20/src/com/pcwk/ex01/reader/reader.txt";
	
		try(FileInputStream fis = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(fis)) {
			
			int i = 0;
			while((i = isr.read()) != -1) {
				System.out.print((char)i);
			}
			
		}catch(IOException e) {
			LOG.debug("-------------------");
			LOG.debug(e.getMessage());
			LOG.debug("-------------------");
		}
		LOG.debug("프로그램 종료!");
	}

}
