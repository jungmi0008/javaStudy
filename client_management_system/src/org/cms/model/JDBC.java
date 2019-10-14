package org.cms.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
public static Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";	//�ܿ��� �ľ��ϴ� �κ�
		String user = "comstudy21";
		String password = "comstudy21";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//ojdbc6.jar���� oracle.jdbc.driver�� copy qaulified name���� �����ؼ� �ٿ� �ִ´�.
			conn = DriverManager.getConnection(url, user, password);	//�ܿ����� �κ�
		} catch (ClassNotFoundException e) {
			System.out.println("����̺� �˻� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn){	//conn�� �ݴ� ���
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt){	//stmt�� �ݴ� ���
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs){	//rs�� �ݴ� ���
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs){	//conn�� �ݴ� ���
		close(rs);
		close(stmt);
		close(conn);
	}
}

