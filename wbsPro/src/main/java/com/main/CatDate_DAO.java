package com.main;

import java.sql.SQLException;
import java.util.List;

public interface PlanDAO {

	
	// ① 작업 등록 메뉴
	public int insertCatDate(CatDateDTO dto) throws SQLException; // 중분류 등록
	
	// ② 작업 수정 메뉴
	public int updateCatDate(CatDateDTO dto) throws SQLException; // 중분류 수정
	
	// ③ 작업 삭제 메뉴
	public int deleteCatDate(int catDate_Code) throws SQLException; // 중분류 삭제

	
	
	
	
	
	// ④ 작업 검색 메뉴
	
	// 코드명 검색
	public CatDateDTO searchCatDate_Code(CatDateDTO dto) throws SQLException;

	
	
	// 작업명 검색
	public List<CatDateDTO> searchCatDate_Name(String CatDate_name) throws SQLException;

	
	
	// 담당자명 검색
	public List<CatDateDTO> searchCatDate_Manager(String CatDate_manager) throws SQLException;
	
	
	// 날짜 검색
	public List<CatDateDTO> searchCatDate_Date(String CatDate_date) throws SQLException;

	
	
	// 전체 작업 목록
	public List<CatDateDTO> searchCatDate_All(String CatDate_date) throws SQLException;

	
	
	
	
	// ⑤ 업무 구성비 관리
	
	  // 업무 구성비 등록
	public int workCompInsert_CatDate(int input) throws SQLException;
	
	
	  // 업무 구성비 수정
	public int workCompUpdate_CatDate(int input) throws SQLException; 
	
	
	
}
