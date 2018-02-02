package carDBPrac.dao;

public class CarDetail {
	private int ciNum;
	private String ciName;
	private String ciMaker;
	private int ciPrice;
	private String ciColor;
	private int ciWidth;
	private int ciHeight;
	
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
	protected String getCiColor() {
		return ciColor;
	}
	protected void setCiColor(String ciColor) {
		this.ciColor = ciColor;
	}
	protected int getCiWidth() {
		return ciWidth;
	}
	protected void setCiWidth(int ciWidth) {
		this.ciWidth = ciWidth;
	}
	protected int getCiHeight() {
		return ciHeight;
	}
	protected void setCiHeight(int ciHeight) {
		this.ciHeight = ciHeight;
	}
	// getter()setter()는 protected 처리하고
	
	// toString() 메소드 오버라이드해서
	@Override
	public String toString() {
		return this.ciNum + "," 
				+ this.ciName + ","
				+ this.ciMaker + ","
				+ this.ciPrice + ","
				+ this.ciColor + ","
				+ this.ciWidth + ","
				+ this.ciHeight;
	}
	
	
	// CarDBPracMain.java에서 상세정보 console에 다 뿌리기
	
	
	
	
}
