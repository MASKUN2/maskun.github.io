package pakage9.추상화클래스.뼈대;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbsDataList {
	//필드
	private AbsComFData[] list;
	private int index;
	private int Append;
	
	public AbsDataList() {
		//생성자 
		list = new AbsComFData[1]; // Aggregation Has A 차후 추가됨
		Append = 1;
		
	}

	public void preCal() {
	// 출력전 계산
	int in = index ;
	//per 계산
	for(int i=0; i<in; i++) {
		// 데이터 객체 CompanyData 에게 연산 위임
		
	}
	// per 기준 내림차순 정렬
	
	
	Arrays.sort(list, new Comparator<AbsComFData>() {
	 @Override 
	 public int compare(AbsComFData o1, AbsComFData o2) { 
		 return(Double.compare(o1.getRatio1(), o2.getRatio1()) * -1); }
	  
	 });

	
}

	public void addData(AbsComFData addData) {
		//객체배열 공간체크 후 확장
		// loop first : 1 == 0 pass, Next : 1 == 1, 2 == 2
 		int in = index ;
		if(list.length == index) {
			AbsComFData[] temp = new AbsComFData[list.length + Append];
			
			for(int i=0; i<list.length;i++) {
				temp[i] = list[i];
			}
			list = temp; 
			
		}		
		//기업정보 저장 및 인덱스 기록
		AbsComFData newFormData = defAddData();
		list[in] = defaddData;
						
		index++;
		
	}

	public int getindex() {
		
		return index;
	}
}