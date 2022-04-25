/**
* <pre>
* com.pcwk.collection.ex02.stack
* Class Name : StackEx02.java
* Description:
* Author: baghun
* Since: 2022/02/28
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/02/28 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.collection.ex02.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackEx02 {

	// 수식의 괄호 검사
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Example: java StackEx02 \"((2+3)*1+3)\" ");
			System.exit(0);
		}
		String expression = args[0];
		System.out.println("expression" + expression);

		Stack<Character> stack = new Stack<>();

		try {

			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				// "(" stack에 추가
				// ")" stack에서 제거
				if ('(' == ch) {
					stack.add(ch);
				}
				else if(')' == ch) {
					stack.pop();
				}
		
				System.out.println(ch);
			} // --for i
			if (stack.empty()) {
				System.out.println("괄호 일치!");
			} else {
				System.out.println("괄호 불일치!");
			}
			
			System.out.println(stack);

		} catch (EmptyStackException e) {
			System.out.println("괄호 불일치.");
		}

		System.out.println("프로그램 종료!");
	}

}
