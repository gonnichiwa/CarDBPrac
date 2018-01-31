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
			String sql = "select * from carInfo"; // 리터럴에 ; 들어가면 안된다.
			// 2. 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			// 3. 실행 결과를 ResultSet 객체에 담는다.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CarInfo cInfo = new CarInfo();
				cInfo.setCiNum(rs.getInt(1));
				cInfo.setCiName(rs.getString(2));
				cInfo.setCiMaker(rs.getString(3));
				cInfo.setCiPrice(rs.getInt(4));
				
				list.add(cInfo);
			}
		} catch(Exception e) {
			
		} finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
