package carDBPrac.dao;

public class CarDetail {
	private int ciNum;
	private String ciName;
	private int ciMaker;
	private String ciMakerEng;
	private String ciMakerKor;
	private int ciPrice;
	private int ciColor;
	private String ciColorNameKor;
	private String ciColorNameEng;
	private String ciColorNameRgb;
	private int ciWidth;
	private int ciHeight;
	
	public CarDetail() {} // CarDetail 인스턴스 호출용, 그러니까 CarDetail cd = new CarDetail(); 이렇게 쓸려고
	
	// select 할 때 상세 정보를 보기 위해서 사용하는 생성자
	public CarDetail(String cName, String ciMakerEng, 
			String ciMakerKor, int cPrice, 
			String ciColorNameKor, String ciColorNameEng, String ciColorNameRgb,
			int cWidth, int cHeight) {
		this.ciName = cName;
		this.ciMakerEng = ciMakerEng;
		this.ciMakerKor = ciMakerKor;
		this.ciPrice = cPrice;
		this.ciColorNameKor = ciColorNameKor;
		this.ciColorNameEng = ciColorNameEng;
		this.ciColorNameRgb = ciColorNameRgb;
		this.ciWidth = cWidth;
		this.ciHeight = cHeight;
	}
	
	// carInfo 테이블에 입력 받을 때 쓰는 생성자 
	public CarDetail(String cName, int cMaker, int cPrice, int cColor, int cWidth, int cHeight) {
		this.ciName = cName;
		this.ciMaker = cMaker;
		this.ciPrice = cPrice;
		this.ciColor = cColor;
		this.ciWidth = cWidth;
		this.ciHeight = cHeight;
	}
	
	protected int getCiMaker() {
		return ciMaker;
	}
	protected void setCiMaker(int ciMaker) {
		this.ciMaker = ciMaker;
	}
	protected int getCiColor() {
		return ciColor;
	}
	protected void setCiColor(int ciColor) {
		this.ciColor = ciColor;
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
	protected String getCiMakerEng() {
		return ciMakerEng;
	}
	protected void setCiMakerEng(String ciMakerEng) {
		this.ciMakerEng = ciMakerEng;
	}
	protected String getCiMakerKor() {
		return ciMakerKor;
	}
	protected void setCiMakerKor(String ciMakerKor) {
		this.ciMakerKor = ciMakerKor;
	}
	protected int getCiPrice() {
		return ciPrice;
	}
	protected void setCiPrice(int ciPrice) {
		this.ciPrice = ciPrice;
	}
	protected String getCiColorNameKor() {
		return ciColorNameKor;
	}
	protected void setCiColorNameKor(String ciColorNameKor) {
		this.ciColorNameKor = ciColorNameKor;
	}
	protected String getCiColorNameEng() {
		return ciColorNameEng;
	}
	protected void setCiColorNameEng(String ciColorNameEng) {
		this.ciColorNameEng = ciColorNameEng;
	}
	protected String getCiColorNameRgb() {
		return ciColorNameRgb;
	}
	protected void setCiColorNameRgb(String ciColorNameRgb) {
		this.ciColorNameRgb = ciColorNameRgb;
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
	// toString() 메소드 오버라이드해서
	@Override
	public String toString() {
		return this.ciNum + "," 
				+ this.ciName + ","
				+ this.ciMakerEng + ","
				+ this.ciMakerKor + ","
				+ this.ciPrice + ","
				+ this.ciColorNameEng + ","
				+ this.ciColorNameKor + ","
				+ this.ciColorNameRgb + ","
				+ this.ciWidth + ","
				+ this.ciHeight;
	}
	
	
	// CarDBPracMain.java에서 상세정보 console에 다 뿌리기
	
	
	
	
}
