package com.cat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.subject.SubjectDAO;
import com.subject.SubjectDAOImpl;
import com.util.DBConn;

public class CatUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	CatDateDAO cdao = new CatDateDAOImpl();
	SubjectDAO pdao = new SubjectDAOImpl();

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
			dto.setCat_plan_start(br.readLine());
			
			System.out.print("중분류계획종료일"); // 중분류 명
			dto.setCat_plan_end(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	public void deleteCatDate() {
		System.out.println("\n 데이터 삭제!!!");
		
		String cat_date;
		
		try {
			System.out.println("삭제할 중분류일정코드 ?");
			cat_date = br.readLine();
			
			int result = cdao.deleteCatDate(cat_date);
			if(result == 0) {
				System.out.println("등록된 자료가 아닙니다.");
			}else {
				System.out.println("데이터를 삭제했습니다.");
			}
			
		} catch (Exception e) {
			System.out.println();
		}
		
	}
	
	public void searchCatDateCode() {
		
	}

	public void searchCatDateName() {
		System.out.println("\n 중분류 명 검색 !!! ");
		
		String cat_name;
		
		try {
			System.out.println("검색할 중분류 명 ? ");
			cat_name = br.readLine();
			List<CatDateDTO>list = cdao.searchCatDateName(cat_name);
			
			if(list.size() == 0) {
				System.out.println("등록된 자료가 없습니다.");
				return;
		}
		
			for(CatDateDTO dto : list) {
				System.out.print(dto.getSub_date_code()+"\t");
				System.out.print(dto.getCat_date()+"\t");
				System.out.print(dto.getCat_name()+"\t");
				System.out.print(dto.getUser_name()+"\t");		
				System.out.print(dto.getCat_plan_start()+"\t");
				System.out.print(dto.getCat_plan_end()+"\t");
				System.out.print(dto.getCat_plan_per()+"\t");
				System.out.print(dto.getCat_start()+"\t");
				System.out.print(dto.getCat_end()+"\t");
				System.out.print(dto.getCat_per()+"\t");
				System.out.println(dto.getCat_comp());
			}
		} catch (Exception e) {
			System.out.println("중분류 명 검색 실패 !!!");
		}
		
		System.out.println();
	}
	
	public void searchCatDateManager() {
		
	}
	
	public void searchCatDateDate() {
		
	}

	public void searchCatDateAll() {
		System.out.println("\n 전체 리스트 !!!");
		
		System.out.println("대분류일정코드\t중분류일정코드\t중분류\t중분류담당자\t중분류계획시작일\t중분류계획종료일\t중분류계획진척율\t중분류실적시작일\t중분류실적종료일\t중분류실적진척율\t업무구성비");
		System.out.println("------------------------------------------------------------");
		
		List<CatDateDTO>list = cdao.searchCatDateAll();
		for(CatDateDTO dto : list) {
			System.out.print(dto.getSub_date_code()+"\t");
			System.out.print(dto.getCat_date()+"\t");
			System.out.print(dto.getCat_name()+"\t");
			System.out.print(dto.getUser_name()+"\t");		
			System.out.print(dto.getCat_plan_start()+"\t");
			System.out.print(dto.getCat_plan_end()+"\t");
			System.out.print(dto.getCat_plan_per()+"\t");
			System.out.print(dto.getCat_start()+"\t");
			System.out.print(dto.getCat_end()+"\t");
			System.out.print(dto.getCat_per()+"\t");
			System.out.println(dto.getCat_comp());
		}
		System.out.println();
	}

	public void workCompInsertCatDate() {
		
	}
	
	public void workCompUpdateCatDate() {
		
	}

}