package com.cat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.subject.SubjectDAO;
import com.subject.SubjectDAOImpl;

public class CatUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	CatDateDAO cdao = new CatDateDAOImpl();
	SubjectDAO pdao = new SubjectDAOImpl();

	public void insertCatDate() {
		System.out.println("[중분류 등록]");

		int subCode;
		try {
			CatDateDTO dto = new CatDateDTO();
			System.out.print("대분류 코드 ? "); // 대분류 일정코드
			subCode = Integer.parseInt(br.readLine());
			dto.setSub_date_code(subCode);

			dto.setCat_date(findCat(subCode)); // 중분류 코드 자동부여

			System.out.print("중분류명 ?"); // 중분류일정명
			dto.setCat_name(br.readLine());

			System.out.print("중분류 계획 시작일 ?"); // 중분류 계획 시작일
			dto.setCat_plan_start(br.readLine());

			System.out.print("중분류 계획 종료일 ?"); // 중분류 계획 종료일
			dto.setCat_plan_end(br.readLine());

			System.out.print("담당자 코드?"); // 중분류 담당자 코드
			dto.setUser_code(Integer.parseInt(br.readLine()));

			int result = cdao.insertCatDate(dto);

			if (result == 2) {
				System.out.println("[중분류 등록 성공]");
			} else {
				System.out.println("[중분류 등록 실패]");
			}

		} catch (Exception e) {
			System.out.println("[중분류 등록 오류]");
		}

	}

	public void updateCatDate() {
		System.out.println("[중분류 수정]");
		try {
			CatDateDTO dto = new CatDateDTO();

			System.out.print("수정할 중분류 코드?"); // 중분류 일정코드
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);

			System.out.print("중분류명 ?"); // 중분류 일정명 수정
			dto.setCat_name(br.readLine());

			System.out.print("중분류 계획 시작일 ?"); // 중분류 계획 시작일 수정
			dto.setCat_plan_start(br.readLine());

			System.out.print("중분류 계획 종료일 ?"); // 중분류 계획 종료일 수정
			dto.setCat_plan_end(br.readLine());

			System.out.print("담당자 코드?"); // 중분류 담당자 코드 수정
			dto.setUser_code(Integer.parseInt(br.readLine()));

			int result = cdao.updateCatDate(dto);

			if (result == 2) {
				System.out.println("[중분류 수정 성공]");
			} else {
				System.out.println("[중분류 수정 실패]");
			}

		} catch (Exception e) {
			System.out.println("[중분류 수정 오류]");
		}

	}

	public void deleteCatDate() {
		System.out.println("[중분류 삭제]");

		int cat_date;

		try {

			System.out.print("삭제할 중분류 코드 ?");

			cat_date = Integer.parseInt(br.readLine());

			int result = cdao.deleteCatDate(cat_date);

			if (result == 1) {
				System.out.println("[중분류 삭제 성공]");
			} else {
				System.out.println("[중분류 삭제 실패]");
			}

		} catch (Exception e) {
			System.out.println("[중분류 삭제 오류]");
		}

	}

	public int findCat(int subCode) {
		int catCode = 0;
		try {
			CatDateDTO dto = cdao.findCat(subCode);

			if (dto == null) {
				System.out.println("등록된 자료가 없습니다");
				return 0;
			}

			catCode = dto.getCat_date();
			if (catCode == 0) {
				catCode = subCode * 10 + 1;
			} else {
				catCode = catCode + 1;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return catCode;
	}

}