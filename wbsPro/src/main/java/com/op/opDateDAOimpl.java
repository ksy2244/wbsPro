package com.op;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class opDateDAOimpl implements OpDateDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertOpDate(OpDateDTO dto) throws SQLException {
	
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn.setAutoCommit(false);
			
			sql = "SELECT cat_date FROM catdate WHERE cat_date = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCat_date());
			pstmt.executeQuery();
			pstmt.close();
			pstmt = null;
			
			sql ="INSERT INTO opdate(Cat_date, op_date, op_name, op_plan_start, op_plan_end, user_name) VALUES (?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCat_date());
			pstmt.setInt(2, dto.getOp_date());
	        pstmt.setString(3, dto.getOp_name());
	        pstmt.setString(4, dto.getOp_plan_start());
	        pstmt.setString(5, dto.getOp_plan_end());
	        pstmt.setString(6, dto.getUser_name());
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	        pstmt = null;
			
			conn.commit();
			
			System.out.println("소분류일정 추가");

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {

			}

			System.out.println("소분류일정 등록 실패");
		} catch (Exception e2) {
			e2.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

				}

			}
			try {

				conn.setAutoCommit(true);
			} catch (Exception e) {

			}

			DBConn.close();
		}

		return 0;
	}

	@Override
	public int updateOpDate(OpDateDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql; 
		
		try {
			sql = "UPDATE opdate SET op_name = ?, op_plan_start = ?, op_plan_end = ? WHERE Op_date = ?";
			
			pstmt = conn.prepareStatement(sql);
			
		
	        pstmt.setString(1, dto.getOp_name());
	        pstmt.setString(2, dto.getOp_plan_start());
	        pstmt.setString(3, dto.getOp_plan_end());
	        pstmt.setInt(4, dto.getOp_date());
	        
	        pstmt.executeUpdate();
	        pstmt.close();
		
	    	System.out.println("소분류일정 수정 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteOpDate(int Op_date) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "DELETE FROM opdate WHERE Op_date = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Op_date);

		
			result = pstmt.executeUpdate();

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return result;
	}

	@Override
	public OpDateDTO searchOpDateCode(int Op_date) {
		OpDateDTO dto = new OpDateDTO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "SELECT op_date, op_name, op_plan_start, op_plan_end FROM opdate where op_date = ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Op_date);
			rs = pstmt.executeQuery();
		
			
			if(rs.next()) {
				dto = new OpDateDTO();
				dto.setOp_date(rs.getInt("Op_date"));
				dto.setOp_name(rs.getString("Op_name"));
				dto.setOp_plan_start(rs.getString("getOp_plan_start"));
				dto.setOp_plan_end(rs.getString("Op_plan_end"));
				
				
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
	public List<OpDateDTO> searchOpDateName(String op_name) {
	List<OpDateDTO> list = new ArrayList<>();
	PreparedStatement pstmt = null;
	String sql;
	ResultSet rs = null;
	
	try {

		sql = " SELECT op_date, op_name, op_plan_start, op_plan_end FROM opdate where op_name = ? ";
		
		
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, op_name);

		rs = pstmt.executeQuery();

		
		if(rs.next()) {
			OpDateDTO dto = new OpDateDTO();
			dto.setOp_date(rs.getInt("Op_date"));
			dto.setOp_name(rs.getString("Op_name"));
			dto.setOp_plan_start(rs.getString("getOp_plan_start"));
			dto.setOp_plan_end(rs.getString("Op_plan_end"));
			list.add(dto);
			
		}
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
		return list;
	}

	@Override
	public List<OpDateDTO> searchOpDateManager(String OpDate_manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpDateDTO> searchOpDateDate(String OpDate_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpDateDTO> searchOpDateAll(String OpDate_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int workCompInsertOpDate(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int workCompUpdateOpDate(int input) throws SQLException { 
		// TODO Auto-generated method stub
		return 0;
	}

}
