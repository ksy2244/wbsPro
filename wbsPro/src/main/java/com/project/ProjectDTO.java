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

	private String sub_start; // 프로젝트 실적 시작일
	private String sub_end; // 프로젝트 실적 종류일
	private String sub_per; // 프로젝트 실적 진척율
	private int sub_comp; // 프로젝트 업무 구성비

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

}
