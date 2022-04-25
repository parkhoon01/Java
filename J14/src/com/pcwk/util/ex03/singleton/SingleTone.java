package com.pcwk.util.ex03.singleton;

public class SingleTone {
	
	private static SingleTone singleTone;	// 
	
	// 생성자는 private
	private SingleTone() {}
	
	// 객체 생성용 static 메서드
	public static SingleTone getInstance() {
		
		if(null == singleTone) {
			singleTone = new SingleTone();
		}
		
		return singleTone;
	}

}
