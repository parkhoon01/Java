package com.pcwk.time.ex02.timetask;

import java.util.*;

public class TimerMain {

	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer(true);
		
		TimerTask w1 = new Work01();
		TimerTask w2 = new Work02();
		
		// timer에 등록
		t.schedule(w1, 2000);	// 2초뒤에 실행
		t.schedule(w2, 1000);	// 1초뒤에 실행
		
		Thread.sleep(10000);
		System.out.println("모든 프로그램 종료.");
		
	}

}
