package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.util.DBConn;

public class PlanUI {

	public void menu() {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			try {
				System.out.print("1.작업 등록 2. 작업 수정 3.작업 삭제 4. 작업 검색 5.업무 구성비 6. 로그아웃 7. 종료 ");

				int ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
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
					findByWork();
					break;

				}

			} catch (Exception e) {
			}

		}

	}

	private void insert() {
		System.out.println("작업 등록");

	}

	private void update() {
		System.out.println("작업 수정");

	}

	private void delete() {
		System.out.println("작업 삭제");

	}

	private void findByWork() {
		System.out.println("작업 검색");

	}

}