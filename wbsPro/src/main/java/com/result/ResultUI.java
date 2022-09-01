package com.result;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cat.CatDateDTO;
import com.op.OpDateDTO;
import com.subject.SubjectDTO;
import com.util.DBConn;

public class ResultUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ResultDAO dao = new ResultDAOImpl();
	
	int ch ;
	
	public void menu() { 
		
		while (true) {

			try {
				System.out.print("1.업무구성비 입력 2.실적시작일 입력 3.실적종료일 입력 4.실적진척율 입력 5.뒤로가기");

				 ch = Integer.parseInt(br.readLine());


				switch (ch) {
				case 1: compositMenu(); break;
				case 2: resultProgDateStart(); break;
				case 3: resultProgDateEnd(); break;
				case 4: resultProgressPerMenu(); break;
				case 5: return; 
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}

		}
	}
		

	
	public void compositMenu() { // 업무구성비 메뉴
		
		while (true) {

			try {
				System.out.print("1.소분류업무구성비 입력 2.중분류업무구성비 입력 3.대분류업무구성비 입력 4.뒤로가기");

				 ch = Integer.parseInt(br.readLine());



				switch (ch) {
				case 1: compositionOpDate(); break;
				case 2: compositionCatDate(); break;
				case 3: compositionSubDate(); break;
				case 4: return; 
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void resultProgDateStart() { // 실적시작일 입력
		while (true) {

			try {
				System.out.print("1.프로젝트실적시작일 입력 2.대분류실적시작일 입력 3.중분류실적시작일 입력 4.소분류실적시작일 입력  5.뒤로가기");

				 ch = Integer.parseInt(br.readLine());



				switch (ch) {
				// case 1: resultProgressProjectDateStartInput();break; 아직 없음
				case 2: resultProgressSubDateStartInput();break;
				case 3: resultProgressCatDateStartInput();break;
				case 4: resultProgressOpDateStartInput();break;
				case 5: return; 
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void resultProgressProjectDateStartInput() {// 실적시작일 입력(프로젝트)
		System.out.println("프로젝트 실적 시작일 입력");
		
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		
	public void resultProgressSubDateStartInput() {// 실적시작일 입력(대분류)
		System.out.println("대분류 실적 시작일 입력");
		
		try {
			SubjectDTO dto = new SubjectDTO();
			
			System.out.print("대분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);	
			
			System.out.print("대분류 실적 시작일을 입력하세요.");
			dto.setSub_start(br.readLine());	
			
			
			dao.resultProgressSubDateStartInput(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressCatDateStartInput() {// 실적시작일 입력(중분류)
		System.out.println("중분류 실적 시작일 입력");
		
		try {
			CatDateDTO dto = new CatDateDTO();
			
			System.out.print("중분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);
			
			System.out.print("중분류 실적 시작일을 입력하세요.");
			dto.setCat_start(br.readLine());	
			

			dao.resultProgressCatDateStartInput(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressOpDateStartInput() {// 실적시작일 입력(소분류)
		System.out.println("소분류 실적 시작일 입력");
		
		try {
			OpDateDTO dto = new OpDateDTO();
			
			System.out.print("소분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setOp_date(n);
			
			System.out.print("소분류 실적 시작일을 입력하세요.");
			dto.setOp_start(br.readLine());	
			
			dao.resultProgressOpDateStartInput(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void resultProgDateEnd() { // 실적종료일 입력
		while (true) {

			try {
				System.out.print("1.프로젝트실적종료일 입력 2.대분류실적종료일 입력 3.중분류실적종료일 입력 4.소분류실적종료일 입력  5.뒤로가기");

				 ch = Integer.parseInt(br.readLine());



				switch (ch) {
				case 1: resultProgressProjectDateEndInput();break;
				case 2: resultProgressSubDateEndInput();break;
				case 3: resultProgressCatDateEndInput();break;
				case 4: resultProgressOpDateEndInput();break;
				case 5: return; 
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
		
	public void resultProgressProjectDateEndInput() {// 실적종료일 입력(프로젝트)
		System.out.println("프로젝트 실적 종료일 입력");
		
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressSubDateEndInput() {// 실적종료일 입력(대분류)
		System.out.println("대분류 실적 종료일 입력");
		
		try {
			SubjectDTO dto = new SubjectDTO();
			
			System.out.print("대분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);	
			
			System.out.print("대분류 실적 종료일을 입력하세요.");
			dto.setSub_end(br.readLine());	
			
			
			dao.resultProgressSubDateEndInput(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressCatDateEndInput() {// 실적종료일 입력(중분류)
		System.out.println("중분류 실적 종료일 입력");
		
		try {
			CatDateDTO dto = new CatDateDTO();
			
			System.out.print("중분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);	
			
			System.out.print("중분류 실적 종료일을 입력하세요.");
			dto.setCat_end(br.readLine());	
			

			dao.resultProgressCatDateEndInput(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressOpDateEndInput() {// 실적종료일 입력(소분류)
		System.out.println("소분류 실적 종료일 입력");
		
		try {
			OpDateDTO dto = new OpDateDTO();
			
			System.out.print("소분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setOp_date(n);	
			
			System.out.print("소분류 실적 종료일을 입력하세요.");
			dto.setOp_end(br.readLine());	
			
			dao.resultProgressOpDateEndInput(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void resultProgressPerMenu() { // 실적진척율 메뉴
		
		while (true) {

			try {
				System.out.print("1.소분류실적진척율 입력 2.중분류실적진척율 입력 3.대분류실적진척율 입력 4.뒤로가기");

				 ch = Integer.parseInt(br.readLine());



				switch (ch) {
				case 1: resultProgressPerOpDate(); break;
				case 2: // resultProgressPerCatDate(); break;
				case 3: // resultProgressPerSubDate(); break;
				case 4: return; 
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void resultProgressPerOpDate() {  // 소분류실적진척율 입력
		
		System.out.println("[소분류 실적 진척율 입력]");
		
		try {
			
			System.out.print("소분류 코드 ? ");
			int op_date = Integer.parseInt(br.readLine());
			
			System.out.print("실적 진척율 ? ");
			int performOpDate = Integer.parseInt(br.readLine());
			
			int result = dao.perforProgressOpDateUpdate(op_date, performOpDate);
			
			
			if(result != 0) {
				System.out.println("[소분류 실적 진척율 입력 성공]");
			} else {
				System.out.println("[소분류 실적 진척율 입력 실패]");
			}
			
			
		} catch (Exception e) {
			System.out.println("[소분류 실적 진척율 입력 오류]");
		}
		
	}
		
	public void resultProgressPerCatDate() { // 중분류실적진척율 입력
		
	}
	
	public void resultProgressPerSubDate() { // 대분류실적진척율 입력
		
	}
	
	public void compositionOpDate() {
		System.out.println("[소분류 업무 구성비 입력]");
		
		try {
			System.out.print("중분류 코드 ? ");
			int c = Integer.parseInt(br.readLine());
			
			System.out.print("소분류 코드 ? ");
			int a = Integer.parseInt(br.readLine());
			
			System.out.print("업무 구성비 ? ");
			int b = Integer.parseInt(br.readLine());
			
			int output = dao.workCompositionOpDate(c, a, b);
			
			
			if(output != 100) {
				System.out.println("업무구성비의 총합은 100이어야 합니다");
				System.out.println("다시 입력해주세요!");
			} else {
				System.out.println("[업무 구성비 입력 성공]");
			}
			
			
		} catch (Exception e) {
			System.out.println("[업무 구성비 입력 실패]");
		}
		
	}
	// 206 901116 1 4
	public void compositionCatDate() {
		System.out.println("[중분류 업무 구성비 입력]");
		
		try {
			System.out.print("대분류 코드 ? ");
			int c = Integer.parseInt(br.readLine());
			
			System.out.print("중분류 코드 ? ");
			int a = Integer.parseInt(br.readLine());
			
			System.out.print("업무 구성비 ? ");
			int b = Integer.parseInt(br.readLine());
			
			int output = dao.workCompositionCatDate(c, a, b);
			
			
			if(output != 100) {
				System.out.println("업무구성비의 총합은 100이어야 합니다");
				System.out.println("다시 입력해주세요!");
			} else {
				System.out.println("[업무 구성비 입력 성공]");
			}
			
			
		} catch (Exception e) {
			System.out.println("[업무 구성비 입력 실패]");
		}
		
	}

	public void compositionSubDate() {
		System.out.println("[대분류 업무 구성비 입력]");
		
		try {
			System.out.print("프로젝트 코드 ? ");
			int c = Integer.parseInt(br.readLine());
			
			System.out.print("대분류 코드 ? ");
			int a = Integer.parseInt(br.readLine());
			
			System.out.print("업무 구성비 ? ");
			int b = Integer.parseInt(br.readLine());
			
			int output = dao.workCompositionSubDate(c, a, b);
			
			
			if(output != 100) {
				System.out.println("업무구성비의 총합은 100이어야 합니다");
				System.out.println("다시 입력해주세요!");
			} else {
				System.out.println("[업무 구성비 입력 성공]");
			}
			
			
		} catch (Exception e) {
			System.out.println("[업무 구성비 입력 실패]");
		}
		
	}
}
