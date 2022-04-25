/**
* <pre>
* com.pcwk.util.ex02.date
* Class Name : DateEx03SimpleDateFormat.java
* Description:
* Author: baghun
* Since: 2022/02/22
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/02/22 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.util.ex02.date;

import com.pcwk.cmn.LoggerManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateEx03SimpleDateFormat implements LoggerManager {

	public static void main(String[] args) {
		SimpleDateFormat sdf01 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		// MM-dd-yyyy
		SimpleDateFormat sdf02 = new SimpleDateFormat("MM-dd-yyy");
		//yy년 MM월 dd일 E요일
		SimpleDateFormat sdf03 = new SimpleDateFormat("yy년 MM월 dd일 E요일");
		
		Date today = new Date();
		LOG.debug("yyyy-MM-dd HH:mm:ss.SSS : " + sdf01.format(today));
		LOG.debug("MM-dd-yyyy: " + sdf02.format(today));
		LOG.debug(sdf03.format(today));
	}

}
