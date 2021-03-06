package carDBPrac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarInfoDAO {
	
	// 오라클 DBMS 접속에 필요한 정보들
	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String ORACLE_USER_ID = "system";
	private static final String ORACLE_USER_PW = "abcd";
	
	// 접속 및 쿼리 처리에 필요한 객체들 
	private Connection conn = null; // 
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 모든 자동차 정보를 조회한다.
	public ArrayList<CarInfo> getCarInfoList() throws Exception {
		// 결과 값(들)을 담을 ArrayList 준비
		ArrayList<CarInfo> list = new ArrayList<CarInfo>();
		
		try {
			// 0. DBMS의 접속정보를 얻어온다.
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER_ID, ORACLE_USER_PW);
			// 1. sql문을 String으로 준비
			String sql = "select i.ciNum, i.ciName, m.MNAMEKOR, i.CIPRICE, c.CNAMEKOR\r\n" + 
					"from carInfo i, carMakers m, colors c\r\n" + 
					"where i.CIMAKER = m.MNUM\r\n" + 
					"and i.CICOLOR = c.CNUM"; // 리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			// 3. 실행 결과를 ResultSet 객체에 담는다.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CarInfo cInfo = new CarInfo();
				cInfo.setCiNum(rs.getInt(1));
				cInfo.setCiName(rs.getString(2));
				cInfo.setmNameKor(rs.getString(3));
				cInfo.setCiPrice(rs.getInt(4));
				cInfo.setcNameKor(rs.getString(5));
				list.add(cInfo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		
		return list;
	}

	// DB에 접속하여 파라미터에 해당하는 번호의
	// CarInfo 테이블 정보를 CarDetail에 가져온다.
	public CarDetail getCarDetailInfo(int selectNum) throws Exception {
		
		CarDetail detail = new CarDetail();
		
		try {
			// 0. DBMS의 접속정보를 얻어온다.
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER_ID, ORACLE_USER_PW);
			// 1. sql문을 String으로 준비
			String sql = "select i.ciNum, \r\n" + 
					"		i.ciName, \r\n" + 
					"		m.mNameEng,\r\n" + 
					"		m.mNameKor,\r\n" + 
					"		i.ciPrice, \r\n" + 
					"		c.cnameEng,\r\n" + 
					"		c.cnameKOR,\r\n" + 
					"		c.cRGB,\r\n" + 
					"		i.ciWidth, \r\n" + 
					"		i.ciHeight\r\n" + 
					" from carInfo i, carMakers m, colors c\r\n" + 
					"where i.ciMaker = m.mNum\r\n" + 
					"and i.ciColor = c.cNum and i.ciNum = ?"; // 리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectNum); // 첫번째 물음표 쿼리에 대한 세팅값
			
			// 3. 실행 결과를 ResultSet 객체에 담는다.
			rs = pstmt.executeQuery();
			
			// 결과로 나온 데이터가 1건 있으면 if 구문 블록 실행
			if(rs.next()) {
				detail.setCiNum(rs.getInt(1));
				detail.setCiName(rs.getString(2));
				detail.setCiMakerEng(rs.getString(3));
				detail.setCiMakerKor(rs.getString(4));
				detail.setCiPrice(rs.getInt(5));
				detail.setCiColorNameEng(rs.getString(6));
				detail.setCiColorNameKor(rs.getString(7));
				detail.setCiColorNameRgb(rs.getString(8));
				detail.setCiWidth(rs.getInt(9));
				detail.setCiHeight(rs.getInt(10));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		
		return detail;
	}

	// 2번 입력 선택 시 
	public ArrayList<CarDetail> getCarInfoDetailList() throws Exception{
		// 결과 값(들)을 담을 ArrayList 준비
		ArrayList<CarDetail> list = new ArrayList<CarDetail>();
		
		try {
			// 0. DBMS의 접속정보를 얻어온다.
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER_ID, ORACLE_USER_PW);
			// 1. sql문을 String으로 준비
			String sql = "select * from carInfo"; // 리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			// 3. 실행 결과를 ResultSet 객체에 담는다.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CarDetail detail = new CarDetail();
				
				detail.setCiNum(rs.getInt(1));
				detail.setCiName(rs.getString(2));
				detail.setCiMakerEng(rs.getString(3));
				detail.setCiMakerKor(rs.getString(4));
				detail.setCiPrice(rs.getInt(5));
				detail.setCiColorNameEng(rs.getString(6));
				detail.setCiColorNameKor(rs.getString(7));
				detail.setCiColorNameRgb(rs.getString(8));
				detail.setCiWidth(rs.getInt(9));
				detail.setCiHeight(rs.getInt(10));

				list.add(detail);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
			
		}
		
		return list;
	}
	// 자동차 상세정보 DB INSERT
	public void insertCarDetail(CarDetail carDetailData) throws Exception{
		try {
			// 0. DBMS의 접속정보를 얻어온다.
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER_ID, ORACLE_USER_PW);
			// 1. sql문을 String으로 준비
			String sql = "insert into carInfo(ciNum,ciName,ciMaker,ciPrice,ciColor,ciWidth,ciHeight) \r\n" + 
					"values (seq_carInfo_ciNum.nextval,?,?,?,?,?,?)"; // 쿼리리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carDetailData.getCiName());
			pstmt.setInt(2, carDetailData.getCiMaker());
			pstmt.setInt(3, carDetailData.getCiPrice());
			pstmt.setInt(4, carDetailData.getCiColor());
			pstmt.setInt(5, carDetailData.getCiWidth());
			pstmt.setInt(6, carDetailData.getCiHeight());
			
			// 3. 실행 결과를 ResultSet 객체에 담는다.
			pstmt.executeUpdate();
			// insert, update, delete 
			// 관련 쿼리에 쓰이는 jdbc 메소드
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
		}
		
	}
	
	// 사용자가 선택한 번호에 해당하는 CarDetail 테이블의 row를 수정한다.
	public void updateCarDetail(CarDetail carDetailData, int selectNum) throws Exception {
		try {
			// 0. DBMS의 접속정보를 얻어온다.
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER_ID, ORACLE_USER_PW);
			// 1. sql문을 String으로 준비
			String sql = "update carInfo \r\n" + 
					"set ciname=?,cimaker=?,ciprice=?,cicolor=?,ciwidth=?,ciheight=? \r\n" + 
					"where ciNum = ?"; // 쿼리리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carDetailData.getCiName());
			pstmt.setInt(2, carDetailData.getCiMaker());
			pstmt.setInt(3, carDetailData.getCiPrice());
			pstmt.setInt(4, carDetailData.getCiColor());
			pstmt.setInt(5, carDetailData.getCiWidth());
			pstmt.setInt(6, carDetailData.getCiHeight());
			pstmt.setInt(7, selectNum);
			// 준비된 쿼리 (pstmt) 실행(executeUpdate())
			pstmt.executeUpdate();
			// executeUpdate() : insert, update, delete 관련 쿼리에 쓰이는 jdbc 메소드
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
		}
	}

	public void deleteCarDetail(int selectNum) throws Exception{
		try {
			// 0. DBMS의 접속정보를 얻어온다.
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER_ID, ORACLE_USER_PW);
			// 1. sql문을 String으로 준비
			String sql = "delete carInfo where ciNum = ?"; // 쿼리리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectNum);
			// 준비된 쿼리 (pstmt) 실행(executeUpdate())
			pstmt.executeUpdate();
			// executeUpdate() : insert, update, delete 관련 쿼리에 쓰이는 jdbc 메소드
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
		}
	}

}//class
