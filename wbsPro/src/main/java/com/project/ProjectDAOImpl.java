package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class ProjectDAOImpl implements ProjectDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertProject(ProjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			conn.setAutoCommit(false);

			sql = "INSERT INTO project(PRJ_CODE, PRJ_NAME, PRJ_OV, PRJ_PLAN, OC_CODE, prj_plan_start, prj_plan_end) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getPrj_code()); // 프로젝트 코드
			pstmt.setString(2, dto.getPrj_name()); // 프로젝트명
			pstmt.setString(3, dto.getPrj_ov()); // 프로젝트 개요
			pstmt.setString(4, dto.getPrj_plan()); // 프로젝트 설명
			pstmt.setInt(5, dto.getOc_code());// 업체 코드
			pstmt.setString(6, dto.getPrj_plan_start());
			pstmt.setString(7, dto.getPrj_plan_end());

			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = "INSERT INTO PROCHARGE(PRJ_CODE, user_code) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrj_code()); // 프로젝트 코드
			pstmt.setInt(2, dto.getUser_code());// 사원코드

			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit(); // 커밋

		} catch (SQLIntegrityConstraintViolationException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {

			}
			// 기본키 제약 위반, NOT NULL 등의 제약 위반
			if (e.getErrorCode() == 1) {
				System.out.println("코드 중복으로 등록이 불가능합니다");

			} else if (e.getErrorCode() == 1400) {
				System.out.println("필수 입력 사항을 입력하지 않았습니다 ");

			} else if (e.getErrorCode() == 2291) {// 무결성 제약조건
				System.out.println("등록되지않은 업체 코드 혹은 담당자 코드입니다.");

			} else {
				System.out.println(e.toString());
			}

		} catch (SQLDataException e2) {
			try {
				conn.rollback();
			} catch (Exception e) {

			}

			if (e2.getErrorCode() == 1840) {
				System.out.println("입력된 날짜가 형식에 부적합합니다.");

			}
		} catch (SQLException e2) {
			try {
				conn.rollback();
			} catch (Exception e) {

			}

			if (e2.getErrorCode() == 1) {
				System.out.println("코드 중복으로 등록이 불가능합니다");
			} else if (e2.getErrorCode() == 1400) {
				System.out.println("필수사항을 입력하지않았습니다.");
			} else if (e2.getErrorCode() == 2291) {
				System.out.println("등록되지않은 업체 코드 혹은 담당자 코드입니다.");
			} else {
				System.out.println(e2.toString()); // 오류메세지 찍기
			}
			throw e2;

		} catch (Exception e2) {
			e2.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}

			try {
				// 다시 커밋되도록 설정
				conn.setAutoCommit(true);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return result;

	}

	@Override
	public int updateProject(ProjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {

			conn.setAutoCommit(false);

			sql = "UPDATE project SET Prj_name = ?, Prj_ov = ?, Prj_plan = ?, OC_CODE = ?, prj_plan_start = ?,  prj_plan_end = ?  WHERE Prj_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPrj_name()); // 프로젝트명
			pstmt.setString(2, dto.getPrj_ov()); // 프로젝트 개요
			pstmt.setString(3, dto.getPrj_plan()); // 프로젝트 설명
			pstmt.setInt(4, dto.getOc_code());// 업체 코드
			pstmt.setString(5, dto.getPrj_plan_start());
			pstmt.setString(6, dto.getPrj_plan_end());
			pstmt.setInt(7, dto.getPrj_code());

			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = "UPDATE PROCHARGE set   user_code = ? WHERE Prj_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_code());// 사원코드
			pstmt.setInt(2, dto.getPrj_code()); // 프로젝트 코드

			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit(); // 커밋

		} catch (SQLIntegrityConstraintViolationException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {

			}

			if (e.getErrorCode() == 1400) {
				System.out.println("필수사항을 입력하지않았습니다.");
			} else if (e.getErrorCode() == 2291) {
				System.out.println("등록되지않은 업체 코드 혹은 담당자 코드입니다.");
			}
		} catch (SQLDataException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {

			}

			if (e.getErrorCode() == 1840) {
				System.out.println("입력된 날짜가 형식에 부적합합니다.");

			}
		} catch (SQLException e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			if (e.getErrorCode() == 1400) {
				System.out.println("필수사항을 입력하지않았습니다.");
			} else if (e.getErrorCode() == 2291) {
				System.out.println("등록되지않은 업체 코드 혹은 담당자 코드입니다.");
			}

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}
		try {
			conn.setAutoCommit(true);
		} catch (Exception e) {

		}

		return result;
	}

	@Override
	public int deleteProject(int project_Code) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			conn.setAutoCommit(false);

			sql = "DELETE FROM PROCHARGE WHERE prj_code = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, project_Code);

			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = "DELETE FROM project WHERE prj_code = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, project_Code);

			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {

			}

			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}

			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {

			}
		}

		return result;
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
