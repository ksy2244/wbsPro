package com.emp;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	public int insertEmployee(EmployeeDTO dto) throws SQLException;

	public int updateEmployee(EmployeeDTO dto) throws SQLException;

	public int deleteEmployee(String id) throws SQLException;

	public int updatePwd(EmployeeDTO dto) throws SQLException;

	public EmployeeDTO readEmployee(String id); // 사원번호 조회

	public List<EmployeeDTO> listEmployee(); // 전체 사원 조회

	public List<EmployeeDTO> searchName(String name); // 이름으로 조회

}
