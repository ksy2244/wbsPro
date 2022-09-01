package com.oc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OcUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	OcDAO dao = new OcDAOImpl();
	int ch;
	
	public void menu()  {

		while (true) {
			try {
				
				System.out.println();
				System.out.println("-------------------------------------------------------");
				System.out.println("1.발주업체 등록 2. 업체정보 수정 3.업체정보삭제 4. 업체 조회 5.뒤로가기 ");
				System.out.println("-------------------------------------------------------");

				
				ch = Integer.parseInt(br.readLine());

				if (ch == 5) {
					return;
				}

				switch (ch) {
				case 1:
					insertOc();
					break;
				case 2:
					updateOc();
					break;
				case 3:
					deleteOc();
					break;
				case 4:
					searchOc();
					break;
				case 5:
					return;
				}

			} catch (NumberFormatException e) {
			} catch (IOException e) {
			}

		}

	}

	

	public void insertOc() { // 업체 등록
		System.out.println("\t[ 발주업체 등록 ] ");

		try {
			OcDTO dto = new OcDTO();

			System.out.println(" 업체 이름을 입력하세요. ");
			dto.setOc_name(br.readLine());

			System.out.println(" 업체 코드를 입력하세요. ");
			dto.setOc_code(Integer.parseInt(br.readLine()));

			System.out.println(" 업체 전화번호를 입력하세요. ");
			dto.setOc_tel(br.readLine());
			
			dao.insertOc(dto);
				
			System.out.println("-------------------------------------------------------");
			System.out.println(" \t\t발주업체 정보가 등록되었습니다 !\t\t ");
			System.out.println("-------------------------------------------------------");

		} catch (Exception e) {
			System.out.println(" [ 업체 정보 등록 실패 ] ");
		} 

	}

	
	
	
	public void updateOc() { // 코드 입력 받아서 업체 정보 수정 
		System.out.println(" \t [ 업체 정보 수정 ] ");
		
		
		try {
			OcDTO dto = new OcDTO();
			int code =0;
			System.out.println("정보 수정을 원하는 업체의 코드를 입력해주세요");
			 code = Integer.parseInt(br.readLine());
		     dto.setOc_code(code);
		
			System.out.println(" 업체의 이름을 입력하세요. ");
			dto.setOc_name(br.readLine());
	
			
			System.out.println(" 업체의 전화번호를 입력하세요.");
			dto.setOc_tel(br.readLine());
			
			int result = dao.updateOc(dto);
			
			if(result != 0) {
				System.out.println(" 수정이 완료되었습니다. ");
			} else {
				System.out.println(" 존재하지 않는 업체입니다. ");
				return; 
			}
			
			
		} catch (Exception e) {
			System.out.println("[업체 등록 오류]");
		}
		
	}
		

	public void deleteOc() { // 코드 입력해서 업체 삭제
		System.out.println(" \t[ 업체 정보 삭제 ] \t ");

		try {
			System.out.println(" 정보를 삭제 할 업체의 코드를 입력해주세요. ");
			int result = dao.deleteOc(Integer.parseInt(br.readLine()));
			
			if (result != 0) {
				System.out.println(" 업체 정보가 삭제되었습니다.");
				return;
			}
			
			System.out.println("등록된 업체가 존재하지 않습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void searchOc () { // 업체검색 하위 메뉴
			while(true) {
				
				System.out.println(" 1. 업체이름 조회 2.업체 코드조회 3.전체 업체 조회 4.뒤로가기  ");
				
				int ch; 
				
				try {
					
					ch=Integer.parseInt(br.readLine());
					
					switch (ch) {
					case 1: findByName();
						break;
					case 2: findBycode();
						break;
					case 3: ListOc();
						break;
					case 4:
						return;
					}
					
				} catch (Exception e) {
				}
			}
		
	}
	
	
	public void findByName() { // 업체 이름 조회
		System.out.println(" [업체 이름 조회 ] ");

		try {
			
			System.out.println(" 조회할 업체의 이름을 입력하세요. ");
			List<OcDTO> list = dao.searchOcName(br.readLine());
			
			if (list.size() == 0) {
				System.out.println(" 등록된 업체 정보가 존재하지 않습니다. ");
				return;
			} else {
			
			System.out.println(" 업체명\t업체코드\t업체전화번호 ");
			System.out.println("---------------------------------------");

			for (OcDTO dto : list) {
				System.out.println(dto.getOc_name() + "\t");
				System.out.println(dto.getOc_code() + "\t");
				System.out.println(dto.getOc_tel() + "\t");
				
				System.out.println();
			}
			
			System.out.println();
		}
		} catch (Exception e) {
			System.out.println("업체 조회가 실패하였습니다.");
		}

	}

	public void findBycode() { // 업체 코드 조회
		System.out.println(" [업체 코드 조회 ] ");

		try {
			System.out.println(" 조회할 업체의 코드를 입력하세요. ");
			List<OcDTO> list = dao.searchOcCode(Integer.parseInt(br.readLine()));

			if (list.size() == 0) {
				System.out.println(" 등록된 업체 정보가 존재하지 않습니다. ");
			} else {

				System.out.println(" 업체명\t업체코드\t업체전화번호 ");
				System.out.println("---------------------------------------");

				for (OcDTO dto : list) {
					System.out.print(dto.getOc_name() + "\t");
					System.out.print(dto.getOc_code() + "\t");
					System.out.print(dto.getOc_tel() + "\t");
					System.out.println();
				}

				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	public void ListOc() { // 모든 업체 조회
		System.out.println(" [ 전체 업체 목록 조회 ] ");

		try {

			List<OcDTO> list = dao.ListOc();

			if (list == null) {
				System.out.println(" 등록된 업체 정보가 존재하지 않습니다. ");
			}

			System.out.println(" 업체명\t\t업체코드\t\t업체전화번호 ");
			System.out.println("---------------------------------------");

			for (OcDTO dto : list) {
				System.out.print(dto.getOc_name()+"\t\t");
				System.out.print(dto.getOc_code()+"\t\t");
				System.out.print(dto.getOc_tel()+"\t\t");
				System.out.println();
			}

			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

