/**
* <pre>
* com.pcwk.ex01.file
* Class Name : FileEx02ReadJava.java
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
package com.pcwk.ex01.file;

import java.io.*;

public class FileEx02ReadJava {
	
	static int found = 0;	// 특정 단어 count
	

	/**
	 * 디렉토리 내에 파일 읽고 특정 단어 count
	 */
	public static void main(String[] args) {

		// param : 디렉토리, 검색어
//		String dirPath = "/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/J21/src";
//		String keyWord = "class";
		
		// param이 2개가 아니면 종료
		if(args.length !=2 ) {
			System.out.println("Directory 검색어를 입력하세요.");
			System.exit(0);
		}
		
		// param 출력
		for(String p : args) {
			System.out.println("param: " + p);
		}
		
		File dir = new File(args[0]);	// 디렉토리 정보
		String keyWord = args[1];		// 검색어
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}
		
		try {
			findInFiles(dir, keyWord);
		} catch (IOException e) {
			System.out.println("===================");
			System.out.println(e.getMessage());
			System.out.println("===================");
			e.printStackTrace();
		}
		
		System.out.println("-------------------------");
		System.out.println("총 " + found + "개의 라인에서 " + keyWord + "를 발견 했습니다.");
		
	}
	
	

	/**
	 * *.java파일 내에서 keyWord가 몇개 있는지 count
	 * @param dir
	 * @param keyWord
	 * @throws IOException
	 */
	public static void findInFiles(File dir, String keyWord) throws IOException{
		
		File[] files = dir.listFiles();	// file, directory
		for(int i=0; i<files.length; i++) {
			
			// dir, file
			if(files[i].isDirectory()) {	// 디렉토리이면 재귀호출
				findInFiles(files[i], keyWord);
			}
			else {	// 파일이면서 *.java
				//FileEx02ReadJava.java
				String fileName = files[i].getName();
				int idx = fileName.lastIndexOf(".");
				String extention = fileName.substring(idx+1);	// java
				// java가 아니면 
				if(!"java".equals(extention)) {
					continue;
				}
				else {
					// 2byte char 처리
					FileReader fr = new FileReader(files[i]);
					BufferedReader br = new BufferedReader(fr);
					String data = "";	// 한줄 데이터
					int lineNum = 0;	// 라인 넘버
					
					while( (data = br.readLine()) != null) {
						lineNum++;
						// 해당 라인에 키워드가 있으면 
						if(data.indexOf(keyWord) != -1) {
							System.out.println(lineNum + "\t" + data);
							found++;	// keyWord를 찾으면 1건씩 증가
							
						}
					}
					System.out.println("");
					br.close();
				}
			}
			
		}//-- for i
		
	}// --findInFiles
	
}
