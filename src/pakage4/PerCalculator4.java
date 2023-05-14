package pakage4;

import java.util.Arrays;
import java.util.Comparator;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PerCalculator4 {
	
	
	public static void main(String[] args) {
		boolean LoopCheck = true;
		int Menu ;
		CompanyData[] savedData = new CompanyData[4];
		savedData[0] = new CompanyData();
		savedData[1] = new CompanyData();
		savedData[2] = new CompanyData();
		savedData[3] = new CompanyData();
		
		while (LoopCheck) {
			//메뉴선택
			Menu = selectMenu();
			
			switch (Menu) {
			case 1: {
				//값 입력
				savedData = inData();
				
//				for(int i=0 ; i<3 ; i++) {
//				System.out.println(savedData[i].name);
//				System.out.println(savedData[i].earning);
//				System.out.println(savedData[i].numOuts);
//				System.out.println(savedData[i].sharePrice);
//				}
				break;
			}
			
			case 2: {
				//결과 값 계산
				outCal(savedData);								
				break;
			}
			case 3: {
				//종료
				System.out.println("잘 가셔요!");
				LoopCheck = false;
			}
	
			default: {
				System.out.println("Wrong input \n");
			}
				
			
		
		
			}
		}
	}
	
	private static void outCal(CompanyData[] savedData) {

		
		//per 계산
		for(int i=0; i<3; i++) {

			int price = savedData[i].sharePrice;
			int earning = savedData[i].earning;
			int numOuts = savedData[i].numOuts;
			savedData[i].per = (double) price/(earning / numOuts);
			
			
		}
		//비교 후 출력
		Arrays.sort(savedData, new Comparator<CompanyData>() {

			@Override
			public int compare(CompanyData o1, CompanyData o2) {
				return (Double.compare(o1.per, o2.per) * -1);
			}
			
		});
		
		System.out.println("--------------------------");
		
		for(int i=0; i<3; i++) {
			System.out.printf("%d위) 기업명: %s  PER: %f %n"
					, i+1, savedData[i].name, savedData[i].per);
		}
		
		System.out.println("--------------------------\n");
		
		
	}

	private static CompanyData[] inData() {
		CompanyData[] savedData = new CompanyData[3];
		savedData[0] = new CompanyData();
		savedData[1] = new CompanyData();
		savedData[2] = new CompanyData();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3 ; i++) {
			System.out.printf("%d 번째 기업의 이름을 입력해주세요 %n", i+1);
			savedData[i].name = sc.next();
			System.out.println("현재가를 입력해주세요");
			savedData[i].sharePrice = sc.nextInt();
			System.out.println("당기순이익을 입력해주세요");
			savedData[i].earning = sc.nextInt();
			System.out.println("유통주식수를 입력해주세요");
			savedData[i].numOuts = sc.nextInt();
		}
		return savedData;
		

		
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


