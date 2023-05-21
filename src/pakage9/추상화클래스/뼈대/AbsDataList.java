package pakage9.추상화클래스.뼈대;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbsDataList {
	//필드
	private AbsData[] list;
	private int index;
	private int Append;
	
	public AbsDataList() {
		//생성자 
		list = new AbsData[1]; // Aggregation Has A 차후 추가됨
		Append = 1;
		
	}

	// per 기준 내림차순 정렬
	private void sort() {
		Arrays.sort(list, new Comparator<AbsData>() {
		 @Override 
		 public int compare(AbsData o1, AbsData o2) { 
			 return(Double.compare(o1.getOutPut(), o2.getOutPut()) * -1); }
		  
		 
		 });
	
}

	private void add(AbsData add) {
		//객체배열 공간체크 후 확장
		// loop first : 1 == 0 pass, Next : 1 == 1, 2 == 2
 		int in = index ;
		if(list.length == index) {
			AbsData[] temp = new AbsData[list.length + Append];
			
			for(int i=0; i<list.length;i++) {
				temp[i] = list[i];
			}
			list = temp; 
			
		}		
		//기업정보 저장 및 인덱스 기록
		
		list[in] = add;
						
		index++;
		
	}

	public int getindex() {
		
		return index;
	}
	public AbsData[] getList() {
		sort();
		return list;
	}
	public void addData(AbsData add) {
		add(add);
	}
}