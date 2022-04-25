package com.pcwk.time.ex08.generics.extendss;

public class Powder extends Material{
	
	@Override
	public void doPrinting() {
		System.out.println("Powder를 재료로 출력 합니다.");
	}

	@Override
	public String toString() {
		return "재료는 powder 입니다.";
	}
	
	

}
