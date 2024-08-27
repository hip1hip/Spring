package com.example.demo.board;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getAll());
	}
	
	
	
	
	@GetMapping("/add")
	public void addForm() {}
	
	@PostMapping("/add")
	public String add(BoardDto b) {
		service.saveBoard(b);
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@GetMapping("/getAjax")
	public Map getAjax(int num) {
		System.out.println(num);
		BoardDto b = service.getBoard(num);
		Map map = new HashMap();
		map.put("num", b.getNum());
		map.put("writer", b.getWriter());
		map.put("wdate", b.getWdate()+"");
		map.put("title", b.getTitle());
		map.put("content", b.getContent());
		return map;
	}
	
	
	@GetMapping("/detail")
	public void detail(int num, Model model, HttpServletRequest req, HttpServletResponse res) {
	    model.addAttribute("b", service.getBoard(num));
	    
	    // 쿠키를 생성하거나 업데이트
	    Cookie[] c = req.getCookies();
	    String val = ""; // 기존에 읽은 글 목록이 있는지 확인
	        for (Cookie cc : c) {
	            if (cc.getName().equals("today")) {
	            	val = cc.getValue();
	            	val += "/" + num;
	                
	            }
	        }
	        if (val.equals("")) {
	        	val = num +"";
	    }
	        res.addCookie(new Cookie("today", val));
	}
	
	
	@GetMapping("/today")
	public String today(HttpServletRequest req, Model model) {
		String val = "";
	    Cookie[] c = req.getCookies();
	    for (Cookie cc : c) {
	    	if(cc.getName().equals("today") ) {
	    		val = cc.getValue();
	    	}
	    }
	    ArrayList<BoardDto> list = new ArrayList<>();
	    if(!val.equals("")) {
	    	String[] val2 = val.split("/");
	    	for (String n : val2) {
	    		int num = Integer.parseInt(n);
	    		list.add(service.getBoard(num));
	    	}
	    }
	    model.addAttribute("list", list);
	    return "board/list";
	    
	}
	
	
	
	
	@PostMapping("/edit")
	public String edit(BoardDto b) {
		//수정하기 전 원본 글 정보검색. save() 모든 컬럼 수정. 누락된 값은 null.
		BoardDto ob = service.getBoard(b.getNum());
		ob.setTitle(b.getTitle());
		ob.setContent(b.getContent());
		service.saveBoard(ob);
		return "redirect:/board/list";
	}
	
	@GetMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
	
	@GetMapping("/getbytitle")
	public String getByTitle(String title, Model m) {
		m.addAttribute("list", service.getByTitle(title));
		return "board/list";
	}
	
	@GetMapping("/getbywriter")
	public String getByWriter(String writer, Model m) {
		m.addAttribute("list", service.getByWriter(writer));
		return "board/list";
	}
	
	
	
}







