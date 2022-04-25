/**
* <pre>
* com.pcwk.util.ex02.stringtokenizer
* Class Name : TokenizerEx04_HanToNum.java
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
package com.pcwk.util.ex02.stringtokenizer;

import java.util.StringTokenizer;

public class TokenizerEx04_HanToNum {
	
//	한글로 된 숫자를 아라비아 숫자로 변환
	
//	삼십만삼천백십오		->	한글로 숫자 표시, 단위표
//	303115			-> 	

	public static void main(String[] args) {
		String input = "삼십만삼천백십오";	
		System.out.println(input);
		
		System.out.println(hanToNum(input));
		
		
	}
	
	public static long hanToNum(String input) {
		long result = 0;
		long tmpResult = 0; // 십백천 단위의 값을 저장하기 위한 임시변수
		long num = 0;
		
		final String NUMBER = "영일이삼사오육칠팔구";	//숫자
		final String UNIT = "십백천만억조";		//단위
		// 단위와 NUM_UNIT 배열 인덱스로 메핑!
		final long[] NUM_UNIT = {10,100,1000,10000,(long)1e8,(long)1e12};
		
		StringTokenizer st = new StringTokenizer(input, UNIT, true);
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
//			System.out.print(token);
			// 단위
//			"삼십만삼천백십오
//			"영일이삼사오육칠팔구"
			int check = NUMBER.indexOf(token);	//-1이 나오면 단위이다.
//			System.out.println("," + check);
			
			if(check == -1) {	// 단위 
				if("만억조".indexOf(token) == -1) {	// token이 만억조가 아니면 :	3110
					// 단위로 바로 시작하면 숫자가 없다 -> 1*단위
//					System.out.println("------------------");
//					System.out.println("token: " +token);
//					System.out.println("UNIT.indexOf(token):" + UNIT.indexOf(token));
//					System.out.println("NUM_UNIT[UNIT.indexOf(token)]: " + NUM_UNIT[UNIT.indexOf(token)]);
//					System.out.println("------------------");
					
					tmpResult += (num != 0 ? num : 1)*NUM_UNIT[UNIT.indexOf(token)];
				}
				else {	// token이 만억조 이면 : 30000
					tmpResult += num;
//					System.out.println("else tmlResult: " + tmpResult);
					result += (tmpResult !=0 ? tmpResult : 1)*NUM_UNIT[UNIT.indexOf(token)];
//					System.out.println("else result: " + result);
					tmpResult = 0;	// tmpResult 초기화
				}
				num = 0;	// num 0 초기화
			}
			else {	//5
				
				num = check;
//				System.out.println("num: " + num);

			}
			
		}
		System.out.println("result: " + result);
		System.out.println("tmpResult: " + tmpResult);
		System.out.println("num: " + num);
		
		System.out.println("result + tmpResult + num: " + (result + tmpResult + num));
		
		return result + tmpResult + num;
		
	}

}
