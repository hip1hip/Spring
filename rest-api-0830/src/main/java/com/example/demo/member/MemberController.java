package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")  //요청받을 ip주소 
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemService service;
	
	//추가
	@PostMapping("")
	public Map add(MemberDto m) {
		Map map = new HashMap();
		MemberDto m2 = service.saveMem(m);  //db로 전송 
		map.put("dto", m2);
		return map;
	}
	
	//pk로 검색 
	@GetMapping("/{id}")   //검색하고자 하는 pk값 /members/aaa 
	public Map get(@PathVariable("id") String id) {
		Map map = new HashMap();
		MemberDto dto = service.getMem(id);
		map.put("dto", dto);
		return map;
	}
	
	
	
	//수정 
	@PutMapping("")
	public Map edit(MemberDto m) { //id, 새 pwd 
		Map map = new HashMap();
		MemberDto old = service.getMem(m.getId());
		//pwd 만 수정 
		old.setPwd(m.getPwd());
		MemberDto m2 = service.saveMem(old);
		map.put("dto", m2);
		return map;
	}

	//삭제 
	@DeleteMapping("/{id}")
	public Map delete(@PathVariable("id") String id) {
		Map map = new HashMap();
		boolean flag = true;
		try {
		service.delMem(id);
		} catch (Exception e ){
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}
	
	//로그인 
	@GetMapping("/login")
	public Map login(String id, String pwd) {
		Map map = new HashMap();
		boolean flag = false;
		MemberDto m = service.getMem(id);
		if(m!=null && m.getPwd().equals(pwd)) {
			flag = true;
			map.put("loginId", m.getId());
			map.put("type",	m.getType());
		}
		
		map.put("flag", flag);
		return map; 
		
	}
	
	
	
	
	
	
	
}
