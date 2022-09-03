package com.cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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

			// catdate 추가 sql
			sql = " INSERT INTO catdate(sub_date_code, cat_date, cat_name, cat_plan_start, cat_plan_end) VALUES(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code()); // 대분류 일정코드
			pstmt.setInt(2, dto.getCat_date()); // 중분류 일정코드
			pstmt.setString(3, dto.getCat_name()); // 중분류 일정명
			pstmt.setString(4, dto.getCat_plan_start()); // 중분류계획시작일
			pstmt.setString(5, dto.getCat_plan_end()); // 중분류계획종료일
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = " INSERT INTO catcharge(cat_date, user_code) VALUES(?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCat_date()); // 대분류 일정코드
			pstmt.setInt(2, dto.getUser_code()); // 중분류 일정코드
			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit(); // 커밋

		} catch (SQLIntegrityConstraintViolationException e) {

			// 롤백
			try {

				conn.rollback();
			} catch (Exception e2) {

			}
			if (e.getErrorCode() == 1) {
				System.out.println("코드 중복으로 등록이 불가능합니다");
			} else if (e.getErrorCode() == 1400) {
				System.out.println("필수사항을 입력하지않았습니다.");
			} else if (e.getErrorCode() == 2291) {
				System.out.println("대분류 코드를 잘못입력했습니다");
			} else {
				System.out.println(e.toString()); // 오류메세지 찍기
			}
			throw e;

		} catch (SQLDataException e2) {
			try {
				conn.rollback();
			} catch (Exception e3) {
			}

			if (e2.getErrorCode() == 1840 || e2.getErrorCode() == 1861) {
				System.out.println("입력된 값이 날짜 형식에 맞지않거나 타입이 다릅니다.");
			} else {
				System.out.println(e2.toString());
			}
			throw e2;

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
			}

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

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
	public int updateCatDate(CatDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			// 중분류일정 수정 sql

			conn.setAutoCommit(false);

			sql = "UPDATE catdate SET cat_name = ? , cat_plan_start = ? , cat_plan_end = ? WHERE cat_date = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getCat_name()); // 중분류 일정명
			pstmt.setString(2, dto.getCat_plan_start()); // 중분류계획시작일
			pstmt.setString(3, dto.getCat_plan_end()); // 중분류계획종료일
			pstmt.setInt(4, dto.getCat_date()); // 중분류 일정코드

			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = "UPDATE catcharge SET user_code  = ? WHERE cat_date = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getUser_code()); // 중분류 일정코드
			pstmt.setInt(2, dto.getCat_date()); // 중분류 일정코드

			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit(); // 커밋

		} catch (SQLIntegrityConstraintViolationException e) {

			try {
				conn.rollback();
			} catch (Exception e2) {

			}

			if (e.getErrorCode() == 1) {
				System.out.println("중분류일정 코드 중복입니다.");
			}
		} catch (SQLException e) {
			conn.rollback();

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
	public int deleteCatDate(int cat_date) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			conn.setAutoCommit(false);

			sql = " DELETE FROM catdate WHERE cat_date = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cat_date);
			result = pstmt.executeUpdate();
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
	public CatDateDTO findCat(int subCode) {
		// 입력한 프로젝트에 해당하는 가장 큰 중분류 값 찾기
		CatDateDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql =  "SELECT MAX(cat_date) nextCat FROM catdate WHERE sub_date_code =  ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subCode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new CatDateDTO();
				dto.setCat_date(rs.getInt("nextCat"));
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

}
