package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.util.DBConn;

public class SubjectDAOImpl implements SubjectDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertSubject(SubjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {

			conn.setAutoCommit(false); // 자동 커밋 해제
			// 프로젝트 코드 찾는 sql
			sql = "SELECT prj_code FROM project WHERE prj_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrj_code());
			pstmt.executeQuery();
			pstmt.close();
			pstmt = null;

			// 대분류 추가하는 sql
			sql = "INSERT INTO subdate(prj_code, sub_date_code, sub_name)" + " VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrj_code()); // 대분류 코드
			pstmt.setInt(2, dto.getSub_date_code()); // 대분류 코드
			pstmt.setString(3, dto.getSub_name()); // 대분류명
			result = pstmt.executeUpdate();
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

			DBConn.close();
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
			sql = "UPDATE subdate SET sub_name = ? WHERE sub_date_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSub_name()); // 대분류명
			pstmt.setInt(2, dto.getSub_date_code()); // 대분류 코드
			result = pstmt.executeUpdate();

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
	public SubjectDTO searchSubjectCode(SubjectDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDTO> searchSubjectName(String Subject_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDTO> searchSubjectManager(String Subject_manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDTO> searchSubjectDate(String Subject_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDTO> searchSubjectAll(String Subject_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int workCompInsertSubject(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int workCompUpdateSubject(int input) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
