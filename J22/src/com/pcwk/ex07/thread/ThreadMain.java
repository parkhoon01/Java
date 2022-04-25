package com.pcwk.ex07.thread;

public class ThreadMain {

	public static void main(String[] args) {
		YieldThrad yieldThread = new YieldThrad();
		NormThread normThread = new NormThread();
		
		Thread t01 = new Thread(yieldThread);
		Thread t02 = new Thread(normThread);
		
		t01.start();
		t02.start();

	}

}
