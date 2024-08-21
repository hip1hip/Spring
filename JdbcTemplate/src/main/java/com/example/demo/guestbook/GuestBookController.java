package com.example.demo.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookService service;
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("list", service.getAll());
		return "index";
	}

	//글작성 폼
	@GetMapping("/book/add")
	public void addForm() {}
	
	//작성 완료
	@PostMapping("/book/add")
	public String add(GuestBook gb) {
		service.addBook(gb);
		return "redirect:/";  //redirect로 이동. 사용자가 새 요청. 
	}
	
	@GetMapping("/book/detail")
	public void detail(int num, Model m) {
		m.addAttribute("gb", service.getBook(num));
	}
	
	@GetMapping("/book/edit")
	public String edit(GuestBook gb) {
		service.editBook(gb);
		return "redirect:/";
	}
	
	@GetMapping("/book/del")
	public String del(int num) {
		service.delBook(num);
		return "redirect:/";
	}
}








