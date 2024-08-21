package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import conn.MysqlConnect;

@Repository
public class GuestDao {
	private MysqlConnect dbconn;
	 
	public void insert(Guest guest) {
		// 도시 하나 추가하는 테이블에 한줄 추가하는 
		Connection conn = dbconn.getConn();
		String sql = "insert into guestbook(writer , pwd , wdate , content ) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getPwd());
			pstmt.setString(3, guest.getWdate());
			pstmt.setString(4, guest.getContent());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Guest> selectAll(){
		ResultSet rs = null;
		ArrayList<Guest> list = new ArrayList<>();
		Connection conn = dbconn.getConn();
		String sql = "select * from Guest order by id";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Guest(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) ));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void update(Guest guest) {
		Connection conn = dbconn.getConn();
		String sql = "update guest set content=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guest.getContent());
			pstmt.setInt(2, guest.getId());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void delete (int id) {
		Connection conn = dbconn.getConn();
		String sql = "delete from guest where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
