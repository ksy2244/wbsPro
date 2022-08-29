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
	// 	private ProjectDAO dao = new ProjectDAOImpl();

	public List<PlanDTO> listAll(int prj_code) throws SQLException {
		// 프로젝트 번호를 입력 받아 해당하는 프로젝트의 프로젝트 번호, 프로젝트 이름, 대분류 코드, 대분류 이름 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<PlanDTO> list = new ArrayList<>();

		System.out.println("sql 시작 전");

		try {
			sql = "SELECT p.prj_code, p.prj_name, s.sub_date_code, s.sub_name "
					+ "FROM project p "
					+ "LEFT OUTER JOIN subdate s "
					+ "ON p.prj_code = s.prj_code "
					+ "WHERE p.prj_code = ? "
					+ "GROUP BY  p.prj_code, p.prj_name, s.sub_date_code, s.sub_name "
					+ "ORDER BY  p.prj_code, s.sub_date_code ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prj_code); 
			rs = pstmt.executeQuery();
		

			while (rs.next()) {
				PlanDTO dto = new PlanDTO();
				dto.setPrj_code(rs.getInt("prj_code"));
				dto.setPrj_name(rs.getString("prj_name"));
				dto.setSub_date_code(rs.getInt("sub_date_code"));
				dto.setSub_name(rs.getString("sub_name"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
