package com.plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class PlanImpl {
	private Connection conn = DBConn.getConnection();
	// private ProjectDAO dao = new ProjectDAOImpl();

	public List<PlanDTO> listAll(int workCode) throws SQLException {
		// 프로젝트 번호를 입력 받아 해당하는 프로젝트의 프로젝트 번호, 프로젝트 이름, 대분류 코드, 대분류 이름 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<PlanDTO> list = new ArrayList<>();

		try {
			sql = "SELECT workCode, LEVEL, workName, workTerm, workPlanStart, workPlanEnd, workUserName, workPlanPer, "
					+ "workStart, workEnd, workPer, workComp, WorkPRatio, Ratio, remain " + "FROM wbs "
					+ "START WITH  workCode = ?" + "CONNECT BY prior workcode = parent ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, workCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanDTO dto = new PlanDTO();
				dto.setWorkCode(rs.getInt("workCode"));
				dto.setLevel(rs.getInt("level"));
				dto.setWorkName(rs.getString("workName"));
				dto.setWorkTerm(rs.getInt("workTerm"));
				dto.setWorkPlanStart(rs.getString("workPlanStart"));
				dto.setWorkPlanEnd(rs.getString("workPlanEnd"));
				dto.setWorkUserName(rs.getString("workUserName"));
				dto.setWorkPlanPer(rs.getInt("workPlanPer"));
				dto.setWorkStart(rs.getString("workStart"));
				dto.setWorkEnd(rs.getString("workEnd"));
				dto.setWorkPer(rs.getInt("workPer"));
				dto.setWorkComp(rs.getInt("workComp"));
				dto.setWorkPRatio(rs.getInt("WorkPRatio"));
				dto.setRatio(rs.getInt("Ratio"));
				dto.setRemain(rs.getInt("remain"));
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
			sql = "SELECT workCode, workName, workTerm, workPlanStart, workPlanEnd, workUserName, workPlanPer, "
					+ "workStart, workEnd, workPer, workComp, WorkPRatio, Ratio, remain  " + "FROM wbs "
					+ " WHERE workUserCode = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanDTO dto = new PlanDTO();
				dto.setWorkCode(rs.getInt("workCode"));
				dto.setWorkName(rs.getString("workName"));
				dto.setWorkTerm(rs.getInt("workTerm"));
				dto.setWorkPlanStart(rs.getString("workPlanStart"));
				dto.setWorkPlanEnd(rs.getString("workPlanEnd"));
				dto.setWorkUserName(rs.getString("workUserName"));
				dto.setWorkPlanPer(rs.getInt("workPlanPer"));
				dto.setWorkStart(rs.getString("workStart"));
				dto.setWorkEnd(rs.getString("workEnd"));
				dto.setWorkPer(rs.getInt("workPer"));
				dto.setWorkComp(rs.getInt("workComp"));
				dto.setWorkPRatio(rs.getInt("WorkPRatio"));
				dto.setRatio(rs.getInt("Ratio"));
				dto.setRemain(rs.getInt("remain"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<PlanDTO> listWorkCode(int workCode) throws SQLException {
		// 담당자 코드로 작업 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<PlanDTO> list = new ArrayList<>();

		try {
			sql = "SELECT workCode, workName, workTerm, workPlanStart, workPlanEnd, workUserName, workPlanPer, "
					+ "workStart, workEnd, workPer, workComp, WorkPRatio, Ratio, remain " + "FROM wbs "
					+ " WHERE workCode = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, workCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanDTO dto = new PlanDTO();
				dto.setWorkCode(rs.getInt("workCode"));
				dto.setWorkName(rs.getString("workName"));
				dto.setWorkTerm(rs.getInt("workTerm"));
				dto.setWorkPlanStart(rs.getString("workPlanStart"));
				dto.setWorkPlanEnd(rs.getString("workPlanEnd"));
				dto.setWorkUserName(rs.getString("workUserName"));
				dto.setWorkPlanPer(rs.getInt("workPlanPer"));
				dto.setWorkStart(rs.getString("workStart"));
				dto.setWorkEnd(rs.getString("workEnd"));
				dto.setWorkPer(rs.getInt("workPer"));
				dto.setWorkComp(rs.getInt("workComp"));
				dto.setWorkPRatio(rs.getInt("WorkPRatio"));
				dto.setRatio(rs.getInt("Ratio"));
				dto.setRemain(rs.getInt("remain"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
