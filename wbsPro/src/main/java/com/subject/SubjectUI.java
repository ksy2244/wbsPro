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

			System.out.print("대분류 코드? "); // 대분류 코드
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);

			System.out.print("대분류명? "); // 대분류명
			dto.setSub_name(br.readLine());
			
			
			System.out.print("담당자 코드? "); // 대분류명
			user_code = Integer.parseInt(br.readLine());
			dto.setUser_code(user_code);
			
			int result = dao.insertSubject(dto);
			
			if(result != 0) {
				 System.out.println("[대분류 등록 성공]");
			 } else {
				 System.out.println("[대분류 등록 실패]");
			 }

		} catch (Exception e) {
			System.out.println("[대분류 등록 오류]");
		}

	}

	public void updateSubject() {
		try {
			int  user_code;
			SubjectDTO dto = new SubjectDTO();
			System.out.println("[대분류 수정]");
			System.out.print("수정할 대분류 코드 "); // 대분류 코드
			dto.setSub_date_code(Integer.parseInt(br.readLine()));

			System.out.print("대분류명? "); // 대분류명
			dto.setSub_name(br.readLine());
			
			System.out.print("담당자 코드? "); // 대분류명
			user_code = Integer.parseInt(br.readLine());
			dto.setUser_code(user_code);
			
			int result = dao.updateSubject(dto);
			
			 if(result != 0) {
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

			 if(result != 0) {
				 System.out.println("[대분류 삭제 성공]");
			 } else {
				 System.out.println("[대분류 삭제 실패]");
			 }
			 
		} catch (Exception e) {
			System.out.println("[대분류 삭제 오류]");
		}

	}

}
