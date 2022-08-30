package com.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConn;

public class ResultDAOImpl implements ResultDAO {
	private Connection conn = DBConn.getConnection();
	
	@Override
	public int perforProgressInsert(int perform) throws SQLException {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int perforProgressUpdate(int perform) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int perforProgressDelete(int perform) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int workCompositionOpDate(int codeCatDate ,int codeOpDate, int comp) throws SQLException {
		
		int output = 0;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			conn.setAutoCommit(false);
			
			sql = " UPDATE OPDATE SET WORK_COMP = ? WHERE OP_DATE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comp);
			pstmt.setInt(2, codeOpDate);
			pstmt.executeUpdate();
			
			pstmt.close();
			pstmt = null;
			
			// 합 100 초과했는지 확인
			
			// sql = " SELECT WORK_COMP FROM OPDATE WHERE CAT_DATE = ? ";
			sql = " SELECT SUM(WORK_COMP) WORK_COMP FROM OPDATE WHERE CAT_DATE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeCatDate);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				output = rs.getInt("WORK_COMP");
			}
			
			if(output != 100) {
				conn.rollback();
				return output;
			} else {
				conn.commit();
				conn.setAutoCommit(true);

			}
			
			
		
		} catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				
			}
			System.out.println("업무구성비 입력 실패");
		}  finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					
				}
			}
			
			try {
				// conn.setAutoCommit(true);
			} catch (Exception e) {
				
			}
			
			DBConn.close();
			
		}
		
		return output;
	}

	@Override
	public int workCompositionCatDate(int codeSubDate, int codeCatDate, int comp) throws SQLException {
		
		int output = 0;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			conn.setAutoCommit(false);
			
			sql = " UPDATE CATDATE SET CAT_COMP = ?  WHERE CAT_DATE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comp);
			pstmt.setInt(2, codeCatDate);
			pstmt.executeUpdate();
			
			pstmt.close();
			pstmt = null;
			
			// 합 100 초과했는지 확인
			
			sql = " SELECT SUM(CAT_COMP) CAT_COMP FROM CATDATE WHERE SUB_DATE_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeSubDate);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				output = rs.getInt("CAT_COMP");
			}
			
			if(output != 100) {
				conn.rollback();
				return output;
			} else {
				conn.commit();
				conn.setAutoCommit(true);

			}
			
			
		
		} catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				
			}
			System.out.println("업무구성비 입력 실패");
		}  finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					
				}
			}
			
			try {
				// conn.setAutoCommit(true);
			} catch (Exception e) {
				
			}
			
			DBConn.close();
			
		}
		
		return output;
		
	}

	@Override
	public int workCompositionSubDate(int codeProject, int codeSubDate, int comp) throws SQLException {
		
		int output = 0;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			conn.setAutoCommit(false);
			
			sql = " UPDATE SUBDATE SET SUB_COMP = ? WHERE SUB_DATE_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comp);
			pstmt.setInt(2, codeSubDate);
			pstmt.executeUpdate();
			
			pstmt.close();
			pstmt = null;
			
			
			
			// 합 100 초과했는지 확인
			
			sql = " SELECT SUM(SUB_COMP) SUB_COMP FROM SUBDATE WHERE PRJ_CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codeProject);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				output = rs.getInt("SUB_COMP");
			}
			
			if(output != 100) {
				conn.rollback();
				return output;
			} else {
				conn.commit();
				conn.setAutoCommit(true);

			}
			
			
		
		} catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				
			}
			System.out.println("업무구성비 입력 실패");
		}  finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					
				}
			}
			
			try {
				// conn.setAutoCommit(true);
			} catch (Exception e) {
				
			}
			
			DBConn.close();
			
		}
		
		return output;
		
	}

}
