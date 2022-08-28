package com.cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.subject.SubjectDAO;
import com.subject.SubjectDAOImpl;
import com.util.DBConn;

public class CatUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int ca;
	CatDateDAO cdao = new CatDateDAOImpl();
	SubjectDAO pdao = new SubjectDAOImpl();

	public void categorymenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		ca = Integer.parseInt(br.readLine());

		while (true) {

			try {
				System.out.print("1.중분류일정 등록 2. 중분류일정 수정 3. 중분류일정 삭제 4. 중분류실적종료일 추가 5.업무 구성비");

				ca = Integer.parseInt(br.readLine());

				if (ca == 5) {
					DBConn.close();
					return;
				}

				switch (ca) {
				case 1:
					insertCatDate();
					break;
				case 2:
					updateCatDate();
					break;
				case 3:
					updateCatDateEnd();
					break;
				case 4:
					deleteCategory();
					break;

				}

			} catch (Exception e) {
			}

		}

	}
	
	public void insertCatDate() {
		System.out.println("[중분류 일정 등록]");
		int sub_date_code;
		try {
			CatDateDTO dto = new CatDateDTO();
			System.out.print("대분류 일정 코드 ? "); // 대분류 일정코드
			sub_date_code = Integer.parseInt(br.readLine());
			
			dto.setSub_date_code(sub_date_code);
			
			System.out.print("중분류 일정 코드?"); // 중분류 일정코드
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);
			
			System.out.print("중분류일정 명"); // 중분류 명
			dto.setCat_name(br.readLine());
			
			System.out.print("중분류계획시작일"); // 중분류 명
			dto.setCat_name(br.readLine());
			
			System.out.print("중분류계획종료일"); // 중분류 명
			dto.setCat_plan_start(br.readLine());
			
			System.out.print("중분류실적시작일"); // 중분류 명
			dto.setCat_start(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void updateCatDate() {
		try {
			CatDateDTO dto = new CatDateDTO();
			System.out.println("[중분류 일정 수정]"); // 대분류 일정코드
			System.out.print("수정할 중분류 일정 코드");
			dto.setCat_date(Integer.parseInt(br.readLine()));
			
			System.out.print("중분류일정 코드?"); // 중분류 일정코드
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);
			
			System.out.print("중분류일정 명"); // 중분류 명
			dto.setCat_name(br.readLine());
			
			System.out.print("중분류계획시작일"); // 중분류 명
			dto.setCat_name(br.readLine());
			
			System.out.print("중분류계획종료일"); // 중분류 명
			dto.setCat_plan_start(br.readLine());
			
			System.out.print("중분류실적시작일"); // 중분류 명
			dto.setCat_start(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updateCatDateEnd() {
		try {
			CatDateDTO dto = new CatDateDTO();
			System.out.println("[중분류실적종료일 추가]"); // 대분류 일정코드
			System.out.print("추가할 중분류일정 코드");
			dto.setCat_date(Integer.parseInt(br.readLine()));
			
			System.out.print("중분류일정 코드?"); // 중분류 일정코드
			int n = Integer.parseInt(br.readLine());
			dto.setCat_date(n);
			
			System.out.print("중분류실적종료일 ? "); // 중분류 명
			dto.setCat_end(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void deleteCategory() {
		// TODO Auto-generated method stub
		
	}

}
