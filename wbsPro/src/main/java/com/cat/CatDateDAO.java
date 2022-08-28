package com.cat;

import java.sql.SQLException;
import java.util.List;

public interface CatDateDAO {

	
	// ① 중분류일정 등록 메뉴
	public int insertCatDate(CatDateDTO dto) throws SQLException; // 중분류 등록
	
	// ② 중분류일정 수정 메뉴
	public int updateCatDate(CatDateDTO dto) throws SQLException; // 중분류 수정
	
	// ② 중분류실적종료일 추가 메뉴
	public int updateCatDateEnd(CatDateDTO dto) throws SQLException; // 중분류실적종료일 추가
	
	// ④ 중분류일정 삭제 메뉴
	public int deleteCatDate(String cat_date) throws SQLException; // 중분류 삭제

	
	
	
	
	
	// ⑤ 작업 검색 메뉴
	
	// 코드명 검색
	public CatDateDTO searchCatDateCode(CatDateDTO dto) ;
	
	
	// 작업명 검색
	public List<CatDateDTO> searchCatDateName(String CatDate_name) ;

	
	
	// 담당자명 검색
	public List<CatDateDTO> searchCatDateManager(String CatDate_manager);
	
	
	// 날짜 검색
	public List<CatDateDTO> searchCatDateDate(String CatDate_date);

	
	
	// 전체 작업 목록
	public List<CatDateDTO> searchCatDateAll(String CatDate_date);

	
	
	
	
	// ⑤ 업무 구성비 관리
	
	  // 업무 구성비 등록
	public int workCompInsertCatDate(int input) throws SQLException;
	
	
	  // 업무 구성비 수정
	public int workCompUpdateCatDate(int input) throws SQLException; 
	
	
	
}
