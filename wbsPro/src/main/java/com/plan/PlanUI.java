package com.plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.Ratio.RatioUI;
import com.cat.CatUI;
import com.op.OpUI;
import com.project.ProjectUI;
import com.subject.SubjectUI;
import com.util.DBConn;

public class PlanUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int ch;
	ProjectUI projectUI = new ProjectUI();
	OpUI opUI = new OpUI();
	SubjectUI subjectUI = new SubjectUI();
	CatUI catUI = new CatUI();
	RatioUI ratioUI = new RatioUI();

	public void menu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		ch = Integer.parseInt(br.readLine());

		while (true) {

			try {
				System.out.print("1.작업 등록 2. 작업 수정 3.작업 삭제 4. 작업 검색 5.업무 구성비 6. 전체 작업 목록 7. 로그아웃 8. 종료 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 8) {
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
					ratioUI.menu();

				case 6:

					break;

				}

			} catch (Exception e) {
			}

		}

	}

	private void insert() {
		System.out.println("[작업 등록]");
		ProjectUI projectUI = new ProjectUI(); // 프로젝
		SubjectUI subjectUI = new SubjectUI(); // 대분류
		CatUI catUI = new CatUI(); // 중분류
		OpUI opUI = new OpUI();

		while (true) {

			try {
				System.out.print("1. 프로젝트 등록 2. 대분류 등록 3. 중분류 등록 4. 소분류 등록  5. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 6) {
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
					catUI.addCategory();
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
					subjectUI.addSubject();
					break;
				case 3:
					catUI.updateCategory();
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
					catUI.deleteCategory();

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