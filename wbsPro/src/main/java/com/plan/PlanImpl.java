package com.plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class PlanImpl {
	private Connection conn = DBConn.getConnection();
	// private ProjectDAO dao = new ProjectDAOImpl();

	public List<PlanDTO> listAll(int prj_code) throws SQLException {
		// 프로젝트 번호를 입력 받아 해당하는 프로젝트의 프로젝트 번호, 프로젝트 이름, 대분류 코드, 대분류 이름 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<PlanDTO> list = new ArrayList<>();

		try {
			sql = "SELECT workCode, LEVEL,  workPer, workName, workRes, workComp, workUserName "
					+ "FROM wbs "
					+ "START WITH workCode = ? "
					+ "CONNECT BY prior workcode = parent ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prj_code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanDTO dto = new PlanDTO();
				int tot = rs.getRow();
				dto.setWorkCode(rs.getInt("workCode"));
				dto.setLevel(rs.getInt("level"));
				dto.setWorkName(rs.getString("workName"));
				dto.setWorkPer(rs.getInt("workPer"));
				dto.setWrokRes(rs.getString("workRes"));
				dto.setWorkComp(rs.getInt("workComp"));
				dto.setWorkUserName(rs.getString("workUserName"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<PlanDTO> listWorkUser(int userCode) throws SQLException {
		// 담당자 코드로 작업 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<PlanDTO> list = new ArrayList<>();

		try {
			sql =  "SELECT workCode, workName, workPer, workRes, workComp, workUserName "
					+ "FROM wbs "
					+ " WHERE workUserCode = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanDTO dto = new PlanDTO();
				int tot = rs.getRow();
				dto.setWorkCode(rs.getInt("workCode"));
				dto.setWorkName(rs.getString("workName"));
				dto.setWorkPer(rs.getInt("workPer"));
				dto.setWrokRes(rs.getString("workRes"));
				dto.setWorkComp(rs.getInt("workComp"));
				dto.setWorkUserName(rs.getString("workUserName"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
