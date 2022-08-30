package com.emp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.util.DBConn;

public class EmployeeUI { // EmployeeUI로 이름 수정

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	EmployeeDAO dao = new EmployeeDAOImpl();
	CooperationDAO cdao = new CooperationDAOImpl();

	int ch;

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

	private void workManage() { // 실적관리
		// TODO Auto-generated method stub

	}

	private void companyManage() { // 업체 관리 메인 메뉴
		while (true) {

			try {
				System.out.println("1. 업체 입력 2. 업체 수정 3. 업체 삭제 4. 업체 조회");
				System.out.println("5. 업체 사원 입력 6. 업체 사원 수정 7. 뒤로가기");

				ch = Integer.parseInt(br.readLine());

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
				case 5:
					insertCompanyEmp();
					break;
				case 6:
					updateCompanyEmp();
					break;
				case 7:
					return;

				}

			} catch (Exception e) {
			}

		}
	}

	private void insertCompany() {
		System.out.println("[업체 입력]");

		try {
			CooperationDTO dto = new CooperationDTO();

			System.out.print("업체 코드 ? ");
			dto.setCoo_code(Integer.parseInt(br.readLine()));

			System.out.print("업체명 ? ");
			dto.setCoo_name(br.readLine());

			System.out.print("업체 전화번호 ? ");
			dto.setCoo_tel(br.readLine());

			System.out.print("업체 담당자명 ? ");
			dto.setCoo_manager(br.readLine());

			int result = cdao.cooperInsert(dto);

			if (result != 0) {
				System.out.println("[데이터 입력 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 입력 실패]");
		}

	}

	private void insertCompanyEmp() { // cooperEmpInsert
		System.out.println("[업체 사원 입력]");

		try {
			CooperationDTO dto = new CooperationDTO();

			System.out.print("업체 코드 ? ");
			dto.setCoo_code(Integer.parseInt(br.readLine()));

			System.out.print("사원 코드 ? ");
			dto.setUser_code(Integer.parseInt(br.readLine()));

			System.out.print("업체 사원 코드 ? ");
			dto.setCoo_user_code(Integer.parseInt(br.readLine()));

			System.out.print("업체 사원 입사일 ? ");
			dto.setWork_start_date(br.readLine());

			System.out.print("업체 사원 퇴사일 ? ");
			dto.setWork_end_date(br.readLine());

			int result = cdao.cooperEmpInsert(dto);

			if (result != 0) {
				System.out.println("[데이터 입력 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 입력 실패]");
		}

	}

	private void updateCompany() {
		System.out.println("[업체 수정]");

		try {
			CooperationDTO dto = new CooperationDTO();

			System.out.print("업체 코드 ? ");
			dto.setCoo_code(Integer.parseInt(br.readLine()));

			System.out.print("업체 이름 ? ");
			dto.setCoo_name(br.readLine());

			System.out.print("업체 전화번호 ? ");
			dto.setCoo_tel(br.readLine());

			System.out.print("업체 담당자명 ? ");
			dto.setCoo_manager(br.readLine());

			int result = cdao.cooperUpdate(dto);

			if (result != 0) {
				System.out.println("[데이터 입력 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 입력 실패]");
		}

	}

	private void updateCompanyEmp() {
		System.out.println("[업체 사원 수정]");

		try {
			CooperationDTO dto = new CooperationDTO();

			System.out.print("업체 사원 코드 ? ");
			dto.setCoo_user_code(Integer.parseInt(br.readLine()));

			System.out.print("사원 입사일 ? ");
			dto.setWork_start_date(br.readLine());

			System.out.print("사원 퇴사일 ? ");
			dto.setWork_end_date(br.readLine());

			int result = cdao.cooperEmpUpdate(dto);

			if (result != 0) {
				System.out.println("[데이터 입력 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 입력 실패]");
		}

	}

	private void deleteCompany() {
		System.out.println("[업체 삭제 메뉴]");
		int ch;

		try {

			System.out.println("1. 업체 코드 삭제 2. 업체명 삭제 3. 업체 사원 코드 삭제 4. 뒤로가기");
			ch = Integer.parseInt(br.readLine());

			switch (ch) {
			case 1:
				deleteCompanyCode();
				break;
			case 2:
				deleteCompanyName();
				break;
			case 3:
				deleteCompanyEmp();
				break;
			case 4:
				return;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteCompanyCode() {
		System.out.println("[업체 코드 삭제]");

		try {

			System.out.print("업체 코드를 입력해 주세요.");
			int result = cdao.cooperDeleteCode(br.readLine());

			if (result != 0) {
				System.out.println("[데이터 삭제 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 삭제 실패]");
			System.out.println("입력된 사원코드가 존재하지 않습니다.");
		}

	}

	private void deleteCompanyName() {
		System.out.println("[업체명 삭제]");

		try {

			System.out.print("업체명을 입력해 주세요.");
			int result = cdao.cooperDeleteName(br.readLine());

			if (result != 0) {
				System.out.println("[데이터 삭제 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 삭제 실패]");
			System.out.println("입력된 사원명이 존재하지 않습니다.");
		}

	}

	private void deleteCompanyEmp() {
		System.out.println("[업체 사원 코드 삭제]");

		try {

			System.out.print("업체 사원 코드를 입력해 주세요.");
			int result = cdao.cooperEmpDeleteCode(br.readLine());

			if (result != 0) {
				System.out.println("[데이터 삭제 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 삭제 실패]");
			System.out.println("입력된 사원명이 존재하지 않습니다.");
		}

	}

	private void searchCompany() { // 업체 조회 서브 메뉴
		while (true) {

			try {
				System.out.print("1.업체 이름 조회 2.업체 코드 조회 3.전체 업체 조회 4. 업체 사원 코드 조회 5. 뒤로가기");

				ch = Integer.parseInt(br.readLine());

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
				case 4:
					findByCompanyEmpCode();
					break;
				case 5:
					return;
				}

			} catch (Exception e) {
			}

		}

	}

	private void findByCompanyCode() { // cooperSearchCode

		try {

			System.out.print("조회할 업체 코드를 입력해 주세요. => ");
			List<CooperationDTO> list = cdao.cooperSearchCode(br.readLine());

			if (list.size() == 0) {

				System.out.println("입력한 업체 코드를 가진 데이터가 존재하지 않습니다.");

			} else {

				System.out.println("업체코드\t업체명\t사원코드\t담당자명\t업체 전화번호" + "\t입사일\t\t퇴사일");

				for (CooperationDTO dto : list) {

					System.out.print(dto.getCoo_code() + "\t");
					System.out.print(dto.getCoo_name() + "\t");
					System.out.print(dto.getUser_code() + "\t");
					System.out.print(dto.getCoo_manager() + "\t");
					System.out.print(dto.getCoo_tel() + "\t");
					System.out.print(dto.getWork_start_date() + "\t");
					System.out.print(dto.getWork_end_date() + "\t");

					System.out.println();

				}
				System.out.println();

			}
		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");
		}

	}

	private void findByCompanyName() { // cooperSearchName

		try {

			System.out.print("조회할 업체명을 입력해 주세요. => ");
			List<CooperationDTO> list = cdao.cooperSearchName(br.readLine());

			if (list.size() == 0) {

				System.out.println("입력한 업체명을 가진 데이터가 존재하지 않습니다.");

			} else {

				System.out.println("업체코드\t업체명\t사원코드\t담당자명\t업체 전화번호" + "\t입사일\t\t퇴사일");

				for (CooperationDTO dto : list) {

					System.out.print(dto.getCoo_code() + "\t");
					System.out.print(dto.getCoo_name() + "\t");
					System.out.print(dto.getUser_code() + "\t");
					System.out.print(dto.getCoo_manager() + "\t");
					System.out.print(dto.getCoo_tel() + "\t");
					System.out.print(dto.getWork_start_date() + "\t");
					System.out.print(dto.getWork_end_date() + "\t");

					System.out.println();

				}
				System.out.println();

			}
		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");
		}

	}

	private void listCompany() { // cooperSearchAll

		try {

			System.out.println("[전체 업체 조회]");
			List<CooperationDTO> list = cdao.cooperSearchAll();

			if (list.size() == 0) {

				System.out.println("데이터가 존재하지 않습니다.");

			} else {

				System.out.println("업체코드\t업체명\t사원코드\t담당자명\t업체 전화번호" + "\t입사일\t\t퇴사일");

				for (CooperationDTO dto : list) {

					System.out.print(dto.getCoo_code() + "\t");
					System.out.print(dto.getCoo_name() + "\t");
					System.out.print(dto.getUser_code() + "\t");
					System.out.print(dto.getCoo_manager() + "\t");
					System.out.print(dto.getCoo_tel() + "\t");
					System.out.print(dto.getWork_start_date() + "\t");
					System.out.print(dto.getWork_end_date() + "\t");

					System.out.println();

				}
				System.out.println();

			}
		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");
		}

	}

	private void findByCompanyEmpCode() { // cooperSearchCode

		try {

			System.out.print("조회할 업체사원코드을 입력해 주세요. => ");
			CooperationDTO dto = cdao.cooperSearchEmpCode(br.readLine());

			if (dto == null) {

				System.out.println("입력한 업체사원코드를 가진 데이터가 존재하지 않습니다.");

			} else {

				System.out.println("업체사원코드\t업체명\t사원코드\t담당자명" + "\t업체전화번호\t\t입사일\t\t퇴사일");

				System.out.print(dto.getCoo_user_code() + "\t\t");
				System.out.print(dto.getCoo_name() + "\t");
				System.out.print(dto.getUser_code() + "\t");
				System.out.print(dto.getCoo_manager() + "\t");
				System.out.print(dto.getCoo_tel() + "\t\t");
				System.out.print(dto.getWork_start_date() + "\t");
				System.out.print(dto.getWork_end_date() + "\t");

				System.out.println();

				System.out.println();

			}
		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");
		}

	}

	/*
	 * private void findByCompanyEmpName() { // cooperSearchName // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * private void listCompanyEmp() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public void employeeManage() { // 인사 관리 메인 메뉴
		while (true) {

			try {
				System.out.print("1. 사원 입력 2. 사원 정보 수정 3.사원 삭제 4.사원 조회 5.뒤로가기 6. 로그아웃 7. 종료 ");

				ch = Integer.parseInt(br.readLine());
				if (ch == 7) {
					DBConn.close();
					System.exit(0);
				}

				switch (ch) {
				case 1:
					insertEmployee(); // 사원 데이터 입력
					break;
				case 2:
					updateEmployee(); // 사원 데이터 수정
					break;
				case 3:
					deleteEmployeeCode(); // 사원 데이터 삭제
					break;
				case 4:
					findByEmployee(); // 사원 조회 서브 메뉴
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

	private void findByEmployee() { // 사원 조회 서브 메뉴

		while (true) {

			System.out.print("1. 사원 번호 조회 2. 사원 이름 조회 3. 전체 사원 조회 4. 뒤로가기 5. 종료");

			int ch;

			try {

				ch = Integer.parseInt(br.readLine());

				if (ch == 5) {
					DBConn.close();
					System.exit(0);
				}

				switch (ch) {
				case 1:
					findByEmployeeCode();
					break; // 사원 코드 조회
				case 2:
					searchName();
					break; // 사원 이름 조회
				case 3:
					findByEmployeeAll();
					break; // 전체 사원 조회
				case 4:
					return; // 뒤로 가기
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void insertEmployee() {
		System.out.println("[사원 등록]");

		try {
			EmployeeDTO dto = new EmployeeDTO();

			System.out.print("사원 번호 ? ");
			dto.setUser_code(Integer.parseInt(br.readLine()));

			System.out.print("사원 비밀번호 ? (입력 안할 시 초기번호 1234)");
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

			if (result != 0) {
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

			if (result != 0) {
				System.out.println("데이터 수정 성공 !!");
			}

		} catch (Exception e) {
			System.out.println("[데이터 수정 실패]");
			System.out.println("사원 코드 또는 비밀번호가 잘못 입력 되었습니다.");
		}

	}

	private void deleteEmployeeCode() { // 사원 번호 입력 받아 삭제
		System.out.println("[사원 삭제]");

		try {

			System.out.print("사원 번호를 입력해 주세요.");
			int result = dao.deleteEmployee(br.readLine());

			if (result != 0) {
				System.out.println("[데이터 삭제 성공]");
			}

		} catch (Exception e) {
			System.out.println("[데이터 삭제 실패]");
			System.out.println("입력된 사원코드가 존재하지 않거나 잘못 입력하셨습니다.");
		}

	}

	private void findByEmployeeCode() { // 사원 코드 입력 받아 조회
		System.out.println("[사원 코드 조회]");

		try {

			System.out.print("조회하실 사원의 코드를 입력해 주세요. => ");
			EmployeeDTO dto = dao.readEmployee(br.readLine());

			if (dto != null) {

				System.out.println("사원코드\t사원이름\t주민등록번호\t전화번호\t\t자택주소" + "\t\t직무\t입사일\t\t퇴사일");

				System.out.print(dto.getUser_code() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.print(dto.getRrn() + "\t");
				System.out.print(dto.getTel() + "\t");
				System.out.print(dto.getAddress() + "\t");
				System.out.print(dto.getDuty() + "\t");
				System.out.print(dto.getHireDate() + "\t");
				System.out.print(dto.getResigndate());
			} else {
				System.out.println("입력된 사원코드가 존재하지 않거나 잘못 입력하셨습니다.");
			}

			System.out.println();

		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");

		}

	}

	private void searchName() {

		System.out.println("[사원 이름 조회]");

		try {

			System.out.print("조회하실 사원의 이름을 입력해 주세요. => ");
			List<EmployeeDTO> list = dao.searchName(br.readLine());

			if (list.size() == 0) {

				System.out.println("입력한 사원의 이름을 가진 데이터가 존재하지 않습니다.");

			} else {

				System.out.println("사원코드\t사원이름\t주민등록번호\t전화번호\t\t자택주소" + "\t\t직무\t입사일\t\t퇴사일");

				for (EmployeeDTO dto : list) {

					System.out.print(dto.getUser_code() + "\t");
					System.out.print(dto.getName() + "\t");
					System.out.print(dto.getRrn() + "\t");
					System.out.print(dto.getTel() + "\t");
					System.out.print(dto.getAddress() + "\t");
					System.out.print(dto.getDuty() + "\t");
					System.out.print(dto.getHireDate() + "\t");
					System.out.print(dto.getResigndate());
					System.out.println();

				}
				System.out.println();

			}

		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");

		}

	}

	private void findByEmployeeAll() { // 전체 사원 조회
		System.out.println("[전체 사원 조회]");

		try {

			List<EmployeeDTO> list = dao.listEmployee();

			if (list == null) {
				System.out.println("데이터가 존재하지 않습니다.");
			}

			System.out.println("사원코드\t사원이름\t주민등록번호\t전화번호\t\t자택주소" + "\t\t직무\t입사일\t\t퇴사일");

			for (EmployeeDTO dto : list) {

				System.out.print(dto.getUser_code() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.print(dto.getRrn() + "\t");
				System.out.print(dto.getTel() + "\t");
				System.out.print(dto.getAddress() + "\t");
				System.out.print(dto.getDuty() + "\t");
				System.out.print(dto.getHireDate() + "\t");
				System.out.print(dto.getResigndate());
				System.out.println();

			}
			System.out.println();

		} catch (Exception e) {
			System.out.println("[데이터 조회 실패]");
		}

	}

}
