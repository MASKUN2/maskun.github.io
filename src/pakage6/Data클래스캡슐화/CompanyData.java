package pakage6.Data클래스캡슐화;

public class CompanyData {
	private String name;
	private int sharePrice, earning, numOuts;
	private double per;
	
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
