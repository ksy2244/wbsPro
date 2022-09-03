package com.op;

import java.sql.SQLException;
import java.util.List;

import com.cat.CatDateDTO;

public interface OpDateDAO {

	// ① 작업 등록 메뉴
	public int insertOpDate(OpDateDTO dto) throws SQLException; // 소분류 등록

	// ② 작업 수정 메뉴
	public int updateOpDate(OpDateDTO dto) throws SQLException; // 소분류 수정

	// ③ 작업 삭제 메뉴
	public int deleteOpDate(int Op_date) throws SQLException; // 소분류 삭제

	// ⑤ 업무 구성비 관리

	// 업무 구성비 등록
	public int workCompInsertOpDate(int input) throws SQLException;

	// 업무 구성비 수정
	public int workCompUpdateOpDate(int input) throws SQLException;

	// 소분류 자동 코드 부여
	public OpDateDTO findOp(int opCode);

}
