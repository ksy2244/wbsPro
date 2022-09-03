package com.subject;

import java.sql.SQLException;

public interface SubjectDAO {

	// ① 작업 등록 메뉴
	public int insertSubject(SubjectDTO dto) throws SQLException; // 대분류 등록

	// ② 작업 수정 메뉴
	public int updateSubject(SubjectDTO dto) throws SQLException; // 대분류 수정

	// ③ 작업 삭제 메뉴
	public int deleteSubject(int sub_date_code) throws SQLException; // 대분류 삭

	public SubjectDTO findSub(int prjCode); // 가장 큰 대분류 찾기

}
