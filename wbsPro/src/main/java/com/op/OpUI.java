package com.op;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cat.CatDateDAO;
import com.cat.CatDateDAOImpl;
import com.cat.CatDateDTO;

public class OpUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	OpDateDAO dao = new opDateDAOimpl();
	CatDateDAO cdao = new CatDateDAOImpl();

	public void addOpDate() {
		System.out.println("[소분류 등록]");
		int catCode, user_code;

		try {
			OpDateDTO dto = new OpDateDTO();
			System.out.print("중분류 코드 ?");
			catCode = Integer.parseInt(br.readLine());
			dto.setCat_date(catCode);

			dto.setOp_date(findOp(catCode)); // 소분류 자동 코드 부여

			System.out.print("소분류 일정 이름 ?");
			dto.setOp_name(br.readLine());

			System.out.print("소분류 일정 시작일 ?");
			dto.setOp_plan_start(br.readLine());

			System.out.print("소분류 일정 종료일 ?");
			dto.setOp_plan_end(br.readLine());

			System.out.print("담당자 코드?");
			user_code = Integer.parseInt(br.readLine());
			dto.setUser_code(user_code);

			int result = dao.insertOpDate(dto);

			if (result == 2) {
				System.out.println("[소분류 등록 성공]");
			} else {
				System.out.println("[소분류 등록 실패]");
			}

		} catch (Exception e) {
			System.out.println("[소분류 등록 오류]");
		}

	}

	public void updateOpDate() {
		try {
			OpDateDTO dto = new OpDateDTO();
			System.out.println("[소분류 수정]");
			System.out.print("수정할 소분류 코드 ?");
			dto.setOp_date(Integer.parseInt(br.readLine()));

			System.out.print("소분류 일정 이름 ? ");
			dto.setOp_name(br.readLine());

			System.out.print("소분류 일정 시작일 ? ");
			dto.setOp_plan_start(br.readLine());

			System.out.print("소분류 일정 종료일 ? ");
			dto.setOp_plan_end(br.readLine());

			System.out.print("담당자 코드?");
			dto.setUser_code(Integer.parseInt(br.readLine()));

			int result = dao.updateOpDate(dto);

			if (result == 2) {
				System.out.println("[소분류 수정 성공]");
			} else {
				System.out.println("[소분류 수정 실패]");
			}

		} catch (Exception e) {
			System.out.println("[소분류 수정 오류]");
		}

	}

	public void deleteOpDate() {

		try {

			System.out.println("[소분류 삭제]");
			System.out.print("삭제할 소분류 코드 ?");

			int result = dao.deleteOpDate(Integer.parseInt(br.readLine()));

			if (result == 1) {
				System.out.println("[소분류 삭제 성공]");
			} else {
				System.out.println("[소분류 삭제 실패]");
			}

		} catch (Exception e) {
			System.out.println("[소분류 삭제 오류]");
		}

	}

	public int findOp(int catCode) {
		int opCode = 0;
		try {
			OpDateDTO dto = dao.findOp(catCode);

			if (dto == null) {
				System.out.println("등록된 자료가 없습니다");
				return 0;
			}

			opCode = dto.getOp_date();
			if (opCode == 0) {
				opCode = catCode * 10 + 1;
			} else {
				opCode = opCode + 1;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return opCode;
	}

}
