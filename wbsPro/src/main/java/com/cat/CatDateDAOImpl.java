package com.cat;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.util.DBConn;

public class CatDateDAOImpl implements CatDateDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertCatDate(CatDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			
			conn.setAutoCommit(false);
			// 대분류일정코드 찾는 sql
			sql = "SELECT sub_date_code FROM subject WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code());
			pstmt.executeQuery();
			pstmt.close();
			pstmt = null;
			
			// catdate 추가 sql
			sql = " INSERT INTO catdate(sub_date_code, cat_date, cat_name, cat_plan_start, cat_plan_end, cat_start) VALUES(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code()); // 대분류 일정코드
			pstmt.setInt(2, dto.getCat_date()); // 중분류 일정코드
			pstmt.setString(3, dto.getCat_name()); // 중분류 일정명
			pstmt.setString(4, dto.getCat_plan_start()); // 중분류계획시작일
			pstmt.setString(5, dto.getCat_plan_end()); // 중분류계획종료일
			pstmt.setString(6, dto.getCat_start()); // 중분류실적시작일
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			conn.commit(); // 커밋
			System.out.println("중분류일정 추가");
		} catch (SQLIntegrityConstraintViolationException e){
			if(e.getErrorCode() == 1) {
				System.out.println("중분류일정 코드 중복입니다.");
			}
		} catch (SQLException e) {
			// 롤백
			try {
				conn.rollback();
			} catch (Exception e2) {
			}
			System.out.println("중분류일정 등록 실패");
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
				// 다시 커밋 되도록 설정
				conn.setAutoCommit(true);
			} catch (Exception e) {
			}	
			DBConn.close();
		}
		return result;
	}

	@Override
	public int updateCatDate(CatDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			
			conn.setAutoCommit(false);
			// 대분류일정코드 찾는 sql
			sql = "SELECT sub_date_code FROM subject WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code());
			pstmt.executeQuery();
			pstmt.close();
			pstmt = null;
			
			// 중분류일정 수정 sql
			sql = " UPDATE INTO catdate(sub_date_code, cat_date, cat_name, cat_plan_start, cat_plan_end, cat_start) VALUES(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code()); // 대분류 일정코드
			pstmt.setInt(2, dto.getCat_date()); // 중분류 일정코드
			pstmt.setString(3, dto.getCat_name()); // 중분류 일정명
			pstmt.setString(4, dto.getCat_plan_start()); // 중분류계획시작일
			pstmt.setString(5, dto.getCat_plan_end()); // 중분류계획종료일
			pstmt.setString(6, dto.getCat_start()); // 중분류실적시작일
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			conn.commit(); // 커밋
			System.out.println("중분류일정 추가");
		} catch (SQLIntegrityConstraintViolationException e){
			if(e.getErrorCode() == 1) {
				System.out.println("중분류일정 코드 중복입니다.");
			}
		} catch (SQLException e) {
			// 롤백
			try {
				conn.rollback();
			} catch (Exception e2) {
			}
			System.out.println("중분류일정 등록 실패");
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
				// 다시 커밋 되도록 설정
				conn.setAutoCommit(true);
			} catch (Exception e) {
			}	
			DBConn.close();
		}
		return result;
	}

	public int updateCatDateEnd(CatDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			
			conn.setAutoCommit(false);
			// 대분류일정코드 찾는 sql
			sql = "SELECT cat_date FROM catdate WHERE cat_date = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCat_date());
			pstmt.executeQuery();
			pstmt.close();
			pstmt = null;
			
			// 중분류실적종료일 추가 sql
			sql = " UPDATE INTO catdate(cat_end) VALUES(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCat_end()); // 중분류실적종료일
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			conn.commit(); // 커밋
			System.out.println("중분류실적종료일 추가 완료");
		} catch (SQLException e) {
			// 롤백
			try {
				conn.rollback();
			} catch (Exception e2) {
			}
			System.out.println("중분류실적종료일 추가 실패");
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
				// 다시 커밋 되도록 설정
				conn.setAutoCommit(true);
			} catch (Exception e) {
			}	
			DBConn.close();
		}
		return result;
	}
	
	@Override
	public int deleteCatDate(String catDate_Code) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "DELETE cat_date FROM catdate WHERE cat_date = ?";
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
	@Override
	public CatDateDTO searchCatDateCode(CatDateDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDateDTO> searchCatDateName(String CatDate_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDateDTO> searchCatDateManager(String CatDate_manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDateDTO> searchCatDateDate(String CatDate_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDateDTO> searchCatDateAll(String CatDate_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int workCompInsertCatDate(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int workCompUpdateCatDate(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
