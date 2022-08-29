package com.plan;

public class PlanDTO {
	private int prj_code;
	private String prj_name;
	private int sub_date_code;
	private String sub_name;

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
}