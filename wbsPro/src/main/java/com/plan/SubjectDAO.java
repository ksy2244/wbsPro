package com.plan;

import java.sql.SQLException;
import java.util.List;

public interface SubjectDAO {
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
	public SubjectDTO searchSubjectCode(SubjectDTO dto);

	
	
	// 작업명 검색
	public List<SubjectDTO> searchSubjectName(String Subject_name); 

	
	
	// 담당자명 검색
	public List<SubjectDTO> searchSubjectManager(String Subject_manager); 

	
	
	// 날짜 검색
	public List<SubjectDTO> searchSubjectDate(String Subject_date); 

	
	
	// 전체 작업 목록
	public List<SubjectDTO> searchSubjectAll(String Subject_date); 

	
	
	
	
	// ⑤ 업무 구성비 관리
	
	  // 업무 구성비 등록
	public int workCompInsertSubject(int input) throws SQLException; 

	
	
	  // 업무 구성비 수정
	public int workCompUpdateSubject(int input) throws SQLException; 

	
	
}
