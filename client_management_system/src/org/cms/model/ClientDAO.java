package org.cms.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class ClientDAO {
	Connection conn = JDBC.getConnection();
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String SELECT_ALL = "select * from cmsdb order by id asc";
	private final String INSERT = "insert into cmsdb(id, name, gender, phone, address) values (?,?,?,?,?)";
	private final String SELECT = "select * from cmsdb where id=?";
	private final String UPDATE = "update cmsdb set name=?, gender=?, phone=?, address=? where id=?";
	private final String DELETE = "delete from cmsdb where id=?";
	
	public static final Scanner scan = new Scanner(System.in);
	public ClientDAO() {}

	public ClientDAO(Connection conn) {
		this.conn = conn;
	}
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	

	public Vector<ClientDTO> selectAll(){
		Vector<ClientDTO> dtoVector = new Vector<>();
		try {
			Connection conn = JDBC.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				ClientDTO client = new ClientDTO(id, name, gender, phone, address);
				dtoVector.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtoVector;
	}
	public Vector<Vector> selectAll(ClientDTO client){
		Vector<Vector> dtoVector = new Vector<>();
		try {
			Connection conn = JDBC.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				Vector<String> list = new Vector<>();
				list.add(id);
				list.add(name);
				list.add(gender);
				list.add(phone);
				list.add(address);
				
				dtoVector.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtoVector;
	}
	public void insert(ClientDTO dto){
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getAddress());
			
			int cnt = pstmt.executeUpdate();

//			if(cnt>0){
//				conn.commit();
//			}else{
//				conn.rollback();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			JDBC.close(pstmt);
		}
	}
	public Vector<Vector> select(ClientDTO client){
		Vector<Vector> v = new Vector<>();

		try {			
			pstmt = conn.prepareStatement(SELECT);
			String id = client.getId();
			pstmt.setString(1, id);	
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
			String name = rs.getString(2);	
			String gender = rs.getString(3);
			String phone = rs.getString(4);
			String address = rs.getString(5);
			
			Vector<String> list = new Vector<>();
			list.add(id);
			list.add(name);
			list.add(gender);
			list.add(phone);
			list.add(address);
			
			v.add(list);
			
			System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC.close(pstmt);
		}
		return v;
	}
	public void update(ClientDTO dto){
		try {
	
			pstmt = conn.prepareStatement(UPDATE);
			
			pstmt.setString(5,dto.getId());
			pstmt.setString(1,dto.getName());
			pstmt.setString(2,dto.getGender());
			pstmt.setString(3,dto.getPhone());
			pstmt.setString(4,dto.getAddress());			
			
			int cnt = pstmt.executeUpdate();
			
//			if(cnt>0){
//				conn.commit();
//			}else{
//				conn.rollback();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC.close(pstmt);
			
			
		}
	}
	public void delete(ClientDTO dto){
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1,dto.getId());
			int cnt = pstmt.executeUpdate();
			
//			if(cnt>0){
//				conn.commit();
//			}else{
//				conn.rollback();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC.close(pstmt);
		}
	}
}
