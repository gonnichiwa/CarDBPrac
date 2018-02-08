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
		Scanner sc = new Scanner(System.in); // 숫자 데이터 받는 scanner
		Scanner scStr = new Scanner(System.in); // 문자 데이터 받는 scanner
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
				/* 자동차 상세정보 조회 그대로 구현 */
				ArrayList<CarDetail> list = dao.getCarInfoDetailList();
				
				for (int i = 0; i < list.size(); i++) {
					CarDetail cd = list.get(i);
					System.out.println(cd.toString());
				}
				
				System.out.println("(1:새data입력)(0:종료)");
				int selectNum = sc.nextInt();
				if(selectNum == 1) {
					// 사용자가 입력 받는 데이터들..
					System.out.println("차명을 입력하세요:"); String cName = scStr.nextLine();
					System.out.println("제조사를 입력하세요:"); int cMaker = scStr.nextInt();
					System.out.println("가격을 입력하세요:"); int cPrice = sc.nextInt();
					System.out.println("색상을 입력하세요:"); int cColor = scStr.nextInt();
					System.out.println("폭을 입력하세요:"); int cWidth = sc.nextInt();
					System.out.println("길이를 입력하세요:"); int cHeight = sc.nextInt(); 
					CarDetail carDetailData = 
							new CarDetail(cName,cMaker,cPrice,cColor,cWidth,cHeight);
					// db에 접근해서 사용자가 입력받은 데이터 INSERT 시키기
					dao.insertCarDetail(carDetailData);
					System.out.println("입력완료");
				}
				break;
			} else if(inputNum == 3) { // 자동차 정보 수정
				/* 자동차 상세 정보 다 불러와서 뿌리기 */
				// db에 접속해서 데이터들 다 가져오기
				ArrayList<CarDetail> list = dao.getCarInfoDetailList();
				// 가져온 데이터 다 콘솔로 뿌리기
				for (int i = 0; i < list.size(); i++) {
					CarDetail cd = list.get(i);
					System.out.println(cd.toString());
				}
				System.out.println("(선택번호 : 해당 내용 수정)(0:종료)");
				int selectNum = sc.nextInt(); // 사용자가 선택번호를 입력
				if(isValidNum(selectNum,list)) {
					// 사용자가 입력 받는 데이터들..
					System.out.println("차명을 입력하세요:"); String cName = scStr.nextLine();
					System.out.println("제조사를 입력하세요:"); int cMaker = scStr.nextInt();
					System.out.println("가격을 입력하세요:"); int cPrice = sc.nextInt();
					System.out.println("색상을 입력하세요:"); int cColor = scStr.nextInt();
					System.out.println("폭을 입력하세요:"); int cWidth = sc.nextInt();
					System.out.println("길이를 입력하세요:"); int cHeight = sc.nextInt(); 
					CarDetail carDetailData = 
							new CarDetail(cName,cMaker,cPrice,cColor,cWidth,cHeight);
					// db에 접근해서 사용자가 입력받은 데이터 INSERT 시키기
					dao.updateCarDetail(carDetailData,selectNum);// insert가 아니라 update시켜주면 됨
					System.out.println("수정완료");
				} else {
					System.out.println("해당 번호 없음. 종료합니다.");
				}
				break;
			} else if(inputNum == 4) { // 자동차 정보 삭제
				/* *** 모든 자동차 상세정보 불러와서 콘솔에 뿌리기 *** */
				/* 자동차 상세 정보 다 불러와서 뿌리기 */
				// db에 접속해서 데이터들 다 가져오기
				ArrayList<CarDetail> list = dao.getCarInfoDetailList();
				// 가져온 데이터 다 콘솔로 뿌리기
				for (int i = 0; i < list.size(); i++) {
					CarDetail cd = list.get(i);
					System.out.println(cd.toString());
				}
				System.out.println("(선택번호:해당 내용 삭제)(0:종료)");
				int selectNum = sc.nextInt(); // 사용자가 선택번호를 입력
				if(isValidNum(selectNum,list)) {
					dao.deleteCarDetail(selectNum);// insert가 아니라 delete시켜주면 됨
					System.out.println("삭제완료");
				} else {
					System.out.println("해당 번호 없음. 종료합니다.");
				}
				break;
			} else { // 다른 번호 입력했을 때
				System.out.println("다시 입력 해 주세요");
			}
		}
		System.out.println("종료");
		
		sc.close();
		
		
		
		
	}

	// db(CarDetail 테이블)에 접근해서 사용자가 입력한 번호가 일치하는 지 검사
	private static boolean isValidNum(int selectNum, ArrayList<CarDetail> list) {
		// 리스트의 getCiNum의 번호와 사용자가 입력한 번호(selectNum)이
		// 같은 경우에는 true
		for (int i = 0; i < list.size(); i++) {
			if(selectNum == list.get(i).getCiNum()) {
				return true;
			}
		}
		return false;
	}
}
