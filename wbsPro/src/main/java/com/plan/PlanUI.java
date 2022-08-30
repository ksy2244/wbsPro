package com.plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cat.CatUI;
import com.op.OpUI;
import com.project.ProjectUI;
import com.subject.SubjectUI;
import com.util.DBConn;

public class PlanUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int ch;
	ProjectUI projectUI= new ProjectUI();
	OpUI opUI= new OpUI();
	SubjectUI subjectUI= new SubjectUI();
	CatUI catUI= new CatUI();
	private PlanImpl plan = new PlanImpl();

	
	public void menu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		

		while (true) {

			try {
				System.out.print("1.작업 등록 2. 작업 수정 3.작업 삭제 4. 작업 검색 5. 전체 작업 목록 6.업무 구성비 7. 종료 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					insert();
					break;
				case 2:
					update();
					break;
				case 3:
					delete();
					break;
				case 4:
					projectUI.searchWork();
					break;
					
				case 5:
					workList();
					break;
					

				}

			} catch (Exception e) {
			}

		}

	}

	private void workList() throws SQLException, NumberFormatException, IOException {
		int prj_code;
		System.out.println("전체 리스트 조회");
		System.out.print("검색할 프로젝트 작업명? ");

		prj_code = Integer.parseInt(br.readLine());
			
		List<PlanDTO> list = plan.listAll(prj_code);
		
		System.out.println(list.size());
		if (list.size() == 0) {
			System.out.println("등록된 자료가 없습니다");
			return;
		}
		
		System.out.println("------------------------------------------");
		System.out.println("프로젝트 코드 \t 프로젝트 이름 \t 대분류 코드\t 대분류명 ");
		for (PlanDTO dto : list) {
			System.out.print(dto.getPrj_code() + "\t");
			System.out.print(dto.getPrj_name() + "\t");
			System.out.print(dto.getSub_date_code() + "\t");
			System.out.println(dto.getSub_name() + "\t");
		}
		System.out.println();

	}

	private void insert() {
		System.out.println("[작업 등록]");
		ProjectUI projectUI = new ProjectUI(); //프로젝
		SubjectUI subjectUI = new SubjectUI(); // 대분류 
		CatUI catUI = new CatUI(); // 중분류
		OpUI opUI = new OpUI();
		

		while (true) {

			try {
				System.out.print("1. 프로젝트 등록 2. 대분류 등록 3. 중분류 등록 4. 소분류 등록   6. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					projectUI.addProject();
					break;
				case 2:
					subjectUI.addSubject();
					break;
				case 3:
					catUI.insertCatDate();
					break;
				case 4:
					opUI.addOpDate();
					break;

				}

			} catch (Exception e) {
			}
		}

	}


	private void update() {
		System.out.println("[작업 수정]");

		while (true) {

			try {
				System.out.print("1. 프로젝트 수정 2. 대분류 수정 3. 중분류 수정 4. 소분류 수정   6. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					projectUI.updateProject();
					break;
				case 2:
					subjectUI.updateSubject();
					break;
				case 3:
					catUI.updateCatDate();
					break;
				case 4:
					opUI.updateOpDate();
					break;

				}

			} catch (Exception e) {
			}
		}

	}






	private void delete() {


		while (true) {

			try {
				System.out.print("1. 프로젝트 삭제 2. 대분류 삭제 3. 중분류 삭제 4. 소분류 삭제   6. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					projectUI.deleteProject();
					break;
				case 2:
					subjectUI.deleteSubject();
					break;
				case 3:
					catUI.deleteCatDate();
					
					break;
				case 4:
					opUI.deleteOpDate();
					break;

				}

			} catch (Exception e) {
				
			}
		}
		
	}

	
	
	
	
}