package com.result;

import java.sql.SQLException;

import com.subject.SubjectDTO;
import com.cat.CatDateDTO;
import com.op.OpDateDTO;

public interface ResultDAO { // 실적 관리
	
	
	public int perforProgressInsert(int perform) throws SQLException; // 실적 진척율 입력
	public int perforProgressUpdate(int perform) throws SQLException; // 실적 진척율 수정
	public int perforProgressDelete(int perform) throws SQLException; // 실적 진척율 삭제
	
	
	public int workCompositionOpDate(int codeCatDate, int codeOpDate, int comp) throws SQLException; // 소분류
	public int workCompositionCatDate(int codeSubDate, int codeCatDate, int comp) throws SQLException; // 중분류
	public int workCompositionSubDate(int codeProject, int codeSubDate, int comp) throws SQLException; // 대분류
	
	
	// 대분류실적시작일시작
		public int ResultProgressSubDateStartInput(SubjectDTO dto) throws SQLException;
		
		// 대분류실적종료일시작
		public int ResultProgressSubDateEndInput(SubjectDTO dto) throws SQLException;
		
		// 중분류실적시작일시작
		public int ResultProgressCatDateStartInput(CatDateDTO dto) throws SQLException;
			
		// 중분류실적종료일시작
		public int ResultProgressCatDateEndInput(CatDateDTO dto) throws SQLException;
			
		// 소분류실적시작일시작
		public int ResultProgressOpDateStartInput(OpDateDTO dto) throws SQLException;
			
		// 소분류실적종료일시작
		public int ResultProgressOpDateEndInput(OpDateDTO dto) throws SQLException;
	
	
}
