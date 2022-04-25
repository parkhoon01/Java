package com.pcwk.ex10.address;


// VO(Value Object)
// VO란 이렇게 도메인에서 한개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체를 의미한다.
public class AddressBook extends DTO{
	private String name;			// 이름
	private String cellPhone;		// 핸드폰
	private String email;			// email
	private String address;			// 주소
	private String birthday; 		// 생년월일
	
	// 멤버 변수 초기화
	public AddressBook() {
		//this("", "", "", "", "");
	}

	public AddressBook(String name, String cellPhone, String email, String address, String birthday) {
		super();
		this.name = name;
		this.cellPhone = cellPhone;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	
	
	

}
