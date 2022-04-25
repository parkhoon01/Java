/**
* <pre>
* com.pcwk.ex02.serializable
* Class Name : PersonMain.java
* Description:
* Author: baghun
* Since: 2022/03/04
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/03/04 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ex02.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonSerializableMain {

	public static void main(String[] args) {
		
		Person person01 = new Person("홍길동", "의적");
		Person person02 = new Person("이상무", "개발자");
		
		// 객체 직렬화
		try(FileOutputStream fos = new FileOutputStream("serial.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
			oos.writeObject(person01);
			oos.writeObject(person02);
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println("파일생성 완료!");
		
	}

}
