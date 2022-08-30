package com.oc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class OcDAOImpl implements OcDAO {

	Connection conn = DBConn.getConnection();

	@Override
	public int InsertOc(OcDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			// 발주업체 등록
			sql = " INSERT INTO Oc (oc_code,oc_name,oc_tel) VALUES (?,?,?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getOc_code());
			pstmt.setString(2, dto.getOc_name());
			pstmt.setString(3, dto.getOc_tel());

			pstmt.executeUpdate();

			// 업체 이름 중복일 경우 예외처리
		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
				System.out.println("중복된 업체 이름입니다.");
			} else if (e.getErrorCode() == 1400) {
				System.out.println("업체 이름을 입력하지 않았습니다.");
			} else {
				System.out.println(e.toString());
			}
			throw e;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}

		return result;
	}

	@Override // 이름 수정
	public int UpdateOcName(OcDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "UPDATE Oc SET oc_code = ?, oc_tel = ? WHERE oc_name = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getOc_code());
			pstmt.setString(2, dto.getOc_tel());
			pstmt.setString(3, dto.getOc_name());

			pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
				System.out.println("중복된 내용입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}

		return result;
	}

	@Override // 코드 수정 
	public int UpdateOcCode(OcDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = " UPDATE Oc SET oc_name = ?, oc_tel = ? WHERE oc_code =? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getOc_name());
			pstmt.setString(2, dto.getOc_tel());
			pstmt.setInt(3, dto.getOc_code());

			pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
				System.out.println("중복된 내용입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}

		return result;
	}

	
	@Override // 전화번호 수정
	public int UpdateOcTel(OcDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "UPDATE Oc SET oc_code = ?, oc_name = ? WHERE oc_tel = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getOc_code());
			pstmt.setString(2, dto.getOc_name());
			pstmt.setString(3, dto.getOc_tel());

			pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
				System.out.println("중복된 내용입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}

		return result;
	}

	@Override // 삭제 
	public int DeleteOc(OcDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql; 
		
		try {
			sql = "DELETE FROM Oc WHERE Oc_code = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
			
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}
		return result;
	}
	
	
	@Override // 업체명 검색 
	public List<OcDTO> OcNameSearch(String Oc_name)  { // 업체명 검색
		List<OcDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			
			sql = " SELECT Oc_name, Oc_code , Oc_tel" 
					+ "FROM Oc"
					+ "WHERE Oc_name = ? "; 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Oc_name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				OcDTO dto = new OcDTO();
				dto.setOc_name(rs.getString("Oc_name"));
				dto.setOc_code(rs.getInt("Oc_code"));
				dto.setOc_tel(rs.getString("Oc_tel"));
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (pstmt != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
		}
		return list;
	}
	
	
	@Override	// 전화번호 검색
	public List<OcDTO> OcTelSearch(String Oc_tel) {
		List<OcDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			
			sql = " SELECT Oc_name, Oc_code , Oc_tel" 
					+ "FROM Oc"
					+ "WHERE Oc_tel = ? "; 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Oc_tel);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				OcDTO dto = new OcDTO();
				dto.setOc_name(rs.getString("Oc_name"));
				dto.setOc_code(rs.getInt("Oc_code"));
				dto.setOc_tel(rs.getString("Oc_tel"));
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (pstmt != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
		}
		return list;
	}
	

	
	@Override // 코드 검색
	public OcDTO OcCodeSearch(Integer Oc_code)throws SQLException {
		OcDTO dto = new OcDTO();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			
			sql = " SELECT Oc_name, Oc_code , Oc_tel" 
					+ "FROM Oc"
					+ "WHERE Oc_code = ? "; 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,Oc_code );
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new OcDTO();
				dto.setOc_name(rs.getString("Oc_name"));
				dto.setOc_code(rs.getInt("Oc_code"));
				dto.setOc_tel(rs.getString("Oc_tel"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (pstmt != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
		}
		return dto;
		}
	}
