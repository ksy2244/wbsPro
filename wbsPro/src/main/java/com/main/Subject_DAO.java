package com.main;

import java.sql.SQLException;
import java.util.List;

public interface PlanDAO {
	/*
	 * ProjectDTO : 프로젝트 객체
	 * SubjectDTO : 대분류 객체
	 * CatDateDTO : 중분류 객체
	 * OpDateDTO  : 소분류 객체
	 */
	
	// ① 작업 등록 메뉴
	public int insertSubject(SubjectDTO dto) throws SQLException; // 대분류 등록

	
	// ② 작업 수정 메뉴
	public int updateSubject(SubjectDTO dto) throws SQLException; // 대분류 수정

	
	// ③ 작업 삭제 메뉴
	public int deleteSubject(int subject_Code) throws SQLException; // 대분류 삭제

	
	
	
	
	
	// ④ 작업 검색 메뉴
	
	// 코드명 검색
	public SubjectDTO searchSubject_Code(SubjectDTO dto) throws SQLException;

	
	
	// 작업명 검색
	public List<SubjectDTO> searchSubject_Name(String Subject_name) throws SQLException; 

	
	
	// 담당자명 검색
	public List<SubjectDTO> searchSubject_Manager(String Subject_manager) throws SQLException; 

	
	
	// 날짜 검색
	public List<SubjectDTO> searchSubject_Date(String Subject_date) throws SQLException; 

	
	
	// 전체 작업 목록
	public List<SubjectDTO> searchSubject_All(String Subject_date) throws SQLException; 

	
	
	
	
	// ⑤ 업무 구성비 관리
	
	  // 업무 구성비 등록
	public int workCompInsert_Subject(int input) throws SQLException; 

	
	
	  // 업무 구성비 수정
	public int workCompUpdate_Subject(int input) throws SQLException; 

	
	
}
