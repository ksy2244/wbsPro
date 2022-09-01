package com.op;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.cat.CatDateDTO;
import com.util.DBConn;

public class opDateDAOimpl implements OpDateDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertOpDate(OpDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			conn.setAutoCommit(false);

			sql = "INSERT INTO opdate(Cat_date, op_date, op_name, op_plan_start, op_plan_end) VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCat_date());
			pstmt.setInt(2, dto.getOp_date());
			pstmt.setString(3, dto.getOp_name());
			pstmt.setString(4, dto.getOp_plan_start());
			pstmt.setString(5, dto.getOp_plan_end());
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			sql = "INSERT INTO opcharge(op_date, user_code) VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getOp_date());
			pstmt.setInt(2, dto.getUser_code());
			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

			conn.commit();

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
				System.out.println("중분류 코드를 잘못입력했습니다");
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

				conn.setAutoCommit(true);
			} catch (Exception e) {

			}

		}

		return result;
	}

	@Override
	public int updateOpDate(OpDateDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "UPDATE opdate SET op_name = ?, op_plan_start = ?, op_plan_end = ? WHERE Op_date = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getOp_name());
			pstmt.setString(2, dto.getOp_plan_start());
			pstmt.setString(3, dto.getOp_plan_end());
			pstmt.setInt(4, dto.getOp_date());
			result = pstmt.executeUpdate();
			pstmt.close();

			sql = "UPDATE subcharge SET user_code = ? WHERE sub_date_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_code()); // 대분류명
			pstmt.setInt(2, dto.getUser_code()); // 사원 코드
			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

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
	public int deleteOpDate(int Op_date) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "DELETE FROM opcharge WHERE Op_date = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Op_date);
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
			
			sql = "DELETE FROM opdate WHERE Op_date = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Op_date);
			result += pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;

		} catch (Exception e) {
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

			if (rs.next()) {
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

			if (rs.next()) {
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
	
	@Override
	public OpDateDTO findOp(int opCode) {
		// 가장 큰 소분류 찾기
		OpDateDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql =  "SELECT MAX(op_date) nextOp FROM opdate WHERE op_date =  ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, opCode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new OpDateDTO();
				dto.setOp_date(rs.getInt("nextOp"));
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