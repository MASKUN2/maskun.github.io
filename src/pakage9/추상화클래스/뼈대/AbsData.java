package pakage9.추상화클래스.뼈대;

public abstract class AbsData {
	private String name;
	private int num1, num2;
	private double outPut;
	
	public AbsData() {
		this("null",0,0);
	}
	
	public AbsData(String companyName, int fNum1, int fNum2) {
		this.name = companyName;
		this.num1 = fNum1;
		this.num2 = fNum2;
		
	}

	public void calOutput() {
		setOutPut(Cal());
	}

	protected abstract double Cal();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public double getOutPut() {
		return outPut;
	}

	private void setOutPut(double outPut) {
		this.outPut = outPut;
	}
}
