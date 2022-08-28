package com.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;


public class EmployeeDAOImpl implements EmployeeDAO {
	private Connection conn = DBConn.getConnection(); // 커넥션 객체 생성
	
	public int insertEmployee(EmployeeDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = " INSERT INTO EMPLOYEE(USER_CODE, USER_NAME, USER_RRN, USER_TEL, "
				+ " USER_ADDRESS, DATE_ENTRY, DUTY, RESIGN_DATE, PWD) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, NVL(?,null), NVL(?,1234))";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getUser_code());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getRrn());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getHireDate());
			pstmt.setString(7, dto.getDuty());
			pstmt.setString(8, dto.getResigndate());
			pstmt.setString(9, dto.getPwd());
			
			result = pstmt.executeUpdate(); // executeUpdate() : 실행할 때마다 1씩 증가
			
		} catch (SQLIntegrityConstraintViolationException e) { 
			// 무결성 제약 위반
			if(e.getErrorCode() == 1) { 
				System.out.println("사원번호 중복입니다.");
			} else if(e.getErrorCode() == 1400) {
				// NOT NULL 제약 위반
				System.out.println("필수 사항을 입력하지 않았습니다.");
			} else {
				System.out.println(e.toString());
			}
			throw e;
		} catch (SQLDataException e) {
			if(e.getErrorCode() == 1840 || e.getErrorCode() == 1861) {
				System.out.println("날짜입력 형식 오류입니다.");
			} else {
				System.out.println(e.toString());
			}
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			} 
		}
		
		return result;
	}

	public int updateEmployee(EmployeeDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "UPDATE EMPLOYEE SET USER_NAME = ?, USER_TEL = ?, USER_ADDRESS = ?, "
					   + " DATE_ENTRY = ?, DUTY = ?, RESIGN_DATE = ? WHERE USER_CODE = ? AND PWD = ? ";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getTel());
				pstmt.setString(3, dto.getAddress());
				pstmt.setString(4, dto.getHireDate());
				pstmt.setString(5, dto.getDuty());
				pstmt.setString(6, dto.getResigndate());
				pstmt.setInt(7, dto.getUser_code());
				pstmt.setString(8, dto.getPwd());
				
				result = pstmt.executeUpdate();
				
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1400) { // NOT NULL 제약 위반
				System.out.println("필수 사항을 입력하지 않았습니다.");
			} else {
				System.out.println(e.toString());
			}
			throw e;
		} catch (SQLDataException e) {
			if(e.getErrorCode() == 1840 || e.getErrorCode() == 1861) {
				System.out.println("날짜입력 형식 오류입니다.");
			} else {
				System.out.println(e.toString());
			}
			throw e;
		} catch (SQLException e) {
			// ORA-12899 : 문자열 입력 값보다 열폭이 큰경우
			e.printStackTrace();
			throw e;
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
		
		
		return result;
	}

	public int deleteEmployee(String id) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "DELETE FROM EMPLOYEE WHERE USER_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			}
		}
		
		return result;
	}

	public EmployeeDTO readEmployee(String id) {
		EmployeeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "SELECT user_code, user_name, user_rrn, user_tel, user_address, TO_CHAR(date_entry, "
				+ "'YYYY-MM-DD') date_entry , duty, resign_date FROM employee WHERE USER_CODE = ? ";
				
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(); // executeQuery() : 반환 타입이 ResultSet
			
			if(rs.next()) {
				dto = new EmployeeDTO();
				
				dto.setUser_code(rs.getInt("user_code"));
				dto.setName(rs.getString("user_name"));
				dto.setRrn(rs.getString("user_rrn"));
				dto.setTel(rs.getString("user_tel"));
				dto.setAddress(rs.getString("user_address"));
				dto.setHireDate(rs.getString("date_entry"));
				dto.setDuty(rs.getString("duty"));
				dto.setResigndate(rs.getString("resign_date"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			}
		}
		
		
		return dto;
	}

	@Override
	public List<EmployeeDTO> listEmployee() { // 사원 테이블 전체 출력
		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql;
		
		try {
			
			sql = "SELECT user_code, user_name, user_rrn, user_tel, user_address, TO_CHAR(date_entry, "
					+ "'YYYY-MM-DD') date_entry , duty, resign_date FROM employee ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new EmployeeDTO();
				
				dto.setUser_code(rs.getInt("user_code"));
				dto.setName(rs.getString("user_name"));
				dto.setRrn(rs.getString("user_rrn"));
				dto.setTel(rs.getString("user_tel"));
				dto.setAddress(rs.getString("user_address"));
				dto.setHireDate(rs.getString("date_entry"));
				dto.setDuty(rs.getString("duty"));
				dto.setResigndate(rs.getString("resign_date"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			}
		}
		
		
		return list;
	}

	

	@Override
	public List<EmployeeDTO> searchName(String name) {
		
		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql;
		
		try {
			
			
			sql = "SELECT user_code, user_name, user_rrn, user_tel, user_address, TO_CHAR(date_entry, "
					+ "'YYYY-MM-DD') date_entry , duty, resign_date FROM employee WHERE USER_NAME = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new EmployeeDTO();
				
				dto.setUser_code(rs.getInt("user_code"));
				dto.setName(rs.getString("user_name"));
				dto.setRrn(rs.getString("user_rrn"));
				dto.setTel(rs.getString("user_tel"));
				dto.setAddress(rs.getString("user_address"));
				dto.setHireDate(rs.getString("date_entry"));
				dto.setDuty(rs.getString("duty"));
				dto.setResigndate(rs.getString("resign_date"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			}
		}
		
		
		return list;
	}

	
}
