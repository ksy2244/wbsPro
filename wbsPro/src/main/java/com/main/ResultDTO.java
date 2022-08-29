package com.main;

public class ResultDTO {
	
	private int sub_date_code; //대분류 일정코드 
	private int cat_date;// 중분류일정코드
	private int op_date;// 소분류일정코드
	
	private String sub_start; // 중분류실적시작일
	private String sub_end; // 중분류실적종료일
	private int sub_per; // 중분류실적진척율
	
	private String cat_start; // 중분류실적시작일
	private String cat_end; // 중분류실적종료일
	private int cat_per; // 중분류실적진척율
	
	private String op_start; // 중분류실적시작일
	private String op_end; // 중분류실적종료일
	private int op_per; // 중분류실적진척율
	
	public int getSub_date_code() {
		return sub_date_code;
	}
	public void setSub_date_code(int sub_date_code) {
		this.sub_date_code = sub_date_code;
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
	public int getSub_per() {
		return sub_per;
	}
	public void setSub_per(int sub_per) {
		this.sub_per = sub_per;
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
}
