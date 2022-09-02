package com.plan;

public class PlanDTO {
	private int workCode; // 프로젝트 일정 코드
	private String workName; // 프로젝트명
	private String wrokRes; // 대분류 일정 코드
	private int workTerm;// 중분류일정코드
	private int workComp; // 소분류 코드
	private int level; // 소분류 코드
	private String workUserName; // 담당자명
	private int workUserCode; // 담당자 코드
	private String workPlanStart; // 작업 시작일
	private String workPlanEnd; // 작업 종료일
	private int workPlanPer;
	private String workStart;
	private String workEnd;
	private int workPer;
	private int WorkPRatio;
	private int Ratio;
	private int Remain;

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

	public int getWorkTerm() {
		return workTerm;
	}

	public void setWorkTerm(int workTerm) {
		this.workTerm = workTerm;
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

	public String getWorkPlanStart() {
		return workPlanStart;
	}

	public void setWorkPlanStart(String workPlanStart) {
		this.workPlanStart = workPlanStart;
	}

	public String getWorkPlanEnd() {
		return workPlanEnd;
	}

	public void setWorkPlanEnd(String workPlanEnd) {
		this.workPlanEnd = workPlanEnd;
	}

	public int getWorkPlanPer() {
		return workPlanPer;
	}

	public void setWorkPlanPer(int workPlanPer) {
		this.workPlanPer = workPlanPer;
	}

	public String getWorkStart() {
		return workStart;
	}

	public void setWorkStart(String workStart) {
		this.workStart = workStart;
	}

	public String getWorkEnd() {
		return workEnd;
	}

	public void setWorkEnd(String workEnd) {
		this.workEnd = workEnd;
	}

	public int getWorkPer() {
		return workPer;
	}

	public void setWorkPer(int workPer) {
		this.workPer = workPer;
	}

	public int getWorkPRatio() {
		return WorkPRatio;
	}

	public void setWorkPRatio(int workPRatio) {
		WorkPRatio = workPRatio;
	}

	public int getRatio() {
		return Ratio;
	}

	public void setRatio(int ratio) {
		Ratio = ratio;
	}

	public int getRemain() {
		return Remain;
	}

	public void setRemain(int remain) {
		Remain = remain;
	}

}