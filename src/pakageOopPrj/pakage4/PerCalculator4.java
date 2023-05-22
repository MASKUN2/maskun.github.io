package pakageOopPrj.pakage4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PerCalculator4 {
	
	
	public static void main(String[] args) {
		boolean LoopCheck = true;
		int Menu ;
		DataList data = new DataList();
		data.list = new CompanyData[1];
		
		while (LoopCheck) {
			//메뉴선택
			Menu = selectMenu();
			
			switch (Menu) {
			case 1: {
				//값 입력
				inData(data);
				
				break;
			}
			
			case 2: {
				//결과 값 계산
				outCal(data);								
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
	
	private static void outCal(DataList data) {
		int in = data.index ;
		CompanyData[] list = data.list ;
		
		//per 계산
		for(int i=0; i<in; i++) {

			int price = list[i].sharePrice;
			int earning = list[i].earning;
			int numOuts = list[i].numOuts;
			list[i].per = (double) price/(earning / numOuts);
			
		}
		
		

		
		Arrays.sort(list, new Comparator<CompanyData>() {
		  
		 @Override 
		 public int compare(CompanyData o1, CompanyData o2) { 
			 return(Double.compare(o1.per, o2.per) * -1); }
		  
		 });
		 
		
		System.out.println("--------------------------");
		
		for(int i=0; i<in; i++) {
			System.out.printf("%d위) 기업명: %s  PER: %f %n"
					, i+1, list[i].name, list[i].per);
		}
		
		System.out.println("--------------------------\n");
		
		
	}

	private static void inData(DataList data) {
		
		Scanner sc = new Scanner(System.in);
		
		int in = data.index ;
		CompanyData company = new CompanyData();
		CompanyData[] list = data.list ;
		    
		if(data.list.length == data.index) {
			CompanyData[] temp = new CompanyData[data.list.length + data.Append];
			
			for(int i=0; i<data.list.length;i++) {
				temp[i] = data.list[i];
			}
			data.list = temp;
			
		}
		

		System.out.printf("%d 번째 기업의 이름을 입력해주세요 %n", in+1);
		company.name = sc.next();
		System.out.println("현재가를 입력해주세요");
		company.sharePrice = sc.nextInt();
		System.out.println("당기순이익을 입력해주세요");
		company.earning = sc.nextInt();
		System.out.println("유통주식수를 입력해주세요");
		company.numOuts = sc.nextInt();
		
		data.list[in] = company;
		
		
		
		
		
		data.index++;
		
		

		
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


