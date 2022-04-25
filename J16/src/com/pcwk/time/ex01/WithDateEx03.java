package com.pcwk.time.ex01;

import java.time.*;

public class WithDateEx03 {
	// 윤년: 1988 ~ 2030
	public static void main(String[] args) {
		LocalDate localD = LocalDate.now();
		
		LocalDate newDate = null;
		
		int cnt = 0;	// 윤달 count
		
		for(int i=1988; i<=2030; i++) {
			newDate = localD.withYear(i);	// 1988 ~ 
			
			if(newDate.isLeapYear()) {
				System.out.println(i+"은 윤년 입니다.");
				cnt++;
			}//--if
		}//--for
		System.out.println("윤년은 총 " + cnt + "번 있습니다.");
		
		
		
	}//--main

}
