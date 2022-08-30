package com.oc;

import java.sql.SQLException;
import java.util.List;

public interface OcDAO {
	
	// 발주업체 등록,수정,삭제,조회
	
	// (1). 등록 
	public int InsertOc(OcDTO dto) throws SQLException;
	
	// (2). 수정
	public int UpdateOcName(OcDTO dto) throws SQLException; // 이름 수정 
	public int UpdateOcCode(OcDTO dto) throws SQLException; // 코드 수정 
	public int UpdateOcTel(OcDTO dto) throws SQLException;// 전화번호 수정 
	

	// (3). 삭제
	public int DeleteOc(OcDTO dto) throws SQLException; // 코드 입력시 삭제됨
	
	
	// (4). 조회
	public List<OcDTO> OcNameSearch(String Oc_name)throws SQLException;// 발주업체명 조회
	public List<OcDTO> OcTelSearch(String Oc_tel)throws SQLException;// 발주업체 전화번호 조회
	public OcDTO OcCodeSearch(Integer Oc_code)throws SQLException;  // 발주업체 코드 조회

	
	

	

	
	

}
