package pakage001.collectionPkg;

public class CompanyData {
	String name;
	int revenue;
	int earning;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}

	public int getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}

	int netIncome;
	
	public CompanyData() {
		name = "기업";
		revenue = 0;
		earning = 0;
		netIncome = 0;
	}
	
}
