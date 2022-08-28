package com.emp;

public class CooperationDTO {
	
	// 협력업체
	private int coo_code;       // 협력업체코드
	private String coo_name;    // 협력업체명
	private String coo_tel;     // 협력업체 전화번호
	private String coo_manager; // 협력업체 담당자
	
	// 협력업체 사원
	private int coo_user_code;   // 협력업체사원코드
	private int user_code;       // 사원코드
	private String work_start_date; // 근무시작일
	private String work_end_date;   // 근무종료일
	// private String coo_user   // 협력업체 사원명	

	public int getCoo_code() {
		return coo_code;
	}
	public void setCoo_code(int coo_code) {
		this.coo_code = coo_code;
	}
	public String getCoo_name() {
		return coo_name;
	}
	public void setCoo_name(String coo_name) {
		this.coo_name = coo_name;
	}
	public String getCoo_tel() {
		return coo_tel;
	}
	public void setCoo_tel(String coo_tel) {
		this.coo_tel = coo_tel;
	}
	public String getCoo_manager() {
		return coo_manager;
	}
	public void setCoo_manager(String coo_manager) {
		this.coo_manager = coo_manager;
	}
	public int getCoo_user_code() {
		return coo_user_code;
	}
	public void setCoo_user_code(int coo_user_code) {
		this.coo_user_code = coo_user_code;
	}
	public int getUser_code() {
		return user_code;
	}
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	public String getWork_start_date() {
		return work_start_date;
	}
	public void setWork_start_date(String work_start_date) {
		this.work_start_date = work_start_date;
	}
	public String getWork_end_date() {
		return work_end_date;
	}
	public void setWork_end_date(String work_end_date) {
		this.work_end_date = work_end_date;
	}
}
