package carDBPrac.main;

import java.util.ArrayList;
import java.util.Scanner;

import carDBPrac.dao.CarDetail;
import carDBPrac.dao.CarInfo;
import carDBPrac.dao.CarInfoDAO;

public class CarDBPracMain {
	public static void main(String[] args) throws Exception {
		// 메뉴의 번호를 입력받아 지정한 번호 이외 다른 번호를 입력하면
		// "잘못 입력하셨습니다" 출력 후 다시 입력 받게 함
		Scanner sc = new Scanner(System.in);
		CarInfoDAO dao = new CarInfoDAO();
		while(true) {
			System.out.println("======================");
			System.out.println("번호를 입력하세요");
			System.out.println("1. 자동차 정보 보기");
			System.out.println("2. 자동차 정보 입력");
			System.out.println("3. 자동차 정보 수정");
			System.out.println("4. 자동차 정보 삭제");
			System.out.println("======================");
			int inputNum = sc.nextInt();
			
			if(inputNum == 1) { // 자동차 정보 조회
				ArrayList<CarInfo> list = dao.getCarInfoList();
				
				// 조회한 데이터 뿌리기
				for (int i = 0; i < list.size(); i++) {
					CarInfo ci = list.get(i);
					System.out.println(ci.toString());
				}
				// 자동차 상세 정보 보기 
				// 상세보기 할 번호가 없으면 잘못 입력하셨습니다
				// 0번을 입력하면 종료
				while(true) {
					System.out.println("상세 보기 할 번호를 입력하세요(0번:종료)");
					int selectNum = sc.nextInt();
					boolean isCorrect = false; // 사용자가 입력한 값이 DB ciNum List에
											   // 포함되면 true로 돌릴려고
					for (int i = 0; i < list.size(); i++) {
						// 사용자가 선택한 번호가 list의 ciNum과 일치 할 경우
						if(selectNum == list.get(i).getCiNum()) {
							// TODO: 해당 번호의 자동차 상세 정보 보기
							System.out.println("제대로 잘 입력했네요");
							System.out.println("입력한 번호 : " + selectNum);
							/* 자동차의 상세 정보를 보여준다. */
							CarDetail cd = dao.getCarDetailInfo(selectNum);
							System.out.println(selectNum+"data 상세정보");
							System.out.println(cd.toString());
							
							isCorrect = true;
							break;
						}
					}
					
					// 종료코드:0
					if(selectNum == 0) {
						System.out.println("종료 하겠습니다.");
						break;
					}
					
					if(isCorrect == false) {
						System.out.println("잘못 입력하셨습니다.");
					}
					
				}
				
				break;
			} else if(inputNum == 2) { // 자동차 정보 입력

				break;
			} else if(inputNum == 3) { // 자동차 정보 수정
				
				break;
			} else if(inputNum == 4) { // 자동차 정보 삭제
				
				break;
			} else { // 다른 번호 입력했을 때
				System.out.println("다시 입력 해 주세요");
			}
		}
		System.out.println("종료");
		
		sc.close();
		
		
		
		
	}
}
