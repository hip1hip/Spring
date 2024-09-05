package com.example.demo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.guestbook.GuestbookDto;
import com.example.demo.guestbook.GuestbookService;

@SpringBootTest
public class ServiceTest {
	@Autowired
	private GuestbookService service;
	
	@Test
	void addTest() {
		GuestbookDto dto = service.getBook(1); //1번글 검색 
		if(dto != null) {
		dto.setWriter("asdf");
		dto.setContent("가나다라마");
		service.saveBook(dto);
		}else {
			System.out.println("없는 글");
		}
		
//		service.saveBook(new GuestbookDto(0, "bbb" , null, "111", "새글내용"));
		
	}
	
	@Test
	void listTest() {
		ArrayList<GuestbookDto> list = service.getAll();
		System.out.println(list);
		
	}
}
