/**
* <pre>
* com.pcwk.util.ex02.date
* Class Name : DateEx02.java
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
import java.util.*;

	// Date와 Calendat간의 변환

public class DateEx02 implements LoggerManager {

	public static void main(String[] args) {
		// Calendar -> Date
		Calendar cal = Calendar.getInstance();
		Date d01 = new Date(cal.getTimeInMillis());
		
		LOG.debug("d01: " + d01);
		
		// Date -> Calendar
		Date d02 = new Date();
		Calendar cal02 = Calendar.getInstance();
		
		cal02.setTime(d02);
		
		LOG.debug(cal02);
	}

}
