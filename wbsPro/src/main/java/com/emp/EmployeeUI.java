package com.emp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.util.DBConn;

public class EmployeeUI { // EmployeeUI로 이름 수정

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int ch ;
	
	public void menu() {
		// TODO Auto-generated method stub
		
		while (true) {

			try {
				System.out.print("1. 인사관리 2. 업체 관리 3. 일정 관리 4.로그아웃 5. 종료 ");

				 ch = Integer.parseInt(br.readLine());

				if (ch == 5) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					employeeManage();
					break;
				case 2:
					companyManage();
					break;
				case 3:
					workManage();
					break;
				case 4: // 로그아웃

					break;
				}

			} catch (Exception e) {
			}

		}
	}

	private void workManage() {
		// TODO Auto-generated method stub

	}

	private void companyManage() {
		while (true) {

			try {
				System.out.print("1. 업체 관리 2. 업체 수정 3. 업체 삭제 4. 업체 조회");

				ch = Integer.parseInt(br.readLine());
				if (ch == 5) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					insertCompany();
					break;
				case 2:
					updateCompany();
					break;
				case 3:
					deleteCompany();
					break;
				case 4:
					searchCompany();
					break;
				

				}

			} catch (Exception e) {
			}

		}
	}
	


	private void insertCompany() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void updateCompany() {
		// TODO Auto-generated method stub
		
	}
	
	private void deleteCompany() {
		// TODO Auto-generated method stub
		
	}

	private void searchCompany() {
		while (true) {

			try {
				System.out.print("1.업체 이름 조회 2.업체 코드 조회 3.전체 업체 조회 4. 종료");

				 ch = Integer.parseInt(br.readLine());

				if (ch == 4) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					findByCompanyName();
					break;
				case 2:
					findByCompanyCode();
					break;
				case 3:
					listCompany();
					
					break;

				}

			} catch (Exception e) {
			}

		}
		
	}


	private void findByCompanyCode() {
		// TODO Auto-generated method stub
		
	}

	private void findByCompanyName() {
		// TODO Auto-generated method stub
		
	}

	private void listCompany() {
		// TODO Auto-generated method stub
		
	}
	

	public void employeeManage() {
		while (true) {

			try {
				System.out.print("1. 사원 관리 2. 사원 정보 수정 3.사원 삭제 4.사원 조회 5.뒤로가기 6. 로그아웃 7. 종료 ");

				ch = Integer.parseInt(br.readLine());
				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					insertEmployee();
					break;
				case 2:
					updateEmployee();
					break;
				case 3:
					deleteEmployee();
					break;
				case 4:
					findByEmployee();
					break;
				case 5:
					menu();
					break;
				case 6: // 로그아웃
					break;

				}

			} catch (Exception e) {
			}

		}
	}

	private void insertEmployee() {
		System.out.println("사원 등록");

	}

	private void updateEmployee() {
		System.out.println("사원 수정");

	}

	private void deleteEmployee() {
		System.out.println("사원 삭제");

	}

	private void findByEmployee() {
		System.out.println("사원 검색");

	}

}
