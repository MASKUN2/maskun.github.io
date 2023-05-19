package pakage9.추상화클래스.뼈대;

public abstract class AbsComFData {
	private String ComName;
	private int fNum1, fNum2;
	private double ratio1;
	
	public AbsComFData() {
		this("null",0,0);
	}
	
	public AbsComFData(String ComName, int fNum1, int fNum2) {
		this.ComName = ComName;
		this.fNum1 = fNum1;
		this.fNum2 = fNum2;
		
	}

	  public abstract double CalRatio1();
	  

	public String getComName() {
		return ComName;
	}

	public void setComName(String comName) {
		this.ComName = comName;
	}

	public int getfNum1() {
		return fNum1;
	}

	public void setfNum1(int fNum1) {
		this.fNum1 = fNum1;
	}

	public int getfNum2() {
		return fNum2;
	}

	public void setfNum2(int fNum2) {
		this.fNum2 = fNum2;
	}

	public double getRatio1() {
		return ratio1;
	}

	public void setRatio1(double ratio1) {
		this.ratio1 = ratio1;
	}
	  
	  
}