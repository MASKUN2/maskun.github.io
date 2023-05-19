package pakage9.추상화클래스.뼈대;

public class CompanyData {
	private String name;
	private int sharePrice, earning, numOuts;
	private double per;
	
	public CompanyData() {
		this("null",0,0,0);
	}
	
	public CompanyData(String name2, int sharePrice2, int earning2, int numOuts2) {
		this.name = name2;
		this.sharePrice = sharePrice2;
		this.earning = earning2;
		this.numOuts = numOuts2;
	}

	
	  public void calPer() { 
		  per = sharePrice/(earning /(double) numOuts);
	 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}
	public int getEarning() {
		return earning;
	}
	public void setEarning(int earning) {
		this.earning = earning;
	}
	public int getNumOuts() {
		return numOuts;
	}
	public void setNumOuts(int numOuts) {
		this.numOuts = numOuts;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	
}
