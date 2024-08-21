package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class GuestService {
	
	@Autowired
	private GuestDao dao;
		

//	public Guest getGuest(int id) {
//		return dao.select(id);
//	}  
	//id 로 검색하는 
	
	public void addGuest(Guest guest) {
		dao.insert(guest);
	}
	
	public ArrayList<Guest> getAll(){
		return dao.selectAll();
	}
	
	public void editGuest(Guest guest) {
		dao.update(guest);
	}
	public void delGuest(int id) {
		dao.delete(id);
	}
	
	
}
