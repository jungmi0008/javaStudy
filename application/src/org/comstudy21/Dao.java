package org.comstudy21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.util.JdbcUtil;

public class Dao {
		private Connection conn;
		private ResultSet rs;
		private Statement stmt;
		private PreparedStatement pstmt;

		private String selectAll = "SELECT * FROM APP_DATA";
		private String insert = "INSERT INTO APP_DATA VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		private String selectOne = "SELECT * FROM APP_DATA WHERE NAME=?";
		private String search = "SELECT * FROM APP_DATA WHERE COURSE=?";
//		private String update = "UPDATE APP_DATA SET NAME=?, AGE=? WHERE NAME=?";
		private String delete = "DELETE FROM APP_DATA WHERE NAME=?";

		public Dao() {
		}
		public Dao(Connection conn) {
			this.conn = conn;
		}
		public void setConn(Connection conn) {
			this.conn = conn;
		}
		public Dto[] selectAll() {
			Dto[] arr = null;
			ArrayList<Dto> list = new ArrayList<>();

			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(selectAll);
				while(rs.next()){
					String name = rs.getString("name");
					String idNumber1 = rs.getString("idNumber1");
					String idNumber2 = rs.getString("idNumber2");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String mobile = rs.getString("mobile");
					String payment = rs.getString("payment");
					String startDay = rs.getString("startDay");
					String endDay = rs.getString("endDay");
					String agree = rs.getString("agree");
					String course = rs.getString("course");
					list.add(new Dto(name, idNumber1, idNumber2,address, phone, mobile, payment,
							startDay, endDay, agree,course));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}

			arr = new Dto[list.size()];
			list.toArray(arr);

			return arr;
		}
		public void insert(Dto dto) {
			System.out.println(dto);
			
			try {
				pstmt = conn.prepareStatement(insert);
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getIdNumber1());
				pstmt.setString(3, dto.getIdNumber2());
				pstmt.setString(4, dto.getAddress());
				pstmt.setString(5, dto.getPhone());
				pstmt.setString(6, dto.getMobile());
				pstmt.setString(7, dto.getPayment());
				pstmt.setString(8, dto.getStartDay());
				pstmt.setString(9, dto.getEndDay());
				pstmt.setString(10, dto.getAgree());
				pstmt.setString(11, dto.getCourse());
				int cnt = pstmt.executeUpdate();
				if(cnt>0) {
					System.out.println("### 삽입 성공!");
					conn.commit();
				} else {
					System.out.println("### 삽입 실패!");
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			
		}
		public Dto selectOne(Dto dto) {
			Dto saram = null;
			ArrayList<Dto> list = new ArrayList<>();

			try {
				pstmt = conn.prepareStatement(selectOne);
				pstmt.setString(1, dto.getName());
				rs = pstmt.executeQuery();
				if(rs.next()){
					String name = rs.getString("name");
					String idNumber1 = rs.getString("idNumber1");
					String idNumber2 = rs.getString("idNumber2");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String mobile = rs.getString("mobile");
					String payment = rs.getString("payment");
					String startDay = rs.getString("startDay");
					String endDay = rs.getString("endDay");
					String agree = rs.getString("agree");
					String course = rs.getString("course");
					saram = new Dto(name, idNumber1, idNumber2,address, phone, mobile, payment,
							startDay, endDay, agree,course);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			return saram;
		}
		public Dto[] search(Dto dto) {
			Dto[] arr = null;
			ArrayList<Dto> list = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(search);
				pstmt.setString(1, dto.getCourse());
				rs = pstmt.executeQuery();
				while(rs.next()){
					String name = rs.getString("name");
					String idNumber1 = rs.getString("idNumber1");
					String idNumber2 = rs.getString("idNumber2");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String mobile = rs.getString("mobile");
					String payment = rs.getString("payment");
					String startDay = rs.getString("startDay");
					String endDay = rs.getString("endDay");
					String agree = rs.getString("agree");
					String course = rs.getString("course");
					list.add(new Dto(name, idNumber1, idNumber2,address, phone, mobile, payment,
							startDay, endDay, agree,course));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			arr = new Dto[list.size()];
			list.toArray(arr);

			return arr;
		}
	}

