/**
* <pre>
* com.pcwk.exception.ex01
* Class Name : TryCatchFinallyMain.java
* Description:
* Author: baghun
* Since: 2022/02/21
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/02/21 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.exception.ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.pcwk.cmn.LoggerManager;


public class TryCatchFinallyMain implements LoggerManager {

	
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			LOG.debug("1");
			fis = new FileInputStream("a.txt");
			LOG.debug("1-1");
		} catch (FileNotFoundException e) {
			LOG.debug("FileNotFoundException: " + e.getMessage());
		}finally {
			LOG.debug("3.finally 무조건 수행!");
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOG.debug("finally 무조건 수행");
		}
		LOG.debug("프로그램 종료!");
		
	}

}
