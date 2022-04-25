package com.pcwk.time.ex03.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalMain {

	public static void main(String[] args) {
		
		
		// 10진수를 2진수로 변환시 오차 발생!
		double a = 24.3953;
		double b = 50.343998;
		
		System.out.println(a+b);

		// 실수 -> 정수 * 10의 -n
		// unscaledValue x 10-scale.
		BigDecimal num01 = new BigDecimal(String.valueOf(b));
		BigDecimal num02 = new BigDecimal(String.valueOf(a));
		
		System.out.println(num01.add(num02));
		
	}

}
