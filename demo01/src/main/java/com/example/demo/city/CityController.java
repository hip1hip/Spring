package com.example.demo.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired 
	private CityService service;
	
	//Model : 뷰 페이지에 전달할 값을 담는 용도
	//파라미터로 지정하면 객체 자동 생성해주고 값을 뷰페이지로 자동으로 전달됨
	@GetMapping("/detail")
	public String detail(int id, Model m) {  
		City city = service.getCity(id);  //id로 검색함 
		if(city == null) {
			m.addAttribute("msg", "없는 아이디"); 
		}else {
			m.addAttribute("city", city); 
		}
//		m.addAttribute("city", city); // addAttribute("뷰페이지에서 부를 이름" , 전달한 값) 
		System.out.println(city);  //서버 관리자만 볼수 있음 
		return "city/detail"; // 응답페이지  
	}

	
	@GetMapping("/info")
	public String info() {
		return "city/info";  //검색하고 싶은 도시 찾기위해 
	}
	
	@GetMapping("/add")
	public String add() {
		return "city/add";
	}
	
	@PostMapping("/add")
	public String add() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
