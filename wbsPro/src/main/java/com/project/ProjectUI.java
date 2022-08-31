package com.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


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

			System.out.print("프로젝트명? "); // 프로젝트명
			dto.setPrj_name(br.readLine());

			System.out.print("프로젝트 개요? "); // 프로젝트 개요
			dto.setPrj_ov(br.readLine());

			System.out.print("프로젝트 설명? "); // 프로젝트 설명
			dto.setPrj_plan(br.readLine());

			 int result = dao.insertProject(dto);

			 if(result != 0) {
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

			System.out.print("프로젝트 개요? "); // 프로젝트 개요
			dto.setPrj_ov(br.readLine());

			System.out.print("프로젝트 설명? "); // 프로젝트 설명
			dto.setPrj_plan(br.readLine());

			
			 int result = dao.updateProject(dto);

			if(result != 0) {
				 System.out.println("[프로젝트 수정 성공]");
			 } else {
				 System.out.println("[프로젝트 수정 실패]");
			 }

		} catch (Exception e) {
			System.out.println("[프로젝트 수정 오류]");
		}

	}

	public void findByCode() { // 코드명 검색
		try {
			ProjectDTO dto = new ProjectDTO();
			System.out.print("검색할 프로젝트 코드? ");
			int prj_code = Integer.parseInt(br.readLine());

			dto = dao.searchProjectCode(prj_code);

			if (dto == null) {
				System.out.println("프로젝트가 존재하지 않습니다");
				return;
			}

			System.out.print(dto.getPrj_code() + "\t");
			System.out.print(dto.getPrj_name() + "\t");
			System.out.print(dto.getPrj_ov() + "\t");
			System.out.println(dto.getPrj_plan() + "\t");
			System.out.println();

		} catch (Exception e) {
			System.out.println("작업 검색 실패");
		}
		System.out.println();
	}

	public void findByWork() {
		// 작업명 검색
		String prj_name;
		try {
			System.out.print("검색할 프로젝트 작업명? ");

			prj_name = br.readLine();

			List<ProjectDTO> list = dao.searchProjectName(prj_name);

			if (list.size() == 0) {
				System.out.println("등록된 자료가 없습니다");
				return;
			}

			for (ProjectDTO dto : list) {

				System.out.print(dto.getPrj_code() + "\t");
				System.out.print(dto.getPrj_name() + "\t");
				System.out.print(dto.getPrj_ov() + "\t");
				System.out.println(dto.getPrj_plan() + "\t");
			}

		} catch (Exception e) {
			System.out.println("작업 검색 실패");
		}
		System.out.println();
	}

	public void searchWork() {
		try {
			ProjectDTO dto = new ProjectDTO();
			System.out.println("[작업 검색]");
			System.out.println("1.코드명으로 작업 검색 2. 작업명으로 작업 검색]");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {
			case 1:
				findByCode();
				break;
			case 2:
				findByWork();
				break;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void deleteProject() {

		try {
			
			System.out.println("[프로젝트 삭제]");
			System.out.print("삭제할 프로젝트 코드 ?");

			 int result = dao.deleteProject(Integer.parseInt(br.readLine()));

			 if(result != 0) {
				 System.out.println("[프로젝트 삭제 성공]");
			 } else {
				 System.out.println("[프로젝트 삭제 실패]");
			 }
			 
		} catch (Exception e) {
			System.out.println("[프로젝트 삭제 오류]");
		}

	}

}
