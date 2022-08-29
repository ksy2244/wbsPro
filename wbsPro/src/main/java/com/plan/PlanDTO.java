package com.plan;

public class PlanDTO {
	private int prj_code; // 프로젝트 일정 코드
	private String prj_name; // 프로젝트명
	private int sub_date_code; // 대분류 일정 코드
	private String sub_name; // 대분류 일정명
	private int cat_date;// 중분류일정코드
	private String cat_name; // 중분류명
	private int op_date; // 소분류 코드
	private String op_name; // 소분류명

	public int getPrj_code() {
		return prj_code;
	}

	public void setPrj_code(int prj_code) {
		this.prj_code = prj_code;
	}

	public String getPrj_name() {
		return prj_name;
	}

	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
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

	public int getCat_date() {
		return cat_date;
	}

	public void setCat_date(int cat_date) {
		this.cat_date = cat_date;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public int getOp_date() {
		return op_date;
	}

	public void setOp_date(int op_date) {
		this.op_date = op_date;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}
}