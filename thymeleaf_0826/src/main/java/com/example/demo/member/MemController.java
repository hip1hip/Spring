package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemController {
	@Autowired
	private MemService service;
	
	
	@GetMapping("/")
	public String home() {
		return "boardIndex";
	}
	
	
	
	@GetMapping("/join")
	public void joinFrom() {
	}
	
	@PostMapping("/join")
	public String join(Member m) {
		service.addMem(m);
		return "boardIndex";
	}
	

	@ResponseBody
	@GetMapping("/idcheckAjax")
	public Map idcheckAjax(String id) {
		Map map = new HashMap();
		boolean flag = false;
		if(service.getMem(id)== null) {
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}
	
	
	@PostMapping("/login")
	public String login(Member m , HttpSession session , Model model) {
		Member m2 = service.getMem(m.getId());
		if(m2 != null && m2.getPwd().equals(m.getPwd())) {
			session.setAttribute("loginId", m2.getId());
			session.setAttribute("type", m2.getType());
		}else {
			model.addAttribute("msg", "로그인 실패");

		}
		return  "boardIndex";  //"index"
	}


	
	@GetMapping("/login")
	public void loginForm() {

	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "boardIndex";
	}
	
	@GetMapping("/detail")
	public String detailForm(String id, Model model) {
		model.addAttribute("member", service.getMem(id));
		return "/detail";
	}
	
	@GetMapping("/edit")
	public String editForm(String id , Model model) {
		Member member = service.getMem(id);
		model.addAttribute("member",member);
		return "/member/editForm";
		
		
	}
	
	@PostMapping("/edit")
	public String edit(Member member) {
		service.editMem(member);
		return "redirect:/member/";
	}
	
	
	@GetMapping("/out")
	public String out(HttpSession session) {
		String loginId = ((String)session.getAttribute("loginId") );
		service.delMem(loginId);
		return "redirect:/member/logout";
				
	}  //forward : 서버 내에서 이동 , url 안바뀜 / member/join => index / 계속 새로고침하면 반복됨 
		//redirect : 새요청 시킴 , req. /member/join => index
	
	
	

	
	
	@PostMapping("/temp/session")
	public String sessionTest(String msg  , HttpSession session) {
		session.setAttribute("msg", msg);
	return "/temp/session";
	}
	

	
	
	
	
	
	
	
}
