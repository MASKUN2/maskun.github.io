package pakageOopPrj.pakage6.Data클래스캡슐화;

import java.util.Scanner;

public class PerCalculator5 {
	
	
	public static void main(String[] args) {
		boolean LoopCheck = true;
		int Menu ;
		DataList data = new DataList();

		
		while (LoopCheck) {
			//메뉴선택
			Menu = selectMenu();
			
			switch (Menu) {
				case 1: {
					//값 입력
					data.inData();
					break;
				}
				
				case 2: {
					//결과 값 계산
					data.outCal();
					break;
				}
				case 3: {
					//종료
					System.out.println("잘 가셔요!");
					LoopCheck = false;
					break;
				}
		
				default: {
					System.out.println("Wrong input \n");
				}
		
			}
		}
	}
	

	static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("PER 계산기입니다. 번호를 입력하세요");
		System.out.println("1. 값 입력(기업명, 현재주가, 당기순이익, 유통주식수)");
		System.out.println("2. 계산결과 확인, 비교");
		System.out.println("3. 종료");
		int Menu = sc.nextInt();
		return Menu;
	}
}


