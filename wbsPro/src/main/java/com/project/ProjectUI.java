package com.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProjectUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ProjectDAO dao = new ProjectDAOImpl();

	public void addProject() { // 프로젝트 등록
		System.out.println("[프로젝트 등록]");
		// 프로젝트 담당자 없음. 사원코드로 넣어줘야 할 것 같음
		// 프로젝트 시작일과 프로젝트 종료일은 전체 목록을 볼 때 Select로 설정?

		try {

			ProjectDTO dto = new ProjectDTO();

			System.out.print("프로젝트 코드? "); // 프로젝트 코드
			int n = Integer.parseInt(br.readLine());
			dto.setPrj_code(n);

			System.out.print("발주업체 코드? ");
			dto.setOc_code(Integer.parseInt(br.readLine()));

			System.out.print("프로젝트명? "); // 프로젝트명
			dto.setPrj_name(br.readLine());

			System.out.print("프로젝트 개요? "); // 프로젝트 개요
			dto.setPrj_ov(br.readLine());

			System.out.print("프로젝트 설명? "); // 프로젝트 설명
			dto.setPrj_plan(br.readLine());

			System.out.print("프로젝트 시작일? "); // 프로젝트 설명
			dto.setPrj_plan_start(br.readLine());

			System.out.print("프로젝트 종료일? "); // 프로젝트 설명
			dto.setPrj_plan_end(br.readLine());

			System.out.print("담당자 코드? "); // 프로젝트 담당자 코드
			dto.setUser_code(Integer.parseInt(br.readLine()));

			int result = dao.insertProject(dto);

			if (result == 2) {
				System.out.println("[프로젝트 등록 성공]");
			} else {
				System.out.println("[프로젝트 등록 실패]");
			}

		} catch (Exception e) {
			System.out.println("[프로젝트 등록 오류]");
		}

	}

	public void updateProject() {

		try {
			ProjectDTO dto = new ProjectDTO();
			System.out.println("[프로젝트 수정]");

			System.out.print("수정할 프로젝트 코드 ?"); // 프로젝트 코드
			dto.setPrj_code(Integer.parseInt(br.readLine()));

			System.out.print("프로젝트명? "); // 프로젝트명
			dto.setPrj_name(br.readLine());

			System.out.print("발주업체 코드? ");
			dto.setOc_code(Integer.parseInt(br.readLine()));

			System.out.print("프로젝트 개요? "); // 프로젝트 개요
			dto.setPrj_ov(br.readLine());

			System.out.print("프로젝트 설명? "); // 프로젝트 설명
			dto.setPrj_plan(br.readLine());

			System.out.print("프로젝트 시작일? "); // 프로젝트 설명
			dto.setPrj_plan_start(br.readLine());

			System.out.print("프로젝트 종료일? "); // 프로젝트 설명
			dto.setPrj_plan_end(br.readLine());

			System.out.print("담당자 코드? "); // 담당자 코드 수정
			dto.setUser_code(Integer.parseInt(br.readLine()));

			int result = dao.updateProject(dto);

			if (result == 2) {
				System.out.println("[프로젝트 수정 성공]");
			} else {
				System.out.println("[프로젝트 수정 실패]");
			}

		} catch (Exception e) {
			System.out.println("[프로젝트 수정 오류]");
		}

	}

	public void deleteProject() {

		try {

			System.out.println("[프로젝트 삭제]");
			System.out.print("삭제할 프로젝트 코드 ?");

			int result = dao.deleteProject(Integer.parseInt(br.readLine()));

			if (result == 1) {
				System.out.println("[프로젝트 삭제 성공]");
			} else {
				System.out.println("[프로젝트 삭제 실패]");
			}

		} catch (Exception e) {
			System.out.println("[프로젝트 삭제 오류]");
		}

	}

}
