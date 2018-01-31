package carDBPrac.dao;

public class CarInfo {
	private int ciNum;
	private String ciName;
	private String ciMaker;
	private int ciPrice;
	
	protected int getCiNum() {
		return ciNum;
	}
	protected void setCiNum(int ciNum) {
		this.ciNum = ciNum;
	}
	protected String getCiName() {
		return ciName;
	}
	protected void setCiName(String ciName) {
		this.ciName = ciName;
	}
	protected String getCiMaker() {
		return ciMaker;
	}
	protected void setCiMaker(String ciMaker) {
		this.ciMaker = ciMaker;
	}
	protected int getCiPrice() {
		return ciPrice;
	}
	protected void setCiPrice(int ciPrice) {
		this.ciPrice = ciPrice;
	}
	
	
	@Override
	public String toString() {
		return this.ciNum +","+ this.ciName +","+ this.ciMaker +","+ this.ciPrice;
	}
	
	
	
	
}
