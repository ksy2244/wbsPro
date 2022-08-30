package com.cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
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
			sql = "SELECT sub_date_code FROM subdate WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code());
			pstmt.executeQuery();
			pstmt.close();
			pstmt = null;

			// catdate 추가 sql
			sql = " INSERT INTO catdate(sub_date_code, cat_date, cat_name, cat_plan_start, cat_plan_end) VALUES(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSub_date_code()); // 대분류 일정코드
			pstmt.setInt(2, dto.getCat_date()); // 중분류 일정코드
			pstmt.setString(3, dto.getCat_name()); // 중분류 일정명
			pstmt.setString(4, dto.getCat_plan_start()); // 중분류계획시작일
			pstmt.setString(5, dto.getCat_plan_end()); // 중분류계획종료일
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit(); // 커밋
			System.out.println("중분류일정 추가");

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
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
			// 중분류일정 수정 sql
			sql = "UPDATE catdate SET cat_name = ? , cat_plan_start = ? , cat_plan_end = ? WHERE cat_date = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getCat_name()); // 중분류 일정명
			pstmt.setString(2, dto.getCat_plan_start()); // 중분류계획시작일
			pstmt.setString(3, dto.getCat_plan_end()); // 중분류계획종료일
			pstmt.setInt(4, dto.getCat_date()); // 중분류 일정코드

			pstmt.executeUpdate();

			System.out.println("중분류 일정 수정 완료");
		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getErrorCode() == 1) {
				System.out.println("중분류일정 코드 중복입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override  
	public int deleteCatDate(int cat_date) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

        
		
			sql = " DELETE FROM catdate WHERE cat_date = ?";
			
			pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, cat_date);

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
	public CatDateDTO searchCatDateCode(String cat_date) { // 코드명 검색
		CatDateDTO dto = new CatDateDTO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "SELECT sub_date_code FROM SUBDATE"
					+ "SELECT cat_date, cat_name, cat_plan_start, cat_plan_end, cat_plan_per, cat_start, cat_end, cat_per, cat_comp, User_name"
					+ " FROM catdate" 
					+ " WHERE cat_name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cat_date);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setSub_date_code(rs.getInt("sub_date_code"));
				dto.setCat_date(rs.getInt("cat_date"));
				dto.setCat_name(rs.getString("cat_name"));
				dto.setCat_plan_start(rs.getString("cat_plan_start"));
				dto.setCat_plan_end(rs.getString("cat_plan_end"));
				dto.setCat_plan_per(rs.getInt("Cat_plan_per"));
				dto.setCat_start(rs.getString("Cat_start"));
				dto.setCat_end(rs.getString("Cat_end"));
				dto.setCat_per(rs.getInt("cat_per"));
				dto.setCat_comp(rs.getInt("cat_comp"));
				dto.setUser_name(rs.getString("user_name"));

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
	public List<CatDateDTO> searchCatDateName(String cat_name) {// 작업명 검색
		List<CatDateDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "SELECT sub_date_code FROM SUBDATE"
					+ "SELECT cat_date, cat_name, cat_plan_start, cat_plan_end, cat_plan_per, cat_start, cat_end, cat_per, cat_comp, User_name"
					+ " FROM catdate" + " WHERE cat_name = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cat_name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				CatDateDTO dto = new CatDateDTO();

				dto.setSub_date_code(rs.getInt("sub_date_code"));
				dto.setCat_date(rs.getInt("cat_date"));
				dto.setCat_name(rs.getString("cat_name"));
				dto.setCat_plan_start(rs.getString("cat_plan_start"));
				dto.setCat_plan_end(rs.getString("cat_plan_end"));
				dto.setCat_plan_per(rs.getInt("Cat_plan_per"));
				dto.setCat_start(rs.getString("Cat_start"));
				dto.setCat_end(rs.getString("Cat_end"));
				dto.setCat_per(rs.getInt("cat_per"));
				dto.setCat_comp(rs.getInt("cat_comp"));
				dto.setUser_name(rs.getString("user_name"));

				list.add(dto);
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
		return list;
	}

	@Override
	public List<CatDateDTO> searchCatDateManager(String CatDate_manager) {// 담당자명 검색
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDateDTO> searchCatDateDate(String CatDate_date) {// 날짜 검색
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDateDTO> searchCatDateAll() {// 전체 작업 목록
		List<CatDateDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "SELECT sub_date_code FROM SUBDATE"
					+ "SELECT cat_date, cat_name, User_name, cat_plan_start, cat_plan_end, cat_plan_per, cat_start, cat_end, cat_per, cat_comp"
					+ "FROM catdate";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// score 테이블의 모든 레코드를 읽어 List 객체에 저장
			while (rs.next()) {
				CatDateDTO dto = new CatDateDTO();

				dto.setSub_date_code(rs.getInt("sub_date_code"));
				dto.setCat_date(rs.getInt("cat_date"));
				dto.setCat_name(rs.getString("cat_name"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setCat_plan_start(rs.getString("cat_plan_start"));
				dto.setCat_plan_end(rs.getString("cat_plan_end"));
				dto.setCat_plan_per(rs.getInt("Cat_plan_per"));
				dto.setCat_start(rs.getString("Cat_start"));
				dto.setCat_end(rs.getString("Cat_end"));
				dto.setCat_per(rs.getInt("cat_per"));
				dto.setCat_comp(rs.getInt("cat_comp"));

				list.add(dto);
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
		return list;
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
