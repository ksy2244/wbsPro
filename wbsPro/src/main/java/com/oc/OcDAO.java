package com.oc;

import java.sql.SQLException;
import java.util.List;

public interface OcDAO {
	
	// 발주업체 등록,수정,삭제,조회
	
	// (1). 등록 
	public int insertOc(OcDTO dto) throws SQLException;
	
	// (2). 수정
	public int updateOc(OcDTO dto) throws SQLException; // 이름 수정 
	
	// (3). 삭제
	public int deleteOc(int oc_code) throws SQLException;
	
	// (4). 조회
	public List<OcDTO> searchOcName(String oc_name);// 발주업체명 조회
	public List<OcDTO> searchOcCode(int oc_code); // 발주업체 코드 조회 
	public List<OcDTO> ListOc(); // 전체 발주업체 조회

	

	

	
	

}
