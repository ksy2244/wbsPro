package com.op;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cat.CatDateDAO;
import com.cat.CatDateDAOImpl;

public class OpUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	OpDateDAO dao = new opDateDAOimpl();
	CatDateDAO cdao = new CatDateDAOImpl();

	public void addOpDate() {
		System.out.println("[소분류 등록]");
		int cat_date;

		try {
			OpDateDTO dto = new OpDateDTO();
			System.out.print("중분류 코드 ?");
			cat_date = Integer.parseInt(br.readLine());

			dto.setCat_date(cat_date);

			System.out.print("소분류 코드 ?");
			dto.setOp_date(Integer.parseInt(br.readLine()));

			System.out.print("소분류 일정 이름 ?");
			dto.setOp_name(br.readLine());

			System.out.print("소분류 일정 시작일 ?");
			dto.setOp_plan_start(br.readLine());

			System.out.print("소분류 일정 종료일 ?");
			dto.setOp_plan_end(br.readLine());

			dao.insertOpDate(dto);

		} catch (Exception e) {
			e.printStackTrace();
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

			dao.updateOpDate(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteOpDate() {

		try {
			OpDateDTO dto = new OpDateDTO();
			System.out.println("[소분류 삭제]");
			System.out.print("삭제할 소분류 코드 ?");

			int result = dao.deleteOpDate(Integer.parseInt(br.readLine()));

			if (result != 0) {
				System.out.println("코드가 삭제되었습니다.");
			}

		} catch (Exception e) {
			System.out.println("소분류 코드가 존재하지않아 삭제가 불가능합니다.");
		}

	}

}
