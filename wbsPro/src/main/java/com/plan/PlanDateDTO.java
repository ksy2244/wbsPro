package com.plan;

public class PlanDateDTO {
	// 계획 진척율, 기간에 관한 클래스
	private String prj_plan_start; // 대분류 계획 시작일
	private String prj_plan_end; // 대분류 계획 종료일
	private int prj_plan_per; // 대분류 계획 진척율

	private String sub_plan_start; // 대분류 계획 시작일
	private String sub_plan_end; // 대분류 계획 종료일
	private int sub_plan_per; // 대분류 계획 진척율

	private String op_plan_start; // 소분류 계획 시작일
	private String op_plan_end; // 소분류 계획 종료일
	private String op_plan_per; // 소분류 계획 진척율

	private String cat_plan_start; // 중분류계획시작일
	private String cat_plan_end; // 중분류계획종료일
	private int cat_plan_per; // 중분류계획진척율

	public String getPrj_plan_start() {
		return prj_plan_start;
	}

	public void setPrj_plan_start(String prj_plan_start) {
		this.prj_plan_start = prj_plan_start;
	}

	public String getPrj_plan_end() {
		return prj_plan_end;
	}

	public void setPrj_plan_end(String prj_plan_end) {
		this.prj_plan_end = prj_plan_end;
	}

	public int getPrj_plan_per() {
		return prj_plan_per;
	}

	public void setPrj_plan_per(int prj_plan_per) {
		this.prj_plan_per = prj_plan_per;
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

	public String getOp_plan_start() {
		return op_plan_start;
	}

	public void setOp_plan_start(String op_plan_start) {
		this.op_plan_start = op_plan_start;
	}

	public String getOp_plan_end() {
		return op_plan_end;
	}

	public void setOp_plan_end(String op_plan_end) {
		this.op_plan_end = op_plan_end;
	}

	public String getOp_plan_per() {
		return op_plan_per;
	}

	public void setOp_plan_per(String op_plan_per) {
		this.op_plan_per = op_plan_per;
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

}
