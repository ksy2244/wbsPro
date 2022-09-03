package com.plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.cat.CatUI;
import com.op.OpUI;
import com.project.ProjectDTO;
import com.project.ProjectUI;
import com.result.ResultUI;
import com.subject.SubjectUI;
import com.util.DBConn;

public class PlanUI {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int ch;
	ProjectUI projectUI = new ProjectUI();
	OpUI opUI = new OpUI();
	SubjectUI subjectUI = new SubjectUI();
	CatUI catUI = new CatUI();
	private PlanImpl plan = new PlanImpl();

	public void menu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		while (true) {

			try {
				System.out.print("1.작업 등록 2. 작업 수정 3.작업 삭제 4. 작업 검색 5. 전체 작업 목록 6.업무 구성비 7.뒤로가기 8.종료 => ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 8) {
					DBConn.close();
					System.exit(0);
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
					searchWork();
					break;
				case 5:
					workList();
					break;
				case 6:
					ResultUI ru = new ResultUI();
					ru.compositMenu();
					break;
				case 7:
					return;
				}

			} catch (Exception e) {
			}

		}

	}

	private void searchWork() throws NumberFormatException, SQLException, IOException {

		System.out.println("[작업 검색]");
		System.out.println("1. 사원 코드로 조회  2. 작업 코드로 조회 3. 작업 날짜로 조회 4.뒤로가기");
		ch = Integer.parseInt(br.readLine());

		if (ch == 4) {
			return;
		}

		switch (ch) {
		case 1:
			findByUserCode();
			break;
		case 2:
			findByWokrCode();
			break;
		case 3:
			findBydateCode();
			break;

		}
	}

	private void findByUserCode() throws SQLException, NumberFormatException, IOException {
		int userCode;
		System.out.println("[사원 코드로 담당자 작업 조회]");
		System.out.print("검색할 사원 코드 번호? ");
		// PlanDTO dto = new PlanDTO();
		userCode = Integer.parseInt(br.readLine());

		List<PlanDTO> list = plan.listWorkUser(userCode);

		System.out.println(list.size());
		if (list.size() == 0) {
			System.out.println("등록된 자료가 없습니다");
			return;
		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"      작    업       |          계     획          |        실         적      |    업 무    구 성 비  |   구 성  진 행  비 율 ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				" NO | CODE |   작업명   | 기간 |  계획 시작일 |  계획 종료일 |  담당자 | 진척율 |   시작일   |    종료일   | 진척율 | 업무 구성비 | 계획 | 실적 | 잔여일 ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");

		for (PlanDTO dto : list) {
			int n = 0;
			System.out.print("  " + (++n) + "   "); // no
			System.out.print(dto.getWorkCode() + "\t"); // 작업 코드 번호
			System.out.print(dto.getWorkName() + "\t"); // 작업명
			System.out.print(dto.getWorkTerm() + "\t"); // 기간
			System.out.print(dto.getWorkPlanStart() + "\t"); // 계획 시작일
			System.out.print(dto.getWorkPlanEnd() + "\t"); // 계획 종료일
			System.out.print(dto.getWorkUserName() + "\t"); // 담당자
			System.out.print(dto.getWorkPlanPer() + "%" + "\t"); // 계획 진척율
			System.out.print(dto.getWorkStart() + "\t"); // 시작일
			System.out.print(dto.getWorkEnd() + "\t"); // 종료일
			System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 진척율
			System.out.print(dto.getWorkComp() + "\t"); // 업무 구성비
			System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 계획 구성 진행 비율
			System.out.print(dto.getRatio() + "%" + "\t"); // 실적 구성 진행 비율
			System.out.println(dto.getRemain() + "\t"); // 잔여일

		}
		System.out.println();

	}

	private void findBydateCode() throws SQLException, SQLDataException, IOException {
		String startdate;
		String enddate;
		int code;

		System.out.println("작업날짜 조회]");
		try {
			System.out.print("검색할 프로젝트 코드 ?");

			code = Integer.parseInt(br.readLine());

			System.out.print("검색할 시작날짜 [yyyy-MM-dd]?");

			startdate = br.readLine();

			System.out.print("검색할 종료날짜 [yyyy-MM-dd]?");

			enddate = br.readLine();

			PlanImpl dao = new PlanImpl();

			ProjectDTO pdto = dao.projectbetweenDate(code);

			List<PlanDTO> list = plan.listdate(startdate, enddate);

			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"      작    업       |          계     획          |        실         적      |    업 무    구 성 비  |   구 성  진 행  비 율 ");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					" NO | CODE |   작업명   | 기간 |  계획 시작일 |  계획 종료일 |  담당자 | 진척율 |   시작일   |    종료일   | 진척율 | 업무 구성비 | 계획 | 실적 | 잔여일 ");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------");

			for (PlanDTO dto : list) {
				int n = 0;
				System.out.print("  " + (n++) + "   "); // no
				System.out.print(dto.getWorkCode() + "\t"); // 작업 코드 번호
				System.out.print(dto.getWorkName() + "\t"); // 작업명
				System.out.print(dto.getWorkTerm() + "\t"); // 기간
				System.out.print(dto.getWorkPlanStart() + "\t"); // 계획 시작일
				System.out.print(dto.getWorkPlanEnd() + "\t"); // 계획 종료일
				System.out.print(dto.getWorkUserName() + "\t"); // 담당자
				System.out.print(dto.getWorkPlanPer() + "%" + "\t"); // 계획 진척율
				System.out.print(dto.getWorkStart() + "\t"); // 시작일
				System.out.print(dto.getWorkEnd() + "\t"); // 종료일
				System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 진척율
				System.out.print(dto.getWorkComp() + "\t"); // 업무 구성비
				System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 계획 구성 진행 비율
				System.out.print(dto.getRatio() + "%" + "\t"); // 실적 구성 진행 비율
				System.out.println(dto.getRemain() + "\t"); // 잔여일

			}
			System.out.println();

			// }

			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void findByWokrCode() throws SQLException, NumberFormatException, IOException {
		int workCode;
		System.out.println("[작업 코드로 작업 조회]");
		System.out.print("검색할 작업 코드 번호? ");
		// PlanDTO dto = new PlanDTO();
		workCode = Integer.parseInt(br.readLine());

		List<PlanDTO> list = plan.listWorkCode(workCode);

		System.out.println(list.size());
		if (list.size() == 0) {
			System.out.println("등록된 자료가 없습니다");
			return;
		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"      작    업       |          계     획          |        실         적      |    업 무    구 성 비  |   구 성  진 행  비 율 ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				" NO | CODE |   작업명   | 기간 |  계획 시작일 |  계획 종료일 |  담당자 | 진척율 |   시작일   |    종료일   | 진척율 | 업무 구성비 | 계획 | 실적 | 잔여일 ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");

		for (PlanDTO dto : list) {
			int n = 0;
			System.out.print("  " + (++n) + "   "); // no
			System.out.print(dto.getWorkCode() + "\t"); // 작업 코드 번호
			System.out.print(dto.getWorkName() + "\t"); // 작업명
			System.out.print(dto.getWorkTerm() + "\t"); // 기간
			System.out.print(dto.getWorkPlanStart() + "\t"); // 계획 시작일
			System.out.print(dto.getWorkPlanEnd() + "\t"); // 계획 종료일
			System.out.print(dto.getWorkUserName() + "\t"); // 담당자
			System.out.print(dto.getWorkPlanPer() + "%" + "\t"); // 계획 진척율
			System.out.print(dto.getWorkStart() + "\t"); // 시작일
			System.out.print(dto.getWorkEnd() + "\t"); // 종료일
			System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 진척율
			System.out.print(dto.getWorkComp() + "\t"); // 업무 구성비
			System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 계획 구성 진행 비율
			System.out.print(dto.getRatio() + "%" + "\t"); // 실적 구성 진행 비율
			System.out.println(dto.getRemain() + "\t"); // 잔여일

		}
		System.out.println();

	}

	private void workList() throws SQLException, NumberFormatException, IOException {
		int prj_code;
		int n = 0;
		System.out.println("전체 리스트 조회");
		System.out.print("검색할 프로젝트 작업명? ");
		// PlanDTO dto = new PlanDTO();
		prj_code = Integer.parseInt(br.readLine());

		List<PlanDTO> list = plan.listAll(prj_code);

		System.out.println(list.size());
		if (list.size() == 0) {
			System.out.println("등록된 자료가 없습니다");
			return;
		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"      작    업       |          계     획          |        실         적      |    업 무    구 성 비  |   구 성  진 행  비 율 ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				" NO | CODE |   작업명   | 기간 |  계획 시작일 |  계획 종료일 |  담당자 | 진척율 |   시작일   |    종료일   | 진척율 | 업무 구성비 | 계획 | 실적 | 잔여일 ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------");

		for (PlanDTO dto : list) {
			System.out.print("  " + (++n) + "   "); // no
			System.out.print(dto.getWorkCode() + "\t"); // 작업 코드 번호
			System.out.print(dto.getWorkName() + "\t"); // 작업명
			System.out.print(dto.getWorkTerm() + "\t"); // 기간
			System.out.print(dto.getWorkPlanStart() + "\t"); // 계획 시작일
			System.out.print(dto.getWorkPlanEnd() + "\t"); // 계획 종료일
			System.out.print(dto.getWorkUserName() + "\t"); // 담당자
			System.out.print(dto.getWorkPlanPer() + "%" + "\t"); // 계획 진척율
			System.out.print(dto.getWorkStart() + "\t"); // 시작일
			System.out.print(dto.getWorkEnd() + "\t"); // 종료일
			System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 진척율
			System.out.print(dto.getWorkComp() + "\t"); // 업무 구성비
			System.out.print(dto.getWorkPRatio() + "%" + "\t"); // 계획 구성 진행 비율
			System.out.print(dto.getRatio() + "%" + "\t"); // 실적 구성 진행 비율
			System.out.println(dto.getRemain() + "\t"); // 잔여일

		}
		System.out.println();

	}

	private void insert() {
		System.out.println("[작업 등록]");
		ProjectUI projectUI = new ProjectUI(); // 프로젝
		SubjectUI subjectUI = new SubjectUI(); // 대분류
		CatUI catUI = new CatUI(); // 중분류
		OpUI opUI = new OpUI();

		while (true) {

			try {
				System.out.print("1. 프로젝트 등록 2. 대분류 등록 3. 중분류 등록 4. 소분류 등록  5. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					projectUI.addProject();
					break;
				case 2:
					subjectUI.addSubject();
					break;
				case 3:
					catUI.insertCatDate();
					break;
				case 4:
					opUI.addOpDate();
					break;
				case 5:
					return;

				}

			} catch (Exception e) {
			}
		}

	}

	private void update() {
		System.out.println("[작업 수정]");

		while (true) {

			try {
				System.out.print("1. 프로젝트 수정 2. 대분류 수정 3. 중분류 수정 4. 소분류 수정 5. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					projectUI.updateProject();
					break;
				case 2:
					subjectUI.updateSubject();
					break;
				case 3:
					catUI.updateCatDate();
					break;
				case 4:
					opUI.updateOpDate();
					break;
				case 5:
					return;
				}

			} catch (Exception e) {
			}
		}

	}

	private void delete() {

		while (true) {

			try {
				System.out.print("1. 프로젝트 삭제 2. 대분류 삭제 3. 중분류 삭제 4. 소분류 삭제  5. 뒤로가기 ");

				ch = Integer.parseInt(br.readLine());

				if (ch == 7) {
					DBConn.close();
					return;
				}

				switch (ch) {
				case 1:
					projectUI.deleteProject();
					break;
				case 2:
					subjectUI.deleteSubject();
					break;
				case 3:
					catUI.deleteCatDate();

					break;
				case 4:
					opUI.deleteOpDate();
					break;
				case 5:
					return;

				}

			} catch (Exception e) {

			}
		}

	}

}