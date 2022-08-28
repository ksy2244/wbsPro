package com.emp;

import java.sql.SQLException;
import java.util.List;

public interface CooperationDAO {
	
	// 등록, 수정, 삭제할 때는 테이블 따로 입력받고 검색할 때만 테이블 합쳐서 출력
	
	// 1-1 등록
	public int cooperInsert(CooperationDTO dto) throws SQLException;     // 업체 등록
	public int cooperEmpInsert(CooperationDTO dto) throws SQLException;  // 업체 사원 등록
	
	
	// 2-1 수정
	public int cooperUpdate(CooperationDTO dto) throws SQLException;     // 업체 수정
	public int cooperEmpUpdate(CooperationDTO dto) throws SQLException;  // 업체 사원 수정
	
	
	// 3-1-1 업체 삭제
	public int cooperDeleteCode(String cooperCode) throws SQLException; // 업체 코드 받아 삭제
	public int cooperDeleteName(String cooperName) throws SQLException; // 업체 이름 받아 삭제
	
	
	// 3-1-2 업체 사원 삭제 
	public int cooperEmpDeleteCode(String cooperEmpCode) throws SQLException; // 업체 사원 코드 받아 삭제
	// public int cooperEmpDeleteName(String cooperEmpName) throws SQLException; // 업체 사원 이름 받아 삭제
 	// 업체 사원 이름 필드가 없음
	
	// 4-1-1 업체 조회
	public List<CooperationDTO> cooperSearchCode(String cooperCode);       // 업체 코드 조회
	public List<CooperationDTO> cooperSearchName(String cooperName); // 업체명 조회
	public List<CooperationDTO> cooperSearchAll();  // 전체 업체 조회
	
	
	// 4-1-2 업체 사원 조회
	public CooperationDTO cooperSearchEmpCode(String cooperEmpCode);       // 업체 사원코드 조회
	// public List<CooperationDTO> cooperSearchEmpName(String cooperEmpName); // 업체 사원이름 조회
	// 업체 사원 이름 필드가 없음
}
