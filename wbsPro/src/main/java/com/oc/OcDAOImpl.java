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

	@Override // 발주업체 등록
	public int insertOc(OcDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = " INSERT INTO Oc (oc_code,oc_name,oc_tel) VALUES (?,?,?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getOc_code());
			pstmt.setString(2, dto.getOc_name());
			pstmt.setString(3, dto.getOc_tel());

			pstmt.executeUpdate();

			// 업체 코드 중복일 경우 예외처리 하기
		} catch (SQLIntegrityConstraintViolationException e) {

			if (e.getErrorCode() == 1400) {
				System.out.println(" 업체 이름 혹은 코드를 입력하지 않았습니다. ");
			} else if (e.getErrorCode() == 1) {
				System.out.println(" 업체 코드 중복으로 등록이 불가능합니다.");
			} else {
				System.out.println(e.toString());
			}

			throw e;

		} catch (Exception e) {

		}

		return result;
	}

	@Override
	public int deleteOc(int oc_code) throws SQLException {
		OcDTO dto = new OcDTO();
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "DELETE FROM Oc WHERE Oc_code = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, oc_code);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

				}
			}
		}

		return result;
	}

	@Override // 이름 검색
	public List<OcDTO> searchOcName(String oc_name) {
		List<OcDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {

			sql = " SELECT Oc_name, Oc_code , Oc_tel" + " FROM Oc" + " WHERE Oc_name = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, oc_name);

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
	public List<OcDTO> searchOcCode(int oc_code) {
		List<OcDTO> list = new ArrayList<>();
		OcDTO dto = new OcDTO();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {

			sql = " SELECT oc_name, oc_code, oc_tel FROM Oc WHERE oc_code = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, oc_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new OcDTO();
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

	@Override // 전체 리스트 출력
	public List<OcDTO> ListOc() {
		List<OcDTO> list = new ArrayList<>();
		OcDTO dto = new OcDTO();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {

			sql = "SELECT * FROM Oc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				dto = new OcDTO();

				dto.setOc_name(rs.getString("oc_name"));
				dto.setOc_code(rs.getInt("oc_code"));
				dto.setOc_tel(rs.getString("oc_tel"));

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

	@Override // 정보수정
	public int updateOc(OcDTO dto) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = " UPDATE Oc SET oc_name= ?, oc_tel =?  WHERE oc_code =? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getOc_name());
			pstmt.setString(2, dto.getOc_tel());
			pstmt.setInt(3, dto.getOc_code());

			result = pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {

			if (e.getErrorCode() == 1400) {
				System.out.println(" 업체 이름 혹은 코드를 입력하지 않았습니다. ");
			} else {
				System.out.println(e.toString());
			}

			throw e;

		} catch (Exception e) {

		}

		return result;
	}

}
