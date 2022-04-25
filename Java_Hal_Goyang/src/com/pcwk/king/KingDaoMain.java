package com.pcwk.king;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.pcwk.king.dao.KingDao;
import com.pcwk.king.domain.King;

public class KingDaoMain {
	
	KingDao dao;

	
	public KingDaoMain() {
		dao = new KingDao();
	}
	
	public void saveFile() {
		int writeCnt = dao.saveFile("kingsTmp.csv");
		System.out.println("writeCnt: " + writeCnt);
	}

	public void readFile(){
		for(King k : dao.kingList) {
			System.out.println(k);
		}
	}
	/**
	 * Scanner를 통해서 데이터 입력
	 * @param read
	 * @return
	 */
	public King getInputData(Scanner scanner) {
		King king = null;
		
		String readInput = scanner.nextLine().trim();
		System.out.println(readInput);
		String[] dataArr = readInput.split(",");
		king = new King(dataArr[0],dataArr[1],dataArr[2],dataArr[3],dataArr[4],dataArr[5]);
		
		return king;
	}
	
	public static void main(String[] args) {
		KingDaoMain kingMain = new KingDaoMain();
		
		// kings.csv 존재여부 check
		File kings = new File(KingDao.SAVE_FILE_PATH);
		if(!kings.exists() || !kings.isFile()) {	// 파일이 존재하지 않고, 파일이 아니면
			try {
				kings.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		
		
		
		
//		CRUD
//		C: 등록, R:조회, U:수정, D:삭제, Q:종료
		
		//keyboard input 처리
		Scanner scanner = new Scanner(System.in);
		String inCommand = "";	// 명령어 입력
		do {
			System.out.println("=============조선시대 왕 프로그램===============");
			System.out.println("R:단건 조회, U:수정, RE:전체 조회, QU: 퀴즈, E:종료");
			System.out.println("===========================================");
			inCommand= scanner.nextLine(); 
			inCommand = inCommand.trim();
			
			King king = null;
			String[] dataArr = null;
			String readInput = "";
			int status = 0;
			
			
			switch(inCommand.toUpperCase()) {
			case "QU" : // 퀴즈 
				Scanner sc1 = new Scanner(System.in);
//				outerloop: 
//				int flag = 0;
//				while(flag != 1) {
//					System.out.println("⎡------------------퀴즈------------------⎤");
//					System.out.println(" ------ K: 주관식, N: 객관식, Q: 종료-------");
//					System.out.print("⎣---------------------------------------⎦\n");
//					inCommand = sc.nextLine().trim();
//					int q = 0; 
//					int count = 0;
//					if(inCommand.equalsIgnoreCase("K")) {
//						System.out.println("⎡---------------------------------------⎤");
//						System.out.println(" --------------주관식 퀴즈-----------------");
//						System.out.println("⎣---------------------------------------⎦");
//						System.out.print("퀴즈 개수를 입력하세요(최대 27):");
//						q = sc.nextInt();
//						count = kingMain.dao.QuizKb(q);
//						System.out.println(q+"개 중 " + count + "개 정답입니다.");
//						System.out.println(count*(100/q) + "점 입니다.");
//						break;
//					}
//					else if(inCommand.equalsIgnoreCase("N")) {
//						System.out.println("⎡---------------------------------------⎤");
//						System.out.println(" --------------객관식 퀴즈-----------------");
//						System.out.println("⎣---------------------------------------⎦");
//						System.out.print("퀴즈 개수를 입력하세요(최대 27):");
//						q = sc.nextInt();
//						count = kingMain.dao.QuizNum(q);
//						System.out.print(q+"개 중 " + count + "개 정답입니다.\n");
//						System.out.print(count*(100/q) + "점 입니다.");
//						System.out.println();
//						break;
//					}
//					else if(inCommand.equalsIgnoreCase("Q")) {
//						flag++;
//						break;
//					}
//					else {
//						System.out.println("\n명령어를 확인 하세요.");
//						break;
//					}
//				}
			
				while(!inCommand.equalsIgnoreCase("Q")) {
						System.out.println("⎡------------------퀴즈------------------⎤");
						System.out.println(" ------ K: 주관식, N: 객관식, Q: 종료-------");
						System.out.print("⎣---------------------------------------⎦\n");
						inCommand = scanner.nextLine().trim();
						int q = 0; 
						int count = 0; 
						switch(inCommand.toUpperCase()) { 
							case "K":
								System.out.println("⎡---------------------------------------⎤");
								System.out.println(" --------------주관식 퀴즈-----------------");
								System.out.println("⎣---------------------------------------⎦");
								System.out.print("퀴즈 개수를 입력하세요(최대 27):"); 
								q = sc1.nextInt();
								count = kingMain.dao.QuizKb(q);
								System.out.println(q+"개 중 " + count + "개 정답입니다.");
								System.out.println(count*(100/q) + "점 입니다.");
								break;
		//					break outerloop;
							
							case "N":
								System.out.println("⎡---------------------------------------⎤");
								System.out.println(" --------------객관식 퀴즈-----------------");
								System.out.println("⎣---------------------------------------⎦");
								System.out.print("퀴즈 개수를 입력하세요(최대 27):");
								q = sc1.nextInt();
								count = kingMain.dao.QuizNum(q);
								System.out.print(q+"개 중 " + count + "개 정답입니다.\n");
								System.out.print(count*(100/q) + "점 입니다.");
								System.out.println();
								break;
		//					break outerloop;
							
							case "Q":
								System.out.println("Q");
								break;
							default:
								System.out.println("\n명령어를 확인 하세요.");
								break;
						}
					
						
				}
					
				
				break;
			 
			case "RE": // 전체 조회
				System.out.println("========================================");
				System.out.println("\t\t\t");
				System.out.println("========================================");
				List<King> list = kingMain.dao.doRetrieve(king);
				System.out.println("[ 대수 | 묘호/군호 |   휘  |-----------출생/사망----------|-재위기간-|-------------------------------------업적-------------------------------------]");
				for(King k : list) {
					System.out.println("[ "+k.getkNum()+"대 |   "+k.getkName()+"   | "+k.getrName()+" | "+k.getBirth()+" |   "+k.getReign()+"   | "+k.getActivity());
				}
				break;
			
			case "U":	// 수정

				System.out.print("수정: ");
				king = kingMain.getInputData(scanner);
				
				
				
				if(kingMain.dao.isKingExists(king) != 1) {
					System.out.println("데이터가 존재 하지 않습니다.\n 데이터를 확인해주세요.");
					continue;
				}
				
				int uStatus = kingMain.dao.doUpdate(king);
				if(uStatus == 2) {
					System.out.println("수정 성공!");
				}
				else {
					System.out.println("수정 실패...");
				}
				 
//				System.out.println("U: input: " + king);
				break;
			
			case "R":	// 조회
				// 화면에서 도서 번호를 입력받는다.
				System.out.print("조회 왕 이름: ");
				readInput = scanner.nextLine().trim();
				// King 객체 생성
				king = new King();
				king.setkName(readInput); 
				
				King out = kingMain.dao.doSelectOne(king);
				if(null == out) {
					System.out.println("조회 실패!");
				}
				else {
					System.out.println("조회 성공");
					System.out.println("---------------[ 대수 | 묘호/군호 |   휘  |-----------출생/사망----------|-재위기간-|-------------------------------------업적-------------------------------------]");
					System.out.println("조회 데이터: " + out);
				}
				
				break;
			
			case "D": 	// 삭제
				System.out.print("삭제 왕 번호: ");
				readInput = scanner.nextLine().trim();
				king = new King();
				king.setkNum(readInput);// 삭제 왕 번호
				
				status = kingMain.dao.doDelete(king);
				if(1== status) {
					System.out.println("삭제 되었습니다.");
				}
				else {
					System.out.println("삭제 실패");
				}
				
				break;
			
			case "C":	// 등록
//				System.out.println("등록 " + inCommand.toUpperCase());
				System.out.println("1,태조,이성계,1335.10.27~1408.06.18(72세),7년,고려 말 무신으로 왜구를 물리쳐 공을 세우고 위화도 회군으로 조선을 건국.");
				System.out.print("입력: ");
				
				king = kingMain.getInputData(scanner);
				
				status = kingMain.dao.doSave(king);
				if(status == 1) {
					System.out.println(king.toString() + "입력 되었습니다.");
				}
				else {
					System.out.println("등록 실패!");
				}
				break;
				
			case "E":	// 종료: 메모리 to file
				kingMain.dao.saveFile(KingDao.SAVE_FILE_PATH);
				break;
				
			default:
				System.out.println("\n명령어를 확인 하세요.");
				break;
			
			}//--switch
		
		}while(!inCommand.equalsIgnoreCase("E"));
		
		System.out.println("=================================================");
		System.out.println("=========프로그램 종료=========");
		System.out.println("=================================================");
		
		
	}

}
