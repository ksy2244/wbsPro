package com.project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {
	// ① 작업 등록 메뉴
	public int insertProject(ProjectDTO dto) throws SQLException; // 프로젝트 등록
	
	// ② 작업 수정 메뉴
	public int updateProject(ProjectDTO dto) throws SQLException; // 프로젝트 수정
	
	// ③ 작업 삭제 메뉴
	public int deleteProject(int project_Code) throws SQLException; // 프로젝트 삭제
	
	// ④ 작업 검색 메뉴
	public ProjectDTO searchProjectCode(int prj_code) throws SQLException;  // 코드명 검색
	public List<ProjectDTO> searchProjectName(String prj_name) throws SQLException;; 	// 작업명 검색
	public List<ProjectDTO> searchProjectManager(String Project_manager) throws SQLException; 	// 담당자명 검색
	public List<ProjectDTO> searchProjectDate(String Project_date) throws SQLException; 	// 날짜 검색
	public List<ProjectDTO> searchProjectAll() throws SQLException; 	// 전체 작업 목록

	// ⑤ 업무 구성비 관리
	public int workCompInsertProject(int input) throws SQLException;   // 업무 구성비 등록
	public int workCompUpdateProject(int input) throws SQLException; // 업무 구성비 수정



	


	


	
	
	
}
