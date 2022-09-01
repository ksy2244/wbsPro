package com.project;

public class ProjectDTO {
	private int prj_code; // 프로젝트 코드
	private String prj_name; // 프로젝트명
	private String prj_ov; // 프로젝트 개요
	private String prj_plan; // 프로젝트 설명

	private String prj_plan_start; // 프로젝트 계획 시작일
	private String prj_plan_end; // 프로젝트 계획 종료일
	private int prj_plan_per; // 프로젝트 계획 진척율

	private String user_name; // 프로젝트 담당자
	private int user_code; // 프로젝트 담당자
	
	private String prj_start; // 프로젝트 실적 시작일
	private String prj_end; // 프로젝트 실적 종류일
	private String prj_per; // 프로젝트 실적 진척율
	private int prj_comp; // 프로젝트 업무 구성비
	
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
	public String getPrj_ov() {
		return prj_ov;
	}
	public void setPrj_ov(String prj_ov) {
		this.prj_ov = prj_ov;
	}
	public String getPrj_plan() {
		return prj_plan;
	}
	public void setPrj_plan(String prj_plan) {
		this.prj_plan = prj_plan;
	}
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_code() {
		return user_code;
	}
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	public String getPrj_start() {
		return prj_start;
	}
	public void setPrj_start(String prj_start) {
		this.prj_start = prj_start;
	}
	public String getPrj_end() {
		return prj_end;
	}
	public void setPrj_end(String prj_end) {
		this.prj_end = prj_end;
	}
	public String getPrj_per() {
		return prj_per;
	}
	public void setPrj_per(String prj_per) {
		this.prj_per = prj_per;
	}
	public int getPrj_comp() {
		return prj_comp;
	}
	public void setPrj_comp(int prj_comp) {
		this.prj_comp = prj_comp;
	}

}