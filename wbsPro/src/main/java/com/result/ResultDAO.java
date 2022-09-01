package com.result;

import java.sql.SQLException;

import com.subject.SubjectDTO;
import com.cat.CatDateDTO;
import com.op.OpDateDTO;

public interface ResultDAO { // 실적 관리
	
	// 실적 진척율
	// 하위 분류 퍼센트 다 더해서 나눈 것(평균)이 상위분류 퍼센트! 
	// public int perforProgressProjectUpdate(int prj_code) throws SQLException; // 프로젝트 실적 진척율 수정
	// public int perforProgressSubjectUpdate(int sub_date_code) throws SQLException; // 대분류 실적 진척율 수정
	// public int perforProgressAllUpdate(int cat_date, int op_date, int op_date_per) throws SQLException; // 중분류 실적 진척율 수정
	public int perforProgressOpDateUpdate(int op_date, int performOpDate) throws SQLException; // 소분류 실적 진척율 수정
	
	
	// 업무 구성비
	public int workCompositionOpDate(int codeCatDate, int codeOpDate, int comp) throws SQLException; // 소분류
	public int workCompositionCatDate(int codeSubDate, int codeCatDate, int comp) throws SQLException; // 중분류
	public int workCompositionSubDate(int codeProject, int codeSubDate, int comp) throws SQLException; // 대분류
	
	
	
	// 프로젝트 실적 시작일 
	public int resultProgressProjectStartInput(String proDateStart) throws SQLException;
		
	// 프로젝트 실적 종료일
	public int resultProgressProjectEndInput(String proDateEnd) throws SQLException;
	
	// 대분류실적시작일시작
	public int resultProgressSubDateStartInput(SubjectDTO dto) throws SQLException;
		
	// 대분류실적종료일시작
	public int resultProgressSubDateEndInput(SubjectDTO dto) throws SQLException;
		
	// 중분류실적시작일시작
	public int resultProgressCatDateStartInput(CatDateDTO dto) throws SQLException;
		
	// 중분류실적종료일시작
	public int resultProgressCatDateEndInput(CatDateDTO dto) throws SQLException;
		
	// 소분류실적시작일시작
	public int resultProgressOpDateStartInput(OpDateDTO dto) throws SQLException;
		
	// 소분류실적종료일시작
	public int resultProgressOpDateEndInput(OpDateDTO dto) throws SQLException;


}
