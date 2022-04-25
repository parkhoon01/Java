package com.pcwk.ex10.thread;

public class RunnableEx01 implements Runnable {

	
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalnce() > 0) {
			// 100, 200, 300
			// 0.0 <= x < 1.0
			// 100 <= x < 400
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println("balance: " + acc.getBalnce());
		}
	}

}
