package com.pcwk.king.dao;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.pcwk.cmn.DTO;
import com.pcwk.cmn.LoggerManager;
import com.pcwk.cmn.WorkDiv;
import com.pcwk.king.domain.King;

public class KingDao implements WorkDiv<King>, LoggerManager{
	//저장 파일에서 읽어 들인 Data : CRUD, 마지막에 파일에 기록
	public static List<King> kingList = new ArrayList<>();
	// 저장 파일 경로
	public static final String SAVE_FILE_PATH = "/Users/baghun/Desktop/DCOM_20220127/01_JAVA/workspace/Java_Hal_Goyang/src/com/pcwk/data/kings.csv";
	Scanner sc = new Scanner(System.in);
	
	public KingDao() {
		int readStatus = readFile(SAVE_FILE_PATH);
		if(readStatus == 0) {
			LOG.debug("파일 읽기 실패");
		}
		else {
			LOG.debug("파일 읽기 성공");
		}
	}
	
	/**
	 * ArrayList에 있는 내용을 SAVE_FILE_PATH에 기록
	 * @param filePath
	 * @return 저장 건수 return 
	 */
	public int saveFile(String filePath) {
		int writeCnt = 0;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			
			// ArrayList -> File기록
			for(King king : kingList) {
				//1,1163032212-9791163032212,Do it! HTML+CSS+<b>자바</b>스크립트 웹 표준의 정석,고경희,IT,1 => King
				String del = ",";
				String lineSkip = "\n";
				String outData = king.getkNum()+del+
						king.getkName()+del+
						king.getrName()+del+
						king.getBirth()+del+
						king.getReign()+del+
						king.getActivity()+ lineSkip;
				bw.write(outData);
				writeCnt++;
			}
			
		}catch(IOException e) {
			LOG.debug("==============================");
			LOG.debug(e.getMessage());
			LOG.debug("==============================");
		}
		
		return writeCnt;
	}
	
	/**
	 * kings.csv를 읽어서 kingList 할당
	 * @param filePath
	 * @return 0/ 1(성공)
	 */
	public int readFile(String filePath){
		int flag = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = "";
			//1,1163032212-9791163032212,Do it! HTML+CSS+<b>자바</b>스크립트 웹 표준의 정석,고경희,IT,1 => King
			while( (line = br.readLine()) != null){
					String[] inArray = line.split(",");
//					public King(String kNum, String kName, String rName, String birth, String reign, String activity)
					// 대여가능 여부
					// 1 -> true
					// 0 -> false
//					boolean available = (inArray[3].equals("1")?true:false);
					King king = new King(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4], inArray[5]);
					kingList.add(king);
			}
			
			if(kingList.size()>0) flag++;
		}catch(IOException e) {
			LOG.debug("=================================");
			LOG.debug("=IOException: " +e.getMessage()+"=");
			LOG.debug("=================================");
		}
		
		return flag;
	}

	@Override
	public List<King> doRetrieve(DTO dto) {
		
		return kingList;
	}
	
	/**
	 * King이 존재하는지 확인
	 * @param dto
	 * @return 1(존재)/ 0(없음)
	 */
	public int isKingExists(King dto) {
		int flag = 0;
		
		for(King king : kingList) {
			if(king.getkNum().equals(dto.getkNum())) {
				flag = 1;
				break;
			}
		}
		
		return flag;
	}

	@Override
	public int doSave(King dto) {
		if(1== isKingExists(dto)) {
			System.out.println("왕 번호가 존재합니다. => " + dto.getkNum());
			return -1;
		}
		boolean flag = kingList.add(dto);
		
		return (flag==true)?1:0;
	}

	@Override
	public int doDelete(King dto) {
		int flag = 0;
		for(int i = this.kingList.size()-1; i>=0; i--){
			King king = kingList.get(i);
			
			if(king.getkNum().equals(dto.getkNum())) {
				kingList.remove(i);
				flag=1;
				break;
			}
		}
		
		return flag;
	}

	@Override
	public King doSelectOne(King dto) {
		King kOut = null;
		for(King king : kingList) {
			if(king.getkName().equals(dto.getkName())) {
				kOut = king;
				break;
			}
		}
		
		return kOut;
	}

	@Override
	public int doUpdate(King dto) {
		int flag = 0;
		//ArrayList 수정
		// 1. 수정 데이터가 있는지 확인
		// 2. 기존삭제
		// 3. 수정데이터 등록
		if(this.isKingExists(dto) == 1) {
			flag += doDelete(dto);
			flag += doSave(dto);
		}
		
		return flag;
	}
	/**
	 * 주관식 퀴즈
	 * @param q
	 * @return
	 */
	public int QuizKb(int q) {
		int count = 0;
//		readFile(SAVE_FILE_PATH);
		int[] arr = new int[q];
		for (int i = 0; i < q; i++) {
			arr[i] = (int) (Math.random() * 27 + 1);
			for (int j = 0; j < i ; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(kingList.get(arr[i]).getActivity());
			System.out.print("정답(묘호/군휘) ex)태조: ");
			String answer = sc.nextLine();
			if(kingList.get(arr[i]).getkName().equals(answer)) {
				count++;
				System.out.println("정답입니다.");
			}
			else {
				System.out.println("오답입니다.");
				System.out.println("정답: " + kingList.get(arr[i]).getkName());
			}
		}
		
		
		return count;
	}
	/**
	 * 객관식 퀴즈
	 * @param q
	 * @return
	 */
	public int QuizNum(int q) {
		int count = 0;
//		readFile(SAVE_FILE_PATH);
		List<String> list = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();
		
		String[] strCA = new String[q];	// 정답을 저장할 문자열
		
		int[] arr = new int[q];		// 랜덤 문제 번호 저장하는 배열
		int[] arr2 = new int[4];	// 객관식 문제 저장하는 배열
		String[] str = new String[4];	// 랜덤 값과 정답값을 섞어서 저장할 문자열
		
		// 랜덤 번호 저장
		for (int i = 0; i < q; i++) {
			arr[i] = (int) (Math.random() * 27 + 1);
			for (int j = 0; j < i ; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		
		}
		
		// 정답을 문자열에 저장
		for(int i=0; i<arr.length; i++) {
			strCA[i] = kingList.get(arr[i]).getkName();
		}
//		System.out.println(Arrays.toString(strCA));
		
		// 객관식 랜덤값과 정답을 넣고 섞기
		int qq = 0;
		for(int i=0; i<arr.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				arr2[j] = (int) (Math.random() * 27 + 1);
				str[j] = kingList.get(arr2[j]).getkName();
				for (int a = 0; a < j ; a++) {
					if (arr2[j] == arr2[a]) {
						j--; 
					}
				}
			}
			str[0] = strCA[qq];	
			qq++; 
			// String[] -> ArrayList
			for(String a : str) {
				list.add(a); 
			}
//			System.out.println(Arrays.toString(str));
			
			// 섞기
			Collections.shuffle(list);
//			System.out.println(list);
			// ArrayList -> String[]
			str = list.toArray(new String[list.size()]);
			
//			System.out.println(Arrays.toString(str));
			for(int h=0; h<4; h++) {
				map.put(h, str[h]);
			}
//			System.out.println(map.toString());
			System.out.println(kingList.get(arr[i]).getActivity());
			// HashMap<Integer, String> 에 저장
			for(int k = 0; k<4; k++) {
				System.out.print((k+1) + "." + map.get(k) + " ");
			}
			System.out.println("");
			System.out.print("정답: ");
			int answer = sc.nextInt();
			if(map.get(answer-1) == strCA[i]) {
				System.out.println("정답입니다.");
				count++;
			}
			else {
				System.out.println("오답입니다.");
				System.out.println("정답: " + kingList.get(arr[i]).getkName());
			}
			list.removeAll(list);
			
		}
		
		return count;
	}

}
