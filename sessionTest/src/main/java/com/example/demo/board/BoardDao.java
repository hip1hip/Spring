package com.example.demo.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate temp;
	
	public class BoardResultMap implements RowMapper<Board>{

		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Board(rs.getInt(1) , rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
		}
		
	}
	
	public void insert(Board b) {
		String sql = "insert into board values(?,?,sysdate(),?,?)";
		temp.update(sql , b.getNum(), b.getWriter(), b.getTitle(), b.getContent());
		
	}
	
	public Board select(int num) {
		String sql = "select * from board where num=? ";
		try {
			return temp.queryForObject(sql, new BoardResultMap(), num);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public ArrayList<Board> selectAll() {
		String sql = "select * from board order by num";
		ArrayList<Board> list = (ArrayList<Board>) temp.query(sql, new BoardResultMap());
		return list;
	}
	
	public ArrayList<Board> selectByTitle(String writer) {  //like 패턴검색 
		String sql = "Select * from board where title like ? order by num";
		ArrayList<Board> list = (ArrayList<Board>) temp.query(sql , new BoardResultMap(), writer );
		return list;
	}
	
	public ArrayList<Board> selectByWriter(String writer) {  //like 패턴검색 
		String sql = "Select * from board where writer like ? order by num";
		ArrayList<Board> list = (ArrayList<Board>) temp.query(sql , new BoardResultMap(), writer );
		return list;
	}
	
	//제목 내용 수정 
	public void update(Board b) {
		String sql = "update board set title=?, content=? where num=? ;" ;
		temp.update(sql, b.getTitle() , b.getContent(), b.getNum());
	}
	
	public void delete(int num) {
		String sql = "delete from board where num=?";
		temp.update(sql, num);
	}

	
}
