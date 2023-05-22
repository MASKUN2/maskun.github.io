package pakage001.collectionPkg;

import java.util.ArrayList;

public class Program {
	
	public static void main(String arg1[]) {
		ArrayList<CompanyData> list = new ArrayList<>();
		CompanyData data = new CompanyData();
		list.add(data);
		
		System.out.println(list.listIterator().toString());
		
		for(CompanyData comapny : list) {
			System.out.println( comapny.getName());
		}
	}
	
}
