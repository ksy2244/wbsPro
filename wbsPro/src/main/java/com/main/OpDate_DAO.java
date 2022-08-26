package com.main;

import java.sql.SQLException;
import java.util.List;

public interface OpDate_DAO {

	
	// ① 작업 등록 메뉴
	public int insertOpDate (OpDateDTO dto)  throws SQLException; // 소분류 등록
	
	// ② 작업 수정 메뉴
	public int updateOpDate (OpDateDTO dto)  throws SQLException; // 소분류 수정
	
	// ③ 작업 삭제 메뉴
	public int deleteOpDate (int opDate_Code)  throws SQLException; // 소분류 삭제
	
	
	
	
	
	// ④ 작업 검색 메뉴
	
	// 코드명 검색
	public OpDateDTO  searchOpDate_Code(OpDateDTO dto)   throws SQLException;
	
	
	// 작업명 검색
	public List<OpDateDTO>  searchOpDate_Name(String OpDate_name)   throws SQLException;
	
	
	// 담당자명 검색
	public List<OpDateDTO>  searchOpDate_Manager (String OpDate_manager)  throws SQLException; 
	
	
	// 날짜 검색
	public List<OpDateDTO>  searchOpDate_Date (String OpDate_date)  throws SQLException; 
	
	
	// 전체 작업 목록
	public List<OpDateDTO>  searchOpDate_All (String OpDate_date)  throws SQLException; 
	
	
	
	
	// ⑤ 업무 구성비 관리
	
	  // 업무 구성비 등록
	public int workCompInsert_OpDate (int input) throws SQLException; 
	
	
	  // 업무 구성비 수정
	public int workCompUpdate_OpDate (int input) throws SQLException; 
	
	
}
