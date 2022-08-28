package com.cat;

public class CatDateDTO {
	
	private int sub_date_code; //대분류 일정코드 
	private int cat_date;//중분류일정코드
	private String cat_name; //중분류명
	
	private String cat_plan_start; //중분류계획시작일
	private String cat_plan_end; //중분류계획종료일
	private int cat_plan_per; //중분류계획진척율
	
	private String cat_start; // 중분류실적시작일
	private String cat_end; // 중분류실적종료일
	private int cat_per; // 중분류실적진척율
	
	private int cat_comp; // 업무구성비
	
	private String user_name;  // 중분류 담당자
	
	
	public int getSub_date_code() {
		return sub_date_code;
	}

	public void setSub_date_code(int sub_date_code) {
		this.sub_date_code = sub_date_code;
	}

	public int getCat_date() {
		return cat_date;
	}

	public void setCat_date_code(int cat_date) {
		this.cat_date = cat_date;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_plan_start() {
		return cat_plan_start;
	}

	public void setCat_plan_start(String cat_plan_start) {
		this.cat_plan_start = cat_plan_start;
	}

	public String getCat_plan_end() {
		return cat_plan_end;
	}

	public void setCat_plan_end(String cat_plan_end) {
		this.cat_plan_end = cat_plan_end;
	}

	public int getCat_plan_per() {
		return cat_plan_per;
	}

	public void setCat_plan_per(int cat_plan_per) {
		this.cat_plan_per = cat_plan_per;
	}

	public String getCat_start() {
		return cat_start;
	}

	public void setCat_start(String cat_start) {
		this.cat_start = cat_start;
	}

	public String getCat_end() {
		return cat_end;
	}

	public void setCat_end(String cat_end) {
		this.cat_end = cat_end;
	}

	public int getCat_per() {
		return cat_per;
	}

	public void setCat_per(int cat_per) {
		this.cat_per = cat_per;
	}

	public int getCat_comp() {
		return cat_comp;
	}

	public void setCat_comp(int cat_comp) {
		this.cat_comp = cat_comp;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	
}
