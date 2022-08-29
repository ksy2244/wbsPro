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

public class CooperationDAOImpl implements CooperationDAO{
	Connection conn = DBConn.getConnection();
	
	@Override
	public int cooperInsert(CooperationDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "INSERT INTO cooperation VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getCoo_code());
			pstmt.setString(2, dto.getCoo_name());
			pstmt.setString(3, dto.getCoo_tel());
			pstmt.setString(4, dto.getCoo_manager());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1) {
				System.out.println("업체번호 중복 입니다.");
			} else if(e.getErrorCode() == 1400) { // NOT NULL 제약 위반
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

	@Override
	public int cooperEmpInsert(CooperationDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "INSERT INTO COOUSER VALUES(?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getCoo_user_code());
			pstmt.setInt(2, dto.getUser_code());
			pstmt.setInt(3, dto.getCoo_code());
			pstmt.setString(4, dto.getWork_start_date());
			pstmt.setString(5, dto.getWork_end_date());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1) {
				System.out.println("업체사원번호 중복 입니다.");
			} else if(e.getErrorCode() == 1400) { // NOT NULL 제약 위반
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

	@Override
	public int cooperUpdate(CooperationDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "UPDATE COOPERATION SET coo_name = ?, coo_tel = ?, "
				+ "coo_manager = ? WHERE coo_code = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCoo_name());
			pstmt.setString(2, dto.getCoo_tel());
			pstmt.setString(3, dto.getCoo_manager());
			pstmt.setInt(4, dto.getCoo_code());
			
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

	@Override
	public int cooperEmpUpdate(CooperationDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "UPDATE COOUSER SET WORK_START_DATE = ?, WORK_END_DATE = ?, "
				+ " WHERE COO_USER_CODE = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWork_start_date());
			pstmt.setString(2, dto.getWork_end_date());
			pstmt.setInt(3, dto.getCoo_user_code());
			
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

	@Override
	public int cooperDeleteCode(String cooperCode) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "DELETE FROM COOPERATION WHERE COO_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperCode);
			
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

	@Override
	public int cooperDeleteName(String cooperName) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "DELETE FROM COOPERATION WHERE COO_NAME = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperName);
			
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

	@Override
	public int cooperEmpDeleteCode(String cooperEmpCode) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "DELETE FROM COOUSER WHERE COO_USER_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperEmpCode);
			
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
	/*   업체 사원 이름 없어 보류
	@Override
	public int cooperEmpDeleteName(String cooperEmpName) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "DELETE FROM COOUSER WHERE COO_USER_NAME = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperEmpName);
			
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
	*/

	@Override
	public List<CooperationDTO> cooperSearchCode(String cooperCode) {
		CooperationDTO dto = null;
		List<CooperationDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "SELECT cu.COO_CODE, COO_NAME, COO_TEL, COO_MANAGER, TO_CHAR(WORK_START_DATE, 'YYYY-MM-DD') WORK_START_DATE, "
				+ " TO_CHAR(WORK_END_DATE,'YYYY-MM-DD') WORK_END_DATE, USER_CODE "
				+ " FROM COOPERATION cp"
				+ " LEFT OUTER JOIN COOUSER cu ON cp.COO_CODE = cu.COO_CODE "
				+ " WHERE cu.COO_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperCode);
			
			rs = pstmt.executeQuery(); // executeQuery() : 반환 타입이 ResultSet
			
			while(rs.next()) {
				dto = new CooperationDTO();
				
				dto.setCoo_code(rs.getInt("COO_CODE")); 
				dto.setCoo_name(rs.getString("COO_NAME"));
				dto.setCoo_tel(rs.getString("COO_TEL"));
				dto.setCoo_manager(rs.getString("COO_MANAGER"));
				dto.setWork_start_date(rs.getString("WORK_START_DATE"));
				dto.setWork_end_date(rs.getString("WORK_END_DATE"));
				dto.setUser_code(rs.getInt("USER_CODE"));
				
				
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
	public List<CooperationDTO> cooperSearchName(String cooperName) {
		CooperationDTO dto = null;
		List<CooperationDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "SELECT cu.COO_CODE, COO_NAME, COO_TEL, COO_MANAGER, TO_CHAR(WORK_START_DATE, 'YYYY-MM-DD') WORK_START_DATE, "
					+ " TO_CHAR(WORK_END_DATE,'YYYY-MM-DD') WORK_END_DATE, USER_CODE "
					+ " FROM COOPERATION cp"
					+ " LEFT OUTER JOIN COOUSER cu ON cp.COO_CODE = cu.COO_CODE "
					+ " WHERE COO_NAME = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperName);
			
			rs = pstmt.executeQuery(); // executeQuery() : 반환 타입이 ResultSet
			
			while(rs.next()) {
				dto = new CooperationDTO();
				
				dto.setCoo_code(rs.getInt("COO_CODE")); 
				dto.setCoo_name(rs.getString("COO_NAME"));
				dto.setCoo_tel(rs.getString("COO_TEL"));
				dto.setCoo_manager(rs.getString("COO_MANAGER"));
				dto.setWork_start_date(rs.getString("WORK_START_DATE"));
				dto.setWork_end_date(rs.getString("WORK_END_DATE"));
				dto.setUser_code(rs.getInt("USER_CODE"));
				
				
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
	public List<CooperationDTO> cooperSearchAll() {
		CooperationDTO dto = null;
		List<CooperationDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "SELECT cu.COO_CODE, COO_NAME, COO_TEL, COO_MANAGER, TO_CHAR(WORK_START_DATE, 'YYYY-MM-DD') WORK_START_DATE, "
					+ " TO_CHAR(WORK_END_DATE,'YYYY-MM-DD') WORK_END_DATE, USER_CODE "
					+ " FROM COOPERATION cp"
					+ " LEFT OUTER JOIN COOUSER cu ON cp.COO_CODE = cu.COO_CODE ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // executeQuery() : 반환 타입이 ResultSet
			
			while(rs.next()) {
				dto = new CooperationDTO();
				
				dto.setCoo_code(rs.getInt("COO_CODE")); 
				dto.setCoo_name(rs.getString("COO_NAME"));
				dto.setCoo_tel(rs.getString("COO_TEL"));
				dto.setCoo_manager(rs.getString("COO_MANAGER"));
				dto.setWork_start_date(rs.getString("WORK_START_DATE"));
				dto.setWork_end_date(rs.getString("WORK_END_DATE"));
				dto.setUser_code(rs.getInt("USER_CODE"));
				
				
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
	public CooperationDTO cooperSearchEmpCode(String cooperEmpCode) {
		CooperationDTO dto = null;
		List<CooperationDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
		sql ="SELECT COO_USER_CODE, COO_NAME, COO_TEL, COO_MANAGER, TO_CHAR(WORK_START_DATE, 'YYYY-MM-DD') WORK_START_DATE, "
				+ " TO_CHAR(WORK_END_DATE,'YYYY-MM-DD') WORK_END_DATE, USER_CODE "
				+ " FROM COOPERATION cp"
				+ " LEFT OUTER JOIN COOUSER cu ON cp.COO_CODE = cu.COO_CODE "
				+ " WHERE COO_USER_CODE = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperEmpCode);
			
			rs = pstmt.executeQuery(); // executeQuery() : 반환 타입이 ResultSet
			
			if(rs.next()) {
				dto = new CooperationDTO();
				
				dto.setCoo_user_code(rs.getInt("COO_USER_CODE")); 
				dto.setCoo_name(rs.getString("COO_NAME"));
				dto.setCoo_code(rs.getInt("COO_USER_CODE")); 
				dto.setCoo_manager(rs.getString("COO_MANAGER"));
				dto.setCoo_tel(rs.getString("COO_TEL"));
				dto.setWork_start_date(rs.getString("WORK_START_DATE"));
				dto.setWork_end_date(rs.getString("WORK_END_DATE"));
				dto.setUser_code(rs.getInt("USER_CODE"));
				
				
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
		
		
		return dto;
	}
/*
	@Override // 이름 없어 보류
	public List<CooperationDTO> cooperSearchEmpName(String cooperEmpName) {
		CooperationDTO dto = null;
		List<CooperationDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "SELECT COO_CODE, COO_NAME, COO_USER_CODE, WORK_START_DATE, "
				+ " WORK_END_DATE, USER_CODE"
				+ " FROM COOPERATION cp"
				+ " LEFT OUTER JOIN COOUSER cu ON cp.COO_CODE = cu.COO_CODE "
				+ " WHERE COO_USER_NAME = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cooperEmpName);
			
			rs = pstmt.executeQuery(); // executeQuery() : 반환 타입이 ResultSet
			
			if(rs.next()) {
				dto = new CooperationDTO();
				
				dto.setCoo_code(rs.getInt("COO_CODE")); 
				dto.setCoo_name(rs.getString("COO_NAME"));
				dto.setCoo_code(rs.getInt("COO_USER_CODE")); 
				dto.setWork_start_date(rs.getString("WORK_START_DATE"));
				dto.setWork_end_date(rs.getString("WORK_END_DATE"));
				dto.setUser_code(rs.getInt("USER_CODE"));
				
				
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
*/
	

}
