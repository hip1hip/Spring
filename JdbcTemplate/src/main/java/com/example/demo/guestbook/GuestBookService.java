package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookService {
	@Autowired
	private GuestBookDao dao;
	
	//추가
	public void addBook(GuestBook gb) {
		dao.insert(gb);
	}
	
	//번호로검색
	public GuestBook getBook(int num) {
		return dao.select(num);
	}
	
	//수정
	public void editBook(GuestBook gb) {
		dao.update(gb);
	}
	
	//삭제
	public void delBook(int num) {
		dao.delete(num);
	}
	
	//전체목록
	public ArrayList<GuestBook> getAll(){
		return dao.selectAll();
	}
}