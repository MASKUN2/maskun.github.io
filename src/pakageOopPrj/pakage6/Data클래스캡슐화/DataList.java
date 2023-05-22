package pakageOopPrj.pakage6.Data클래스캡슐화;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DataList {
	
	CompanyData[] list;
	private int index;
	private int Append;
	
	public DataList() {
		list = new CompanyData[1];
		Append = 1;
		
	}
	
	void outCal() {
		
	int in = index ;
	//per 계산
	for(int i=0; i<in; i++) {
		// 데이터 객체 CompanyData 에게 연산 위임
		list[i].calPer(); 
		
	}
	
	Arrays.sort(list, new Comparator<CompanyData>() {
	 @Override 
	 public int compare(CompanyData o1, CompanyData o2) { 
		 return(Double.compare(o1.getPer(), o2.getPer()) * -1); }
	  
	 });

	System.out.println("--------------------------");
	
	for(int i=0; i<in; i++) {
		System.out.printf("%d위) 기업명: %s  PER: %f %n"
				, i+1, list[i].getName(), list[i].getPer());
	}
	
	System.out.println("--------------------------\n");
	
}

	void inData() {
		Scanner sc = new Scanner(System.in);
		String name;
		int sharePrice, earning, numOuts;
		int in = index ;
		    
		if(list.length == index) {
			CompanyData[] temp = new CompanyData[list.length + Append];
			
			for(int i=0; i<list.length;i++) {
				temp[i] = list[i];
			}
			list = temp; 
			
		}		
		
		System.out.printf("%d 번째 기업의 이름을 입력해주세요 %n", in+1);
		name = sc.next();
		System.out.println("현재가를 입력해주세요");
		sharePrice = sc.nextInt();
		System.out.println("당기순이익을 입력해주세요");
		earning = sc.nextInt();
		System.out.println("유통주식수를 입력해주세요");
		numOuts = sc.nextInt();
		
		CompanyData company = new CompanyData(name, sharePrice, earning, numOuts);
		
		list[in] = company;
						
		index++;
		
	}
}