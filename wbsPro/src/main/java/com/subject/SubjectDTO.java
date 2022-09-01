package com.subject;

public class SubjectDTO {
	private int prj_code; // 프로젝트 코드
	private int sub_date_code; // 대분류 일정코드

	private String sub_name; // 대분류명
	private String sub_plan_start; // 대분류 계획 시작일
	private String sub_plan_end; // 대분류 계획 종료일
	private int sub_plan_per; // 대분류 계획 진척율

	private String user_name; // 사원 이름
	private int user_code; // 사원 코드

	private String sub_start; // 대분류 실적 시작일
	private String sub_end; // 대분류 실적 종류일
	private String sub_per; // 대분류 실적 진척율
	private int sub_comp; // 업무 구성비

	public int getPrj_code() {
		return prj_code;
	}

	public void setPrj_code(int prj_code) {
		this.prj_code = prj_code;
	}

	public int getSub_date_code() {
		return sub_date_code;
	}

	public void setSub_date_code(int sub_date_code) {
		this.sub_date_code = sub_date_code;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getSub_plan_start() {
		return sub_plan_start;
	}

	public void setSub_plan_start(String sub_plan_start) {
		this.sub_plan_start = sub_plan_start;
	}

	public String getSub_plan_end() {
		return sub_plan_end;
	}

	public void setSub_plan_end(String sub_plan_end) {
		this.sub_plan_end = sub_plan_end;
	}

	public int getSub_plan_per() {
		return sub_plan_per;
	}

	public void setSub_plan_per(int sub_plan_per) {
		this.sub_plan_per = sub_plan_per;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSub_start() {
		return sub_start;
	}

	public void setSub_start(String sub_start) {
		this.sub_start = sub_start;
	}

	public String getSub_end() {
		return sub_end;
	}

	public void setSub_end(String sub_end) {
		this.sub_end = sub_end;
	}

	public String getSub_per() {
		return sub_per;
	}

	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	public void setSub_per(String sub_per) {
		this.sub_per = sub_per;
	}

	public int getSub_comp() {
		return sub_comp;
	}

	public void setSub_comp(int sub_comp) {
		this.sub_comp = sub_comp;
	}

	public int setPrj_code() {
		// TODO Auto-generated method stub
		return 0;
	}

}
