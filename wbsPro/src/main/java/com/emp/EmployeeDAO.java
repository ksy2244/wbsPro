package com.emp;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeDAO  {
	public int insertEmployee(EmployeeDTO dto) throws SQLException;
	public int updateEmployee(EmployeeDTO dto) throws SQLException;
	public int deleteEmployee(String id) throws SQLException;
	
	public EmployeeDTO readEmployee(String id);
	public List<EmployeeDTO> listEmployee();
	public List<EmployeeDTO> searchName(String name); //이름으로 조회
	public List<EmployeeDTO> searchCode(String user_code); // 사원번호 조회

}
