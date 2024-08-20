package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/guest")
public class GuestController {
	@Autowired 
	private GuestService service;
	
	
//	@GetMapping("/detail")
//	public String detail(int id, Model m) {  
//		Guest guest = service.getGuest(id);  //id로 검색함 
//
////		m.addAttribute("city", city); // addAttribute("뷰페이지에서 부를 이름" , 전달한 값) 
//		System.out.println(guest);  //서버 관리자만 볼수 있음 
//		return "guest/detail"; // 응답페이지  
//	}
	
	
    @GetMapping("/add")
    public String addForm(Model m) {
        ArrayList<String> list = new ArrayList<>();    
        m.addAttribute("list", list);
        return "add";
    }
    
    @PostMapping("/add")
    public String add(Guest guest) {  
        service.addGuest(guest);
        return "index";
    }
		


	
		@RequestMapping("/guest/list")
		public String list(Model m) {
			m.addAttribute("list", service.getAll());
			return "guest/list";
		}
		
		@PostMapping("/edit")
		public String edit(Guest guest) {
			service.editGuest(guest);
			return "index";
		}
		
		@GetMapping("/del")
		public String del(int id) {
			service.delGuest(id);
			return "index";
		}
		
		
	
	
	
}
