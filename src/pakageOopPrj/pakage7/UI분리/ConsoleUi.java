package pakageOopPrj.pakage7.UI분리;

import java.util.Scanner;

public class ConsoleUi {

	private DataList data;
	// Composition Has A 일체형
	//생성자
	public ConsoleUi() {
		data = new DataList();
	}

	public int getMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("PER 계산기입니다. 번호를 입력하세요");
		System.out.println("1. 값 입력(기업명, 현재주가, 당기순이익, 유통주식수)");
		System.out.println("2. 계산결과 확인, 비교");
		System.out.println("3. 종료");
		int Menu = sc.nextInt();
		return Menu;
		
	}
	
	public void inputData() {
		
		Scanner sc = new Scanner(System.in);
		String name;
		int sharePrice, earning, numOuts;
		int in = data.getindex();
		
		System.out.printf("%d 번째 기업의 이름을 입력해주세요 %n", in+1);
		name = sc.next();
		System.out.println("현재가를 입력해주세요");
		sharePrice = sc.nextInt();
		System.out.println("당기순이익을 입력해주세요");
		earning = sc.nextInt();
		System.out.println("유통주식수를 입력해주세요");
		numOuts = sc.nextInt();
		
		CompanyData company = new CompanyData(name, sharePrice, earning, numOuts);
		
		data.addData(company);
		
		
	}

	public void outputCal() {
		
		data.preCal();
		
		int in = data.getindex();
		CompanyData[] list = data.list ; 
		
		System.out.println("--------------------------");
		
		for(int i=0; i<in; i++) {
			System.out.printf("%d위) 기업명: %s  PER: %f %n"
					, i+1, list[i].getName(), list[i].getPer());
		}
		
		System.out.println("--------------------------\n");
		
	}

	public void exit() {
		System.out.println("잘 가셔요!");		
	}

	public void wrong() {
		System.out.println("Wrong input \n");		
	}
	
}
