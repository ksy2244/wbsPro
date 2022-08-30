package com.result;

import java.sql.SQLException;

public interface ResultDAO { // 실적 관리
	
	
	public int perforProgressInsert(int perform) throws SQLException; // 실적 진척율 입력
	public int perforProgressUpdate(int perform) throws SQLException; // 실적 진척율 수정
	public int perforProgressDelete(int perform) throws SQLException; // 실적 진척율 삭제
	
	
	
	public int workCompositionOpDate(int codeCatDate, int codeOpDate, int comp) throws SQLException; // 소분류
	public int workCompositionCatDate(int codeSubDate, int codeCatDate, int comp) throws SQLException; // 중분류
	public int workCompositionSubDate(int codeProject, int codeSubDate, int comp) throws SQLException; // 대분류
	
	
}
