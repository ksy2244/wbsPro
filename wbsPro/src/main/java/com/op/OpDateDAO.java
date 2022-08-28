package com.op;

import java.sql.SQLException;
import java.util.List;

public interface OpDateDAO {

	
	// ① 작업 등록 메뉴
	public int insertOpDate (OpDateDTO dto)  throws SQLException; // 소분류 등록
	
	// ② 작업 수정 메뉴
	public int updateOpDate (OpDateDTO dto)  throws SQLException; // 소분류 수정
	
	// ③ 작업 삭제 메뉴
	public int deleteOpDate (int opDate_Code)  throws SQLException; // 소분류 삭제
	
	
	
	
	
	// ④ 작업 검색 메뉴
	
	// 코드명 검색
	public OpDateDTO  searchOpDateCode(OpDateDTO dto);
	
	
	// 작업명 검색
	public List<OpDateDTO>  searchOpDateName(String OpDate_name);
	
	
	// 담당자명 검색
	public List<OpDateDTO>  searchOpDateManager (String OpDate_manager); 
	
	
	// 날짜 검색
	public List<OpDateDTO>  searchOpDateDate (String OpDate_date); 
	
	
	// 전체 작업 목록
	public List<OpDateDTO>  searchOpDateAll (String OpDate_date); 
	
	
	
	
	// ⑤ 업무 구성비 관리
	
	  // 업무 구성비 등록
	public int workCompInsertOpDate (int input) throws SQLException; 
	
	
	  // 업무 구성비 수정
	public int workCompUpdateOpDate (int input) throws SQLException; 
	
	
}