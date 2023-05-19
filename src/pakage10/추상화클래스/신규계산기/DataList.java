package pakage10.추상화클래스.신규계산기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DataList {
	//필드
	CompanyData[] list;
	private int index;
	private int Append;
	
	public DataList() {
		//생성자 
		list = new CompanyData[1]; // Aggregation Has A 차후 추가됨
		Append = 1;
		
	}
	
	public void preCal() {
	// 출력전 계산
	int in = index ;
	//per 계산
	for(int i=0; i<in; i++) {
		// 데이터 객체 CompanyData 에게 연산 위임
		list[i].calPer(); 
		
	}
	// per 기준 내림차순 정렬
	Arrays.sort(list, new Comparator<CompanyData>() {
	 @Override 
	 public int compare(CompanyData o1, CompanyData o2) { 
		 return(Double.compare(o1.getPer(), o2.getPer()) * -1); }
	  
	 });

	
}

	public void addData(CompanyData company) {
		//객체배열 공간체크 후 확장
		// loop first : 1 == 0 pass, Next : 1 == 1, 2 == 2
 		int in = index ;
		if(list.length == index) {
			CompanyData[] temp = new CompanyData[list.length + Append];
			
			for(int i=0; i<list.length;i++) {
				temp[i] = list[i];
			}
			list = temp; 
			
		}		
		//기업정보 저장 및 인덱스 기록
		list[in] = company;
						
		index++;
		
	}

	public int getindex() {
		
		return index;
	}
}