package pakage9.추상화클래스.뼈대;


public abstract class AbsConsoleUi {

	
	
	//생성자
	public AbsConsoleUi() {
		
	}
		
	public abstract int getMenu();
	
	public abstract void inputData();
		
		
	

	public abstract void outputCal();
		

	public void exit() {
		System.out.println("잘 가셔요!");		
	}

	public void wrong() {
		System.out.println("Wrong input \n");		
	}
	
}
