package com.example.demo.guestbook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GuestBookDao {
	@Autowired
	private JdbcTemplate temp; // 사용할 jdbctemplate 객체 의존성 주입

	// resultMap 정의
	public class GuestResultMap implements RowMapper<GuestBook> {

		// ResultSet의 한 행을 처리. 파람으로 처리해야할 행 번호를 받음
		// 각 컬럼을 vo 생성자 파람에 맵핑
		@Override
		public GuestBook mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new GuestBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
		}

	}

	public void insert(GuestBook gb) {
		String sql = "insert into guestbook(writer,pwd,wdate,content) values(?,?,sysdate(),?)";
		temp.update(sql, new Object[] { gb.getWriter(), gb.getPwd(), gb.getContent() });
	}

	public GuestBook select(int num) {
		String sql = "select * from guestbook where num=?";
		GuestBook gb = null;
		try {
			gb = temp.queryForObject(sql, new GuestResultMap(), num);// queryForObject():한줄검색
		} catch (Exception e) {
			System.out.println(e);
		}
		return gb;
	}

	public ArrayList<GuestBook> selectAll() {
		String sql = "select * from guestbook order by num";
		return (ArrayList<GuestBook>) temp.query(sql, new GuestResultMap());
	}

	public void update(GuestBook gb) {
		String sql = "update guestbook set content=? where num=?";
		temp.update(sql, new Object[] { gb.getContent(), gb.getNum() });
	}

	public void delete(int num) {
		String sql = "delete from guestbook where num=?";
		temp.update(sql, num);
	}
}
