package com.pcwk.time.ex06.generis;

import java.util.*;

public class GenericsEx01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("apple");
		
		// Generics를 사용하지 않으면 casting 필요
		String str = (String)list.get(0);
		
		System.out.println("str: " + str);
		
		
		// Generics를 사용하면 casting이 불필요
		List<String> list01 = new ArrayList<>();
		list01.add("apple");
		
		String str02 = list01.get(0);	
		
	}

}
