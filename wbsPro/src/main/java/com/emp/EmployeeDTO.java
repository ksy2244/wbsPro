package com.emp;

public class EmployeeDTO {
	
	private final String adminId  = "admin";    // 관리자 아이디
	private final String adminPwd = "admin123"; // 관리자 비밀번호
	
	private int user_code;     // 사원번호
	private String name;       // 이름 
	private String rrn;        // 주민번호
	private String tel;        // 전화번호
	private String hireDate;   // 입사일
	private String resigndate; // 퇴사일
	private String address;    // 주소
	private String duty;       // 직무 
	private String pwd;        // 패스워드
	
	
	public int getUser_code() {
		return user_code;
	}
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getResigndate() {
		return resigndate;
	}
	public void setResigndate(String resigndate) {
		this.resigndate = resigndate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
