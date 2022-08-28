package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.util.DBConn;

public class SubjectDAOImpl implements SubjectDAO{
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertSubject(SubjectDTO dto) throws SQLException {
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
			sql = "INSERT INTO subdate(prj_code, sub_date_code, sub_name)"
					+ "VALUES(?,?,?)"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrj_code()); // 대분류 코드
			pstmt.setInt(2, dto.getSub_code()); // 대분류 코드
			pstmt.setString(3, dto.getSub_name()); // 대분류명
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			conn.commit(); // 커밋
			System.out.println("대분류 추가");


		} catch (SQLException e) {
			// 롤백
			try {
				conn.rollback();
			} catch (Exception e2) {

			}
			System.out.println("대분류 등록 실패");
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
				// 다시 커밋되도록 설정
				conn.setAutoCommit(true);
			} catch (Exception e) {
				// TODO: handle exception
			}

			DBConn.close();
		}
		return 0;

	}
	
	@Override
	public int updateSubject(SubjectDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSubject(int subject_Code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
