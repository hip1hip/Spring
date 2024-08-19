package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mem")  //get,post 상관없이 헤딩 컨트롤러의 공통 url, 둥록하는 모든 url 앞에 자동으로 mem이 붙는것. 
public class MemController {
	@Autowired  // 객체 자동으로 넣기 
	private MemService service;
	
	@GetMapping("/join")   ///mem/join
	public String join() {
		service.addMember();   //추가 잡업 
		return"/member/join";  //  /views/member/join 
	}
	
	@GetMapping("/info")
	public String info() {
		service.addMember();
		return"/member/info";
	}
	
	@GetMapping("/getall")
	public String getall() {
		service.addMember();
		return"/member/getall";
	}
	
	@GetMapping("/edit")
	public String edit() {
		service.addMember();
		return"/member/edit";
	}
	
	@GetMapping("/del")
	public String del() {
		service.addMember();
		return"/member/del";
	}
	
	
	
	
	//숙제 
	//검색. url:get. view:info.jsp
	
	//전체검색  url:getall. view:getall.jsp
	
	//수정 url:edit. view:edit.jsp
	
	//삭제 url:get. view:del.jsp
	
	
}
