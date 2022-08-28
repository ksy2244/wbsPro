package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.emp.EmployeeDAO;
import com.emp.EmployeeDAOImpl;
import com.emp.EmployeeDTO;
import com.emp.EmployeeUI;
import com.plan.PlanUI;
import com.util.DBConn;

import com.user.Login;

public class MainUI {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Login login = new Login();
	private EmployeeDAO dao = new EmployeeDAOImpl();
	// private MemberDAO dao = new MemberDAOImpl();

	public void initial() {
		while (true) {
			if (login.loginEmployee() == null) {
				menu();
			} else {
				loginSuccess();
			}
		}
	}

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
					updatePwd();
					break;

				}

			} catch (Exception e) {
			}

		}

	}

	private void updatePwd() {
		System.out.println("\n[비밀번호 변경]");

		String user_code;
		String pwd;
		
		try {
			
			System.out.print("비밀번호 변경할 사원번호 ? ");
			user_code = br.readLine();
			
			System.out.print("기존 패스워드 ? ");
			pwd = br.readLine();

			EmployeeDTO dto = dao.readEmployee(user_code);
			if (dto == null || !dto.getPwd().equals(pwd)) {
				System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
				return;
			}

			System.out.print("변경할 패스워드 ? ");
			dto.setPwd(br.readLine());
			
			dao.updatePwd(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public void login() {
		System.out.println("\n[로그인]");

		String user_code;
		String pwd;

		try {
			System.out.print("사원번호 ? ");
			user_code = br.readLine();

			System.out.print("패스워드 ? ");
			pwd = br.readLine();

			EmployeeDTO dto = dao.readEmployee(user_code);
			if (dto == null || !dto.getPwd().equals(pwd)) {
				System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
				return;
			}

			login.login(dto);
			loginSuccess();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();

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
					employeeUI.menu(); // 실적 관리 UI로 이동 (클래스명 수정해야 함)
					break;
				case 3:
					employeeUI.menu();
					break;

				}
			} catch (Exception e) {
			}

		}

	}

}