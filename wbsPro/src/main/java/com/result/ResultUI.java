package com.result;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cat.CatDateDTO;
import com.op.OpDateDTO;
import com.project.ProjectDTO;
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
				case 4: resultProgressPerOpDate(); break; // 소분류 실적진척율 입력
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
				case 1: resultProgressProjectStartInput();break;
				case 2: resultProgressSubDateStart();break;
				case 3: resultProgressCatDateStartInput();break;
				case 4: resultProgressOpDateStartInput();break;
				case 5: return; 
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void resultProgressProjectStartInput() {// 실적시작일 입력(프로젝트)
		System.out.println("프로젝트 실적 시작일 입력");
		
		try {
			ProjectDTO dto = new ProjectDTO();
			
			System.out.print("프로젝트 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setPrj_code(n);	
			
			System.out.print("프로젝트 실적 시작일을 입력하세요.");
			dto.setPrj_start(br.readLine());	
			
			
			int result = dao.resultProgressProjectStartInput(dto);
			
			if(result != 0) {
				 System.out.println("[프로젝트 실적시작일 입력 성공]");
			 } else {
				 System.out.println("[프로젝트 실적시작일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[프로젝트 실적시작일 입력 오류]");
		}
		
	}
	
		
	public void resultProgressSubDateStart() {// 실적시작일 입력(대분류)
		System.out.println("대분류 실적 시작일 입력");
		int result = 0;
		
		try {
			SubjectDTO dto = new SubjectDTO();
			
			
			System.out.print("프로젝트 코드 ? ");
			int prjCode = Integer.parseInt(br.readLine());
			
			ProjectDTO pdto = dao.projectbetweenDate(prjCode);
			
			
			System.out.print("대분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);	
			
			System.out.print("대분류 실적 시작일을 입력하세요.");
			dto.setSub_start(br.readLine());	
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(pdto.getPrj_start());
			Date date2 = sdf.parse(pdto.getPrj_end());
			
			Date datePro = sdf.parse(dto.getSub_start());
			
			
			
			if(datePro.compareTo(date1) >= 0 && // 입력 날짜 >= 시작일
			   datePro.compareTo(date2) <= 0) { // 입력 날짜 <= 종료일
				result = dao.resultProgressSubDateStartInput(dto);
			}
			
			
			
			if(result != 0) {
				 System.out.println("[대분류 실적시작일 입력 성공]");
			 } else {
				 System.out.println("[대분류 실적시작일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[대분류 실적시작일 입력 오류]");
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressCatDateStartInput() {// 실적시작일 입력(중분류)
		System.out.println("중분류 실적 시작일 입력");
		
		int result = 0;
		
		try {
			
			CatDateDTO dto = new CatDateDTO();			
			
			System.out.print("프로젝트 코드 ? ");
			int prjCode = Integer.parseInt(br.readLine());
			
			ProjectDTO pdto = dao.projectbetweenDate(prjCode);
			
			
			System.out.print("중분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);	
			
			System.out.print("중분류 실적 시작일을 입력하세요.");
			dto.setCat_start(br.readLine());
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(pdto.getPrj_start());
			Date date2 = sdf.parse(pdto.getPrj_end());
			
			Date datePro = sdf.parse(dto.getCat_start());
			
			
			
			if(datePro.compareTo(date1) >= 0 && // 입력 날짜 >= 시작일
			   datePro.compareTo(date2) <= 0) { // 입력 날짜 <= 종료일
				result = dao.resultProgressCatDateStartInput(dto);
			} 
			
			
			
			if(result != 0) {
				 System.out.println("[중분류 실적시작일 입력 성공]");
			 } else {
				 System.out.println("[중분류 실적시작일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[중분류 실적시작일 입력 오류]");
			e.printStackTrace();
		}
		
	}
	
	public void resultProgressOpDateStartInput() {// 실적시작일 입력(소분류)
		System.out.println("소분류 실적 시작일 입력");
		
		int result = 0;
		
		try {
			
			OpDateDTO dto = new OpDateDTO();			
			
			System.out.print("프로젝트 코드 ? ");
			int prjCode = Integer.parseInt(br.readLine());
			
			ProjectDTO pdto = dao.projectbetweenDate(prjCode);
			
			
			System.out.print("소분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setOp_date(n);	
			
			System.out.print("소분류 실적 시작일을 입력하세요.");
			dto.setOp_plan_start(br.readLine());
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(pdto.getPrj_start());
			Date date2 = sdf.parse(pdto.getPrj_end());
			
			Date datePro = sdf.parse(dto.getOp_start());
			
			
			
			if(datePro.compareTo(date1) >= 0 && // 입력 날짜 >= 시작일
			   datePro.compareTo(date2) <= 0) { // 입력 날짜 <= 종료일
				result = dao.resultProgressOpDateStartInput(dto);
			} 
			
			
			
			if(result != 0) {
				 System.out.println("[소분류 실적시작일 입력 성공]");
			 } else {
				 System.out.println("[소분류 실적시작일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[소분류 실적시작일 입력 오류]");
		}
		
	}

	public void resultProgDateEnd() { // 실적종료일 입력
		while (true) {

			try {
				System.out.print("1.프로젝트실적종료일 입력 2.대분류실적종료일 입력 3.중분류실적종료일 입력 4.소분류실적종료일 입력  5.뒤로가기");

				 ch = Integer.parseInt(br.readLine());



				switch (ch) {
				case 1: resultProgressProjectEndInput();break;
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
		
	public void resultProgressProjectEndInput() {// 실적종료일 입력(프로젝트)
		System.out.println("프로젝트 실적 종료일 입력");
		
		try {
			ProjectDTO dto = new ProjectDTO();
			
			System.out.print("프로젝트 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setPrj_code(n);	
			
			System.out.print("프로젝트 실적 종료일을 입력하세요.");
			dto.setPrj_end(br.readLine());	
			
			
			int result = dao.resultProgressProjectEndInput(dto);
			
			if(result != 0) {
				 System.out.println("[프로젝트 실적종료일 입력 성공]");
			 } else {
				 System.out.println("[프로젝트 실적종료일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[프로젝트 실적종료일 입력 오류]");
		}
		
	}
	
	public void resultProgressSubDateEndInput() {// 실적종료일 입력(대분류)
		System.out.println("대분류 실적 종료일 입력");
		
		int result = 0;
		
		try {
			SubjectDTO dto = new SubjectDTO();
			
			
			System.out.print("프로젝트 코드 ? ");
			int prjCode = Integer.parseInt(br.readLine());
			
			ProjectDTO pdto = dao.projectbetweenDate(prjCode);
			
			
			System.out.print("대분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);	
			
			System.out.print("대분류 실적 종료일을 입력하세요.");
			dto.setSub_end(br.readLine());	
			
			String subStart = dao.ProgressStartSubDate(n);
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date prj_start = sdf.parse(pdto.getPrj_start());
			Date prj_end = sdf.parse(pdto.getPrj_end());
			
			Date endDate = sdf.parse(dto.getSub_end()); // 실적 종료일
			
			Date startDate = sdf.parse(subStart); // DB내에 있는 실적 시작일
			
			
			if(endDate.compareTo(prj_start) >= 0 && // 입력 날짜 >= 시작일
			   endDate.compareTo(prj_end) <= 0) { // 입력 날짜 <= 종료일
				if(endDate.compareTo(startDate) >= 0) { // 종료일 >= 시작일
					
					result = dao.resultProgressSubDateEndInput(dto);
					
				}
			}
			
			
			if(result != 0) {
				 System.out.println("[대분류 실적종료일 입력 성공]");
			 } else {
				 System.out.println("[대분류 실적종료일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[대분류 실적종료일 입력 오류]");
		}
		
	}
	
	



	public void resultProgressCatDateEndInput() {// 실적종료일 입력(중분류)
		System.out.println("중분류 실적 종료일 입력");
		
		int result = 0;
		
		try {
			CatDateDTO dto = new CatDateDTO();
			
			
			System.out.print("프로젝트 코드 ? ");
			int prjCode = Integer.parseInt(br.readLine());
			
			ProjectDTO pdto = dao.projectbetweenDate(prjCode);
			
			
			System.out.print("중분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setSub_date_code(n);	
			
			System.out.print("중분류 실적 종료일을 입력하세요.");
			dto.setCat_end(br.readLine());	
			
			String catStart = dao.ProgressStartCatDate(n);
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date prj_start = sdf.parse(pdto.getPrj_start());
			Date prj_end = sdf.parse(pdto.getPrj_end());
			
			Date endDate = sdf.parse(dto.getCat_end()); // 실적 종료일
			
			Date startDate = sdf.parse(catStart); // DB내에 있는 실적 시작일
			
			
			if(endDate.compareTo(prj_start) >= 0 && // 입력 날짜 >= 시작일
			   endDate.compareTo(prj_end) <= 0) { // 입력 날짜 <= 종료일
				if(endDate.compareTo(startDate) >= 0) { // 종료일 >= 시작일
					
					result = dao.resultProgressCatDateEndInput(dto);
					
				}
			}
			
			if(result != 0) {
				 System.out.println("[중분류 실적종료일 입력 성공]");
			 } else {
				 System.out.println("[중분류 실적종료일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[중분류 실적종료일 입력 오류]");
		}
		
	}
	
	public void resultProgressOpDateEndInput() {// 실적종료일 입력(소분류)
		System.out.println("소분류 실적 종료일 입력");
		
		int result = 0;
		
		try {
			OpDateDTO dto = new OpDateDTO();
			
			
			System.out.print("프로젝트 코드 ? ");
			int prjCode = Integer.parseInt(br.readLine());
			
			ProjectDTO pdto = dao.projectbetweenDate(prjCode);
			
			
			System.out.print("소분류 코드 ? ");
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);	
			
			System.out.print("소분류 실적 종료일을 입력하세요.");
			dto.setOp_end(br.readLine());
			
			String opStart = dao.ProgressStartCatDate(n);
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date prj_start = sdf.parse(pdto.getPrj_start());
			Date prj_end = sdf.parse(pdto.getPrj_end());
			
			Date endDate = sdf.parse(dto.getOp_end()); // 실적 종료일
			
			Date startDate = sdf.parse(opStart); // DB내에 있는 실적 시작일
			
			
			if(endDate.compareTo(prj_start) >= 0 && // 입력 날짜 >= 시작일
			   endDate.compareTo(prj_end) <= 0) { // 입력 날짜 <= 종료일
				if(endDate.compareTo(startDate) >= 0) { // 종료일 >= 시작일
					
					result = dao.resultProgressOpDateEndInput(dto);
					
				}
			}
			
			if(result != 0) {
				 System.out.println("[소분류 실적종료일 입력 성공]");
			 } else {
				 System.out.println("[소분류 실적종료일 입력 실패]");
			 }
			
		} catch (Exception e) {
			System.out.println("[소분류 실적종료일 입력 오류]");
		}
		
	}
	
	/*
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
	*/
	
	public void resultProgressPerOpDate() {  // 소분류실적진척율 입력
		
		System.out.println("[소분류 실적 진척율 입력]");
		
		try {
			
			System.out.print("소분류 코드 ? ");
			int op_date = Integer.parseInt(br.readLine());
			
			System.out.print("소분류 실적진척율 ? ");
			int performOpDate = Integer.parseInt(br.readLine());
			
			int result = dao.perforProgressOpDateUpdate(op_date, performOpDate);
			
			
			if(result != 0) {
				System.out.println("[소분류 실적진척율 입력 성공]");
			} else {
				System.out.println("[소분류 실적진척율 입력 실패]");
			}
			
			
		} catch (Exception e) {
			System.out.println("[소분류 실적진척율 입력 오류]");
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
