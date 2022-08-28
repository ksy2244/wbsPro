package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class ProjectDAOImpl implements ProjectDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertProject(ProjectDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "INSERT INTO project(PRJ_CODE, PRJ_NAME, PRJ_OV, PRJ_PLAN) " 
				+ "VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrj_code()); // 프로젝트 코드
			pstmt.setString(2, dto.getPrj_name()); // 프로젝트명
			pstmt.setString(3, dto.getPrj_ov()); // 프로젝트 개요
			pstmt.setString(4, dto.getPrj_plan()); // 프로젝트 설명

			pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			// 기본키 제약 위반, NOT NULL 등의 제약 위반
			if (e.getErrorCode() == 1) {
				System.out.println("코드 중복으로 등록이 불가능합니다");

			} else if (e.getErrorCode() == 1400) {
				System.out.println("필수 입력 사항을 입력하지 않았습니다 ");

			} else {
				System.out.println(e.toString());
			}
		}
		return 0;

	}

	@Override
	public int updateProject(ProjectDTO dto) throws SQLException {

		try {

			PreparedStatement pstmt = null;
			String sql;

			sql = "UPDATE project SET Prj_name = ?, Prj_ov = ?, Prj_plan = ? WHERE Prj_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPrj_name()); // 프로젝트명
			pstmt.setString(2, dto.getPrj_ov()); // 프로젝트 개요
			pstmt.setString(3, dto.getPrj_plan()); // 프로젝트 설명
			pstmt.setInt(4, dto.getPrj_code()); // 프로젝트 설명

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteProject(int project_Code) throws SQLException {
		try {

			PreparedStatement pstmt = null;
			String sql;

			sql = "DELETE FROM project WHERE prj_code = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, project_Code);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return 0;
	}

	@Override
	public ProjectDTO searchProjectCode(int prj_code) throws SQLException {
		ProjectDTO dto = new ProjectDTO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "SELECT prj_code, prj_name, prj_ov, prj_plan " + " FROM project WHERE prj_code = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prj_code);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new ProjectDTO();
				dto.setPrj_code(rs.getInt("prj_code"));
				dto.setPrj_name(rs.getString("prj_name"));
				dto.setPrj_ov(rs.getString("prj_ov"));
				dto.setPrj_plan(rs.getString("prj_plan"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return dto;
	}

	@Override
	public List<ProjectDTO> searchProjectName(String prj_name) throws SQLException {

		List<ProjectDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {

			sql = "SELECT prj_code, prj_name, prj_ov, prj_plan " + "FROM project  WHERE INSTR(prj_name, ?)>0";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, prj_name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				ProjectDTO dto = new ProjectDTO();
				dto.setPrj_code(rs.getInt("prj_code"));
				dto.setPrj_name(rs.getString("prj_name"));
				dto.setPrj_ov(rs.getString("prj_ov"));
				dto.setPrj_plan(rs.getString("prj_plan"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProjectDTO> searchProjectManager(String Project_manager) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDTO> searchProjectDate(String Project_date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDTO> searchProjectAll(String Project_date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int workCompInsertProject(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int workCompUpdateProject(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
