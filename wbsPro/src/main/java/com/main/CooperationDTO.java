package com.main;

public class CooperationDTO {
	
	// 협력업체
	private int coo_code;
	private String coo_name;
	private String coo_tel;
	private String coo_manager;
	
	// 협력업체 사원
	private int coo_user_code;
	private int user_code
	private int work_start_date;
	private int work_end_date;
	
	public String getCoo_code() {
		return coo_code;
	}
	public void setCoo_code(String coo_code) {
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
	
}
