package com.plan;

public class PlanDTO {
	private int workCode; // 프로젝트 일정 코드
	private String workName; // 프로젝트명
	private String wrokRes; // 대분류 일정 코드
	private int workPer;// 중분류일정코드
	private int workComp; // 소분류 코드
	private int level; // 소분류 코드
	private String workUser; // 담당자

	public int getWorkCode() {
		return workCode;
	}

	public void setWorkCode(int workCode) {
		this.workCode = workCode;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWrokRes() {
		return wrokRes;
	}

	public void setWrokRes(String wrokRes) {
		this.wrokRes = wrokRes;
	}

	public int getWorkPer() {
		return workPer;
	}

	public void setWorkPer(int workPer) {
		this.workPer = workPer;
	}

	public int getWorkComp() {
		return workComp;
	}

	public void setWorkComp(int workComp) {
		this.workComp = workComp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getWorkUser() {
		return workUser;
	}

	public void setWorkUser(String workUser) {
		this.workUser = workUser;
	}

}