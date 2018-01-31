package carDBPrac.main;

import java.util.ArrayList;
import java.util.Scanner;

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
