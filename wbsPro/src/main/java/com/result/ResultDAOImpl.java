package com.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cat.CatDateDTO;
import com.op.OpDateDTO;
import com.project.ProjectDTO;
import com.subject.SubjectDTO;

import com.util.DBConn;

public class ResultDAOImpl implements ResultDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public ProjectDTO projectbetweenDate(int prj_code) { // 해당 프로젝트코드에 맞는 실적 시작일과 종료일 반환
		ProjectDTO dto = new ProjectDTO();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {

			sql = "SELECT TO_CHAR(PRJ_START, 'YYYY-MM-DD') PRJ_START, TO_CHAR(PRJ_END, 'YYYY-MM-DD') PRJ_END FROM project WHERE prj_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, prj_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setPrj_start(rs.getString("PRJ_START"));
				dto.setPrj_end(rs.getString("PRJ_END"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

				}
			}
		}

		return dto;
	}

	@Override
	public String ProgressStartSubDate(int subDateCode) throws SQLException {

		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		String subStart = "";

		try {

			sql = " SELECT TO_CHAR(SUB_START, 'YYYY-MM-DD') SUB_START FROM SUBDATE WHERE SUB_DATE_CODE = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, subDateCode);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				subStart = rs.getString("SUB_START");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

				}
			}
		}

		return subStart;
	}

	@Override
	public String ProgressStartCatDate(int catDateCode) throws SQLException {
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		String catStart = "";

		try {

			sql = " SELECT TO_CHAR(CAT_START, 'YYYY-MM-DD') CAT_START FROM CATDATE WHERE CAT_DATE = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, catDateCode);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				catStart = rs.getString("CAT_START");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

				}
			}
		}

		return catStart;
	}

	@Override
	public String ProgressStartOpDate(int opDateCode) throws SQLException {
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		String opStart = "";

		try {

			sql = " SELECT TO_CHAR(OP_START, 'YYYY-MM-DD') OP_START FROM OPDATE WHERE OP_DATE = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, opDateCode);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				opStart = rs.getString("OP_START");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {

				}
			}
		}

		return opStart;
	}

	@Override // 소분류 실적 진척율 입력
	public int perforProgressOpDateUpdate(int cat_date, int op_date, int performOpDate) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			if(performOpDate < 1 || performOpDate > 100) {
				return 0;
			}
			
			sql = " UPDATE OPDATE SET OP_PER = ? WHERE OP_DATE = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, performOpDate);
			pstmt.setInt(2, op_date);
			result = pstmt.executeUpdate();

			

		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (Exception e2) {

			}
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {

				}
			}

		}

		return result;

	}

	@Override // 프로젝트 실적시작일
	public int resultProgressProjectStartInput(ProjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			// 프로젝트일정 수정 sql
			sql = "UPDATE project SET prj_start = ? WHERE prj_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPrj_start()); // 프로젝트실적시작일
			pstmt.setInt(2, dto.getPrj_code());// 프로젝트코드

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

	@Override // 프로젝트 실적종료일
	public int resultProgressProjectEndInput(ProjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			// 프로젝트일정 수정 sql
			sql = "UPDATE project SET prj_end = ? WHERE prj_code = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPrj_end()); // 프로젝트실적종료일
			pstmt.setInt(2, dto.getPrj_code());// 프로젝트코드

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

	@Override // 대분류 실적시작일
	public int resultProgressSubDateStartInput(SubjectDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "UPDATE SUBDATE SET SUB_START = ? " + "WHERE SUB_DATE_CODE = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSub_start());
			pstmt.setInt(2, dto.getSub_date_code());
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

	@Override // 대분류 실적종료일시작
	public int resultProgressSubDateEndInput(SubjectDTO dto) throws SQLException {
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

	@Override // 중분류실적종료일시작
	public int resultProgressCatDateEndInput(CatDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			// 중분류일정 수정 sql
			sql = "UPDATE catdate SET cat_end = ? WHERE cat_date = ? AND cat_start is not null";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getCat_end()); // 중분류실적종료일
			pstmt.setInt(2, dto.getCat_date()); // 중분류 코드
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

	@Override // 소분류실적시작일
	public int resultProgressOpDateStartInput(OpDateDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;

		try {
			// 소분류일정 수정 sql
			sql = "UPDATE opdate SET op_start = ? WHERE op_date = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getOp_start()); // 소분류실적시작일
			pstmt.setInt(2, dto.getOp_date()); // 소분류 코드
			result = pstmt.executeUpdate();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override // 소분류실적종료일
	public int resultProgressOpDateEndInput(OpDateDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;

		try {
			// 소분류일정 수정 sql
			sql = "UPDATE opdate SET op_end = ? WHERE op_date = ? AND op_start is not null";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getOp_end()); // 소분류실적종료일
			pstmt.setInt(2, dto.getOp_date()); // 소분류 코드
			result = pstmt.executeUpdate();
			pstmt.close();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override // 소분류 업무 구성비 입력
	public int workCompositionOpDate(int codeCatDate, int codeOpDate, int comp) throws SQLException {

		int output = 0;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {
			
			if(comp < 1) {
				return 200;
			}
			
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

			if (rs.next()) {
				output = rs.getInt("WORK_COMP");
			}

			if (output > 100) {
				conn.rollback();
				
			} else {
				conn.commit();
				conn.setAutoCommit(true);

			}

		} catch (SQLException e) {

			try {
				conn.rollback();
				throw e;
			} catch (Exception e2) {

			}
		
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {

				}
			}

			try {
				// conn.setAutoCommit(true);
			} catch (Exception e) {

			}

		}

		return output;
	}

	@Override  // 중분류 업무 구성비 입력
	public int workCompositionCatDate(int codeSubDate, int codeCatDate, int comp) throws SQLException {

		int output = 0;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {
			
			if(comp < 1) {
				return 200;
			}
			
			
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

			if (rs.next()) {
				output = rs.getInt("CAT_COMP");
			}

			if (output > 100) {
				conn.rollback();
				
			} else {
				conn.commit();
				conn.setAutoCommit(true);

			}

		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (Exception e2) {

			}
			
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {

				}
			}

			try {
				// conn.setAutoCommit(true);
			} catch (Exception e) {

			}

		}

		return output;

	}

	@Override  // 대분류 업무 구성비 입력
	public int workCompositionSubDate(int codeProject, int codeSubDate, int comp) throws SQLException {

		int output = 0;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {
			
			if(comp < 1) {
				return 100;
			}
			
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

			if (rs.next()) {
				output = rs.getInt("SUB_COMP");
			}

			if (output > 100) {
				conn.rollback();
				
			} else {
				conn.commit();
				conn.setAutoCommit(true);

			}

		} catch (SQLException e) {

			try {
				conn.rollback();
				throw e;
			} catch (Exception e2) {

			}
			
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {

				}
			}

			try {
				// conn.setAutoCommit(true);
			} catch (Exception e) {

			}

		}

		return output;

	}

}
