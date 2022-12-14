package com.op;

public class OpDateDTO {
	private int cat_date; // 중분류 코드
	private int op_date; // 소분류 코드
	private String op_name; // 소분류명
	private String op_plan_start; // 소분류 계획 시작일
	private String op_plan_end; // 소분류 계획 종료일
	private int op_plan_per; // 소분류 계획 진척율
	private String user_name; // 담당자
	private int user_code; // 사원 코드
	private String op_start; // 소분류 실적 시작일
	private String op_end; // 소분류 실적 종료일
	private int op_per; // 소분류 실적 진척율
	private int op_comp; // 업무 구성비


	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	public int getCat_date() {
		return cat_date;
	}

	public void setCat_date(int cat_date) {
		this.cat_date = cat_date;
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

	public int getOp_plan_per() {
		return op_plan_per;
	}

	public void setOp_plan_per(int op_plan_per) {
		this.op_plan_per = op_plan_per;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getOp_start() {
		return op_start;
	}

	public void setOp_start(String op_start) {
		this.op_start = op_start;
	}

	public String getOp_end() {
		return op_end;
	}

	public void setOp_end(String op_end) {
		this.op_end = op_end;
	}

	public int getOp_per() {
		return op_per;
	}

	public void setOp_per(int op_per) {
		this.op_per = op_per;
	}

	public int getOp_comp() {
		return op_comp;
	}

	public void setOp_comp(int op_comp) {
		this.op_comp = op_comp;
	}

}
