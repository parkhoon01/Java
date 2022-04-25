package com.pcwk.ex02.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListEx03_PrintAll {

	// 모든 데이터 출력
	public static void main(String[] args) {

		LinkedList<String> lectureList = new LinkedList<>(Arrays.asList("C", "JAVA", "ORACLE", "WEB", "SPRING", "C"));

		// for-each
		for (String str : lectureList) {
			System.out.print(str + ", ");
		}
		System.out.println();

		// 반복문
		for (int i = 0; i < lectureList.size(); i++) {
			String delim = ", ";
			System.out.print(lectureList.get(i) + ((i+1 != lectureList.size())? delim : ""));
		}
		System.out.println();
		
		// iterator
		Iterator<String> iter = lectureList.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + ", ");
		}
		System.out.println();
		
		// 뒤에서 부터 출력: 생성자에 출력 위치 선정 : lectureList.size()
		ListIterator<String> listIterator = lectureList.listIterator(lectureList.size());
		
		while(listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + ", ");
		}
	}

}
