package pakage5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DataList {
	CompanyData[] list;
	int index;
	int Append = 1;

	void outCal() {
	int in = this.index ;
	CompanyData[] list = this.list ;
	
	//per 계산
	for(int i=0; i<in; i++) {

		int price = list[i].sharePrice;
		int earning = list[i].earning;
		int numOuts = list[i].numOuts;
		list[i].per =  price/(earning /(double) numOuts);
		
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


	void inData() {
		
		Scanner sc = new Scanner(System.in);
		
		int in = this.index ;
		CompanyData company = new CompanyData();
		    
		if(this.list.length == this.index) {
			CompanyData[] temp = new CompanyData[this.list.length + this.Append];
			
			for(int i=0; i<this.list.length;i++) {
				temp[i] = this.list[i];
			}
			this.list = temp; 
			
		}
		
	
		System.out.printf("%d 번째 기업의 이름을 입력해주세요 %n", in+1);
		company.name = sc.next();
		System.out.println("현재가를 입력해주세요");
		company.sharePrice = sc.nextInt();
		System.out.println("당기순이익을 입력해주세요");
		company.earning = sc.nextInt();
		System.out.println("유통주식수를 입력해주세요");
		company.numOuts = sc.nextInt();
		
		this.list[in] = company;
		
		
		
		
		
		this.index++;
		
		
	
		
	}
}