package com.subject;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import com.project.ProjectDAO;
import com.project.ProjectDAOImpl;

public class SubjectUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	SubjectDAO dao = new SubjectDAOImpl();
	ProjectDAO pdao = new ProjectDAOImpl();

	public void addSubject() {

		System.out.println("[대분류 등록]");
		int prj_code, user_code;
		try {
			SubjectDTO dto = new SubjectDTO();
			System.out.print("프로젝트 코드? "); // 프로젝트 코드
			prj_code = Integer.parseInt(br.readLine());

			dto.setPrj_code(prj_code);

			findSub(prj_code);
			dto.setSub_date_code(findSub(prj_code));

			System.out.print("대분류명? "); // 대분류명
			dto.setSub_name(br.readLine());

			System.out.print("담당자 코드? "); // 대분류명
			user_code = Integer.parseInt(br.readLine());
			dto.setUser_code(user_code);
			
			System.out.print("대분류 시작일? "); // 대분류 계획 시작일
			dto.setSub_plan_start(br.readLine());

			System.out.print("대분류 종료일? "); // 대분류 계획 종료일
			dto.setSub_plan_end(br.readLine());

			int result = dao.insertSubject(dto);

			if (result == 2) {
				System.out.println("[대분류 등록 성공]");
			} else {
				System.out.println("[대분류 등록 실패]");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[대분류 등록 오류]");
		}

	}

	public void updateSubject() {
		try {
			int user_code;
			SubjectDTO dto = new SubjectDTO();
			System.out.println("[대분류 수정]");
			System.out.print("수정할 대분류 코드 "); // 대분류 코드
			dto.setSub_date_code(Integer.parseInt(br.readLine()));

			System.out.print("대분류명? "); // 대분류명
			dto.setSub_name(br.readLine());

			System.out.print("담당자 코드? "); // 대분류명
			user_code = Integer.parseInt(br.readLine());
			dto.setUser_code(user_code);
			
			System.out.print("대분류 시작일? "); // 대분류 계획 시작일
			dto.setSub_plan_start(br.readLine());

			System.out.print("대분류 종료일? "); // 대분류 계획 종료일
			dto.setSub_plan_end(br.readLine());

			int result = dao.updateSubject(dto);

			if (result == 2) {
				System.out.println("[대분류 수정 성공]");
			} else {
				System.out.println("[대분류 수정 실패]");
			}

		} catch (Exception e) {
			System.out.println("[대분류 수정 오류]");
		}

	}

	public void deleteSubject() {

		try {
			System.out.println("[대분류 삭제]");
			System.out.print("삭제할 대분류 코드 ?");

			int result = dao.deleteSubject(Integer.parseInt(br.readLine()));

			if (result == 1) {
				System.out.println("[대분류 삭제 성공]");
			} else {
				System.out.println("[대분류 삭제 실패]");
			}

		} catch (Exception e) {
			System.out.println("[대분류 삭제 오류]");
		}

	}

	public int findSub(int prjCode) {
		// 대분류 자동 부여
		// findSub에서 해당 프로젝트 내 가장 큰 대분류 값을 찾아
		// 프로젝트에 대분류가 존재하지 않으면 1 번
		// 그렇지 않으면 최대 값의 다음 값
		int subCode = 0;
		try {
			SubjectDTO dto = dao.findSub(prjCode);

			if (dto == null) {
				System.out.println("등록된 자료가 없습니다");
				return 0;
			}

			subCode = dto.getSub_date_code();
			if (subCode == 0) {
				subCode = prjCode * 10 + 1;
			} else {
				subCode = subCode + 1;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subCode;
	}
}
