package com.pcwk.king.domain;

import com.pcwk.cmn.DTO;

/**
 * <pre>
 * 왕 정보
 * @author baghun
 *</pre>
 */
public class King extends DTO{
	private String kNum;	// 번호
	private String kName;	// 왕이름
	private String rName;	// 실명
	private String birth;	// 생년월일
	private String reign;	// 재위기간
	private String activity;	// 업적
	
	// Default
	public King() {
		super();
	}

	/**
	 * 생성자
	 * @param kName
	 * @param rName
	 * @param birth
	 * @param reign
	 * @param activity
	 */
	public King(String kNum, String kName, String rName, String birth, String reign, String activity) {
		super();
		this.kNum = kNum;
		this.kName = kName;
		this.rName = rName;
		this.birth = birth;
		this.reign = reign;
		this.activity = activity;
	}

	
	public String getkNum() {
		return kNum;
	}

	public void setkNum(String kNum) {
		this.kNum = kNum;
	}

	public String getkName() {
		return kName;
	}

	public void setkName(String kName) {
		this.kName = kName;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getReign() {
		return reign;
	}

	public void setReign(String reign) {
		this.reign = reign;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "King [ " + kNum + "대 " + "|   " + kName + "   | " + rName + " | " + birth + " |   " + reign
				+ "  | " + activity + "]";
	}
	
	
	
	
}
