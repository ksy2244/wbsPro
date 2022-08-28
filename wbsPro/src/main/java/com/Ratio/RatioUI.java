package com.Ratio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.subject.SubjectDTO;

public class RatioUI {
	int ch;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void menu() throws NumberFormatException, IOException {
		System.out.println("[업무 구성비]");
		ch = Integer.parseInt(br.readLine());
		System.out.println("1. 업무 구성비 등록 2. 업무 구성비 수정");
		try {
			switch (ch) {
			
			case 1:
				insertRatio();
				break;
			case 2:
				updateRatio();
				break;

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

	private void insertRatio() {
		System.out.println("업무 구성비 등록");
		int prj_code;
		try {
			SubjectDTO sdto = new SubjectDTO();

			System.out.print("프로젝트 코드? "); // 프로젝트 코드
			prj_code = Integer.parseInt(br.readLine());
			// 전체 작업 목록을 구현해야 구현 가능
		

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void updateRatio() {
		System.out.println("업무 구성비 수정");
	}

}
