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
		int prj_code;
		try {
			SubjectDTO dto = new SubjectDTO();
			System.out.print("프로젝트 코드? "); // 프로젝트 코드
			prj_code = Integer.parseInt(br.readLine());

			dto.setPrj_code(prj_code);

			System.out.print("대분류 코드? "); // 대분류 코드
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);

			System.out.print("대분류명? "); // 대분류명
			dto.setSub_name(br.readLine());

			dao.insertSubject(dto);
			
			System.out.println("[대분류 등록 성공]");

		} catch (Exception e) {
			System.out.println("[대분류 등록 실패]");
		}

	}

	public void updateSubject() {
		try {
			SubjectDTO dto = new SubjectDTO();
			System.out.println("[대분류 수정]");
			System.out.print("수정할 대분류 코드 "); // 대분류 코드
			dto.setSub_date_code(Integer.parseInt(br.readLine()));

			System.out.print("대분류명? "); // 대분류명
			dto.setSub_name(br.readLine());

			dao.updateSubject(dto);
			
			System.out.println("[대분류 수정 성공]");

		} catch (Exception e) {
			System.out.println("[대분류 수정 실패]");
		}

	}

	public void deleteSubject() {
		System.out.println("[대분류 삭제]");

		int sub_date_code;

		try {

			System.out.print("삭제할 대분류 코드 ?");

			sub_date_code = Integer.parseInt(br.readLine());

			int result = dao.deleteSubject(sub_date_code);

			if (result == 0) {
				System.out.println("등록된 코드가 아닙니다.");
			} else {
				System.out.println("[대분류 삭제 성공]");
			}

		} catch (Exception e) {
			System.out.println("[대분류 삭제 실패]");
		}

	}

}
