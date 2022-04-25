package com.pcwk.cmn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SawonDao implements WorkDiv<SawonVO> {
	
	private Connection connection;	// DB연결 정보
	
	public SawonDao() {
		connect();
	}
	
	public void connect() {
		String dbURL = "jdbc:oracle:thin:@db202203171133_high?TNS_ADMIN=/Users/baghun/Desktop/DCOM_20220127/02_DB/doc/Wallet_DB202203171133"; // URL
		String dbUSER = "admin";	// ID
		String dbPASS = "Hun3398480@!";	// 비번
		
		try {
			// jdbc oracle driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB 연결
			connection = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
			System.out.println("Connection: " + connection);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	// 목록조회
	@Override
	public List<SawonVO> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	// INSERT
	@Override
	public int doSave(SawonVO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// DELETE
	@Override
	public int doDelete(SawonVO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 단건 조회
	@Override
	public SawonVO doSelectOne(SawonVO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	// update
	@Override
	public int doUpdate(SawonVO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
