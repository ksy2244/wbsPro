package com.cat;

import java.sql.SQLException;

public interface CatDateDAO {

	// ① 중분류일정 등록 메뉴
	public int insertCatDate(CatDateDTO dto) throws SQLException; // 중분류 등록

	// ② 중분류일정 수정 메뉴
	public int updateCatDate(CatDateDTO dto) throws SQLException; // 중분류 수정

	// ④ 중분류일정 삭제 메뉴
	public int deleteCatDate(int cat_date) throws SQLException; // 중분류 삭제

	// 중분류 코드부여
	public CatDateDTO findCat(int prjCode);

}
