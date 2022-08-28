package com.emp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.util.DBConn;

public class EmployeeUI { // EmployeeUI로 이름 수정

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	EmployeeDAO dao = new EmployeeDAOImpl();
	
	int ch ;
	
	public void menu() {
		
		
		while (true) {

			try {
				System.out.print("1. 인사 관리 2. 업체 관리 3. 일정 관리 4. 로그아웃 5. 종료 ");

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
				e.printStackTrace();
			}

		}
	}

	private void workManage() {
		// TODO Auto-generated method stub

	}

	private void companyManage() { // 업체 관리 메인 메뉴
		while (true) {

			try {
				System.out.print("1. 업체 입력 2. 업체 수정 3. 업체 삭제 4. 업체 조회");

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
		System.out.println("[업체 입력]");
		
	}
	
	
	private void updateCompany() {
		System.out.println("[업체 수정]");
		
	}
	
	private void deleteCompany() {
		System.out.println("[업체 삭제]");
		
	}

	private void searchCompany() { // 업체 조회 서브 메뉴
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
	

	public void employeeManage() { // 인사 관리 메인 메뉴
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
					deleteEmployeeCode();
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
		System.out.println("[사원 등록]");
		
		
		try {
			EmployeeDTO dto = new EmployeeDTO();
			
			System.out.print("사원 번호 ? ");
			dto.setUser_code(Integer.parseInt(br.readLine()));
			
			System.out.print("사원 비밀번호 ? (입력 안할 시 초기번호 1234");
			dto.setPwd(br.readLine());
			
			System.out.print("사원 이름 ? ");
			dto.setName(br.readLine());
			
			System.out.print("사원 주민번호 ? ");
			dto.setRrn(br.readLine());
			
			System.out.print("사원 전화번호 ? ");
			dto.setTel(br.readLine());
			
			System.out.print("사원 주소 ? ");
			dto.setAddress(br.readLine());
			
			System.out.print("사원 입사일 ? ");
			dto.setHireDate(br.readLine());
			
			System.out.print("사원 직무 ? ");
			dto.setDuty(br.readLine());
			
			System.out.print("사원 퇴사일 ? (재직중일 경우 생략)");
			dto.setResigndate(br.readLine());
			
			
			
			int result = dao.insertEmployee(dto);
			
			if(result != 0) {
				System.out.println("[데이터 입력 성공]");
			} 
			
		} catch (Exception e) {
			System.out.println("[데이터 입력 실패]");
		}
		
	}

	private void updateEmployee() {
		System.out.println("[사원 수정]");

		
		try {
			EmployeeDTO dto = new EmployeeDTO();
			
			System.out.print("사원 번호 ? ");
			dto.setUser_code(Integer.parseInt(br.readLine()));
			
			System.out.print("사원 비밀번호 ? (입력 안할 시 초기번호 1234");
			dto.setPwd(br.readLine());
			
			System.out.print("사원 이름 ? ");
			dto.setName(br.readLine());
			
			System.out.print("사원 전화번호 ? ");
			dto.setTel(br.readLine());
			
			System.out.print("사원 주소 ? ");
			dto.setAddress(br.readLine());
			
			System.out.print("사원 입사일 ? ");
			dto.setHireDate(br.readLine());
			
			System.out.print("사원 직무 ? ");
			dto.setDuty(br.readLine());
			
			System.out.print("사원 퇴사일 ? (재직중일 경우 생략)");
			dto.setResigndate(br.readLine());
			
			
			
			int result = dao.updateEmployee(dto);
			
			if(result != 0) {
				System.out.println("데이터 수정 성공 !!");
			} 
			
		} catch (Exception e) {
			System.out.println("[데이터 수정 실패]");
			System.out.println("사원 코드 또는 비밀번호가 잘못 입력 되었습니다.");
		}
		
	}

	private void deleteEmployeeCode() {    // 사원 번호 입력 받아 삭제
		System.out.println("[사원 삭제]");
		
		try {
			
			System.out.print("사원 번호를 입력해 주세요.");
			int result = dao.deleteEmployee(br.readLine());
		
			if(result != 0) {
				System.out.println("[데이터 삭제 실패]");
			}
			
		} catch (Exception e) {
			System.out.println("[데이터 삭제 실패]");
			System.out.println("입력된 사원코드가 존재하지 않거나 잘못 입력하셨습니다.");
		}
		
		

	}

	private void findByEmployee() {
		System.out.println("[사원 검색]");

	}

}
