package com.pcwk.ex09.thread;

public class SyncMain {

	public static void main(String[] args) {
		Runnable runable01 = new RunnableEx01();

		Thread t01 = new Thread(runable01);
		Thread t02 = new Thread(runable01);

		t01.start();
		t02.start();

		
	}

}
