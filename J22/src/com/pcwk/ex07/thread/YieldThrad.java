package com.pcwk.ex07.thread;

public class YieldThrad implements Runnable {
	// 실행둥에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보한다.
	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			System.out.print("🄐");
			Thread.yield();
		}
	}

}
