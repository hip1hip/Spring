package com.example.demo.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemService {
	@Autowired
	private MemDao dao;
	
	//추가
		public void addMem(Member m) {
			dao.insert(m);
		}
		
		//번호로검색
		public Member getMem(String id) {
			return dao.select(id);
		}
		
		//수정
		public void editMem(Member m) {
			dao.update(m);
		}
		
		//삭제
		public void delMem(String id) {
			dao.delete(id);
		}
		

	}
