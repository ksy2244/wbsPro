package com.result;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.util.DBConn;

public class ResultUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ResultDAO dao = new ResultDAOImpl();
	
	int ch ;
	
	public void menu() { // 업무구성비 메뉴
		
		
		while (true) {

			try {
				System.out.print("1.소분류업무구성비 입력 2.중분류업무구성비 입력 3.대분류업무구성비 입력 4.뒤로가기");

				 ch = Integer.parseInt(br.readLine());

				if (ch == 5) {
					DBConn.close();
					return;
				}

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
