package com.plan;

public class PlanDTO {
	private int workCode; // 프로젝트 일정 코드
	private String workName; // 프로젝트명
	private String wrokRes; // 대분류 일정 코드
	private int workPer;// 중분류일정코드
	private int workComp; // 소분류 코드
	private int level; // 소분류 코드
	private String workUserName; // 담당자명
	private int workUserCode; // 담당자 코드

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

	public String getWorkUserName() {
		return workUserName;
	}

	public void setWorkUserName(String workUserName) {
		this.workUserName = workUserName;
	}

	public int getWorkUserCode() {
		return workUserCode;
	}

	public void setWorkUserCode(int workUserCode) {
		this.workUserCode = workUserCode;
	}



}