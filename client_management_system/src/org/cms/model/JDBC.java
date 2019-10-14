package org.cms.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
public static Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";	//외워서 쳐야하는 부분
		String user = "comstudy21";
		String password = "comstudy21";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//ojdbc6.jar에서 oracle.jdbc.driver를 copy qaulified name으로 복사해서 붙여 넣는다.
			conn = DriverManager.getConnection(url, user, password);	//외워야할 부분
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 검색 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn){	//conn을 닫는 기능
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt){	//stmt을 닫는 기능
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs){	//rs을 닫는 기능
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs){	//conn을 닫는 기능
		close(rs);
		close(stmt);
		close(conn);
	}
}

