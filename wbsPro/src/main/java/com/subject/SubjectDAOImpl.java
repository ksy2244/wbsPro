package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.util.DBConn;

public class SubjectDAOImpl implements SubjectDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertSubject(SubjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {

			conn.setAutoCommit(false); // 자동 커밋 해제
			// 대분류 추가하는 sql
			sql = "INSERT INTO subdate(prj_code, sub_date_code, sub_name, sub_plan_start, sub_plan_end)" + " VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrj_code()); // 프로젝트 코드
			pstmt.setInt(2, dto.getSub_date_code()); // 대분류 코드
			pstmt.setString(3, dto.getSub_name()); // 대분류명
			pstmt.setString(4, dto.getSub_plan_start()); // 대분류 시작일
			pstmt.setString(5, dto.getSub_plan_end()); // 대분류 종료일
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			// 담당자 추가
			sql = "INSERT INTO subcharge(sub_date_code, user_code) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code()); // 대분류 코드
			pstmt.setInt(2, dto.getUser_code()); // 담당자 코드
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
				System.out.println("프로젝트 코드를 잘못입력했습니다");
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
	public int updateSubject(SubjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			// 대분류일정 수정 sql
			sql = "UPDATE subdate SET sub_name = ? sub_plan_start =? , sub_plan_end =? WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSub_name()); // 대분류명
			pstmt.setString(2, dto.getSub_plan_start()); // 대분류 계획 시작일
			pstmt.setString(3, dto.getSub_plan_end()); // 대분류 계획 종료일
			pstmt.setInt(4, dto.getSub_date_code()); // 대분류 코드
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = "UPDATE subcharge SET user_code = ? WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_code()); // 대분류명
			pstmt.setInt(2, dto.getSub_date_code()); // 대분류 코드
			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
				System.out.println("대분류일정 코드 중복입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public int deleteSubject(int sub_date_code) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {

			sql = " DELETE FROM subdate WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sub_date_code);
			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

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

	public SubjectDTO findSub(int prj) {
		// 입력한 프로젝트에 해당하는 가장 큰 대분류 값 찾기
		SubjectDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "SELECT MAX(sub_date_code) nextSub FROM subdate  WHERE prj_code = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prj);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new SubjectDTO();
				dto.setSub_date_code(rs.getInt("nextSub"));
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
