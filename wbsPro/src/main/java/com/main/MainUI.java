package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.emp.EmployeeUI;
import com.plan.PlanUI;
import com.util.DBConn;

public class MainUI {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void menu() {
		while (true) {

			try {
				System.out.print("1.로그인 2. 비밀번호 설정 3. 종료");
				int ch = Integer.parseInt(br.readLine());

				if (ch == 3) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					login();
					break;
				case 2:
					signUp();
					break;

				}

			} catch (Exception e) {
			}

		}

	}

	private void login() {
		// 로그인 성공하면 loginSuccess() 실행
		// 로그인 실패하면 loginFail() 실행
		System.out.println("로그인");

		loginFail();

		loginSuccess();

	}

	private void signUp() {
		System.out.println("회원가입");

	}

	private void loginSuccess() {
		System.out.println("로그인 성공");
		// 로그인 성공하면 planUI() 실행 - 계획 일정 관리

		PlanUI planUI = new PlanUI();
		EmployeeUI employeeUI = new EmployeeUI();
	
	
		while (true) {

			try {
				System.out.print("1. 계획 일정 관리 2. 실적 관리 3. 사원 관리 ");
				int ch = Integer.parseInt(br.readLine());
				switch (ch) {
				case 1:
					planUI.menu();
					break;
				case 2:
					employeeUI.menu(); //실적 관리 UI로 이동 (클래스명 수정해야 함)
					break;
				case 3:
					employeeUI.menu();
					break;

				}
			} catch (Exception e) {
			}

		}

	}

	private void loginFail() {
		System.out.println("로그인 실패");
	}

}