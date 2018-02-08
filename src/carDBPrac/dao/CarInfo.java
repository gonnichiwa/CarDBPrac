package carDBPrac.dao;

public class CarInfo {
	private int ciNum;
	private String ciName;
	private String mNameKor;
	private String ciMaker;
	private String cNameKor;
	private int ciPrice;
	
	protected String getmNameKor() {
		return mNameKor;
	}
	protected void setmNameKor(String mNameKor) {
		this.mNameKor = mNameKor;
	}
	
	protected String getcNameKor() {
		return cNameKor;
	}
	protected void setcNameKor(String cNameKor) {
		this.cNameKor = cNameKor;
	}
	public int getCiNum() {
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
		return this.ciNum +","
				+ this.ciName +","
				+ this.mNameKor +","
				+ this.ciPrice +","
				+ this.cNameKor;
	}
	
	
	
	
}
