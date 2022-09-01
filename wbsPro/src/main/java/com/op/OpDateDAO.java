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

	// ④ 작업 검색 메뉴

	// 코드명 검색
	public OpDateDTO searchOpDateCode(int Op_date);

	// 작업명 검색
	public List<OpDateDTO> searchOpDateName(String op_name);

	// 담당자명 검색
	public List<OpDateDTO> searchOpDateManager(String OpDate_manager);

	// 날짜 검색
	public List<OpDateDTO> searchOpDateDate(String OpDate_date);

	// 전체 작업 목록
	public List<OpDateDTO> searchOpDateAll(String OpDate_date);

	// ⑤ 업무 구성비 관리

	// 업무 구성비 등록
	public int workCompInsertOpDate(int input) throws SQLException;

	// 업무 구성비 수정
	public int workCompUpdateOpDate(int input) throws SQLException;

	// 소분류 자동 코드 부여
	public OpDateDTO findOp(int opCode);

}
