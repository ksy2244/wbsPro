package com.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cat.CatDateDTO;
import com.op.OpDateDTO;
import com.subject.SubjectDTO;

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

	@Override // 대분류 실적시작일
	public int resultProgressSubDateStartInput(SubjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			// 대분류일정 수정 sql
			sql = "UPDATE subdate SET sub_start = ? WHERE sub_date_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSub_start()); // 대분류실적시작일
			pstmt.setInt(2, dto.getSub_date_code()); // 대분류 코드
			pstmt.executeUpdate();
			
			System.out.println("대분류실적시작일 추가");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}


	
	@Override // 대분류 실적종료일시작
	public int resultProgressSubDateEndInput(SubjectDTO dto) throws SQLException{
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			// 대분류일정 수정 sql
			sql = "UPDATE subdate SET sub_end = ? WHERE sub_date_code = ? AND sub_start is not null";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSub_end()); // 대분류실적종료일
			pstmt.setInt(2, dto.getSub_date_code()); // 대분류 코드
			result = pstmt.executeUpdate();
			
			System.out.println("대분류실적종료일 추가");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override // 중분류 실적시작일
	public int resultProgressCatDateStartInput(CatDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			// 중분류일정 수정 sql
			sql = "UPDATE catdate SET cat_start = ? WHERE cat_date = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getCat_start()); // 중분류실적시작일
			pstmt.setInt(2, dto.getCat_date()); // 중분류 코드
			pstmt.executeUpdate();
			
			System.out.println("중분류실적시작일 추가");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	
	@Override // 중분류실적종료일시작
	public int resultProgressCatDateEndInput(CatDateDTO dto) throws SQLException{
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			// 중분류일정 수정 sql
			sql = "UPDATE catdate SET cat_end = ? WHERE cat_date = ? AND cat_start is not null";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getCat_end()); // 중분류실적종료일
			pstmt.setInt(2, dto.getCat_date()); // 중분류 코드
			pstmt.executeUpdate();
			
			System.out.println("중분류실적종료일 추가");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	@Override // 소분류 실적시작일
	public int resultProgressOpDateStartInput(OpDateDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			// 소분류일정 수정 sql
			sql = "UPDATE opdate SET op_start = ? WHERE op_date = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getOp_start()); // 소분류실적시작일
			pstmt.setInt(2, dto.getOp_date()); // 소분류 코드
			pstmt.executeUpdate();
			
			System.out.println("소분류실적시작일 추가");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	
	@Override // 소분류실적종료일시작
	public int resultProgressOpDateEndInput(OpDateDTO dto) throws SQLException{
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			//소분류일정 수정 sql
			sql = "UPDATE opdate SET op_end = ? WHERE op_date = ? AND op_start is not null";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getOp_end()); // 소분류실적종료일
			pstmt.setInt(2, dto.getOp_date()); // 소분류 코드
			pstmt.executeUpdate();
			pstmt.close();
			
			System.out.println("소분류실적종료일 추가");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
