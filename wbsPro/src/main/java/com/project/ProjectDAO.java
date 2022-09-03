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

}
