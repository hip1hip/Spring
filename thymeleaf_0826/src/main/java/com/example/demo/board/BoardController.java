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
	public String add(Board b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@GetMapping("/getAjax")
	public Map getAjax(int num) {
		System.out.println(num);
		Board b = service.getBoard(num);
		Map map = new HashMap();
		map.put("num", b.getNum());
		map.put("writer", b.getWriter());
		map.put("wdate", b.getWdate()+"");
		map.put("title", b.getTitle());
		map.put("content", b.getContent());
		return map;
	}
	
	
	@GetMapping("/detail")
	public void detail(int num, Model model, HttpServletRequest request, HttpServletResponse response) {
	    model.addAttribute("b", service.getBoard(num));
	    
	    // 쿠키를 생성하거나 업데이트
	    Cookie[] cookies = request.getCookies();
	    String readPosts = ""; // 기존에 읽은 글 목록이 있는지 확인
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("readPosts".equals(cookie.getName())) {
	                readPosts = cookie.getValue();
	                break;
	            }
	        }
	    }
	    
	    if (!readPosts.contains(String.valueOf(num))) {
	        readPosts += num + ",";
	        try {
	            // 쿠키 값을 URL 인코딩하여 설정
	            Cookie cookie = new Cookie("readPosts", URLEncoder.encode(readPosts, "UTF-8"));
	            cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효기간: 1일
	            response.addCookie(cookie);
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace(); // 인코딩 예외 처리
	        }
	    }
	}
	
	
	@GetMapping("/cookie")
	public String showReadPosts(HttpServletRequest request, Model model) {
	    Cookie[] cookies = request.getCookies();
	    String readPosts = "";
	    
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("readPosts".equals(cookie.getName())) {
	                try {
	                    // 쿠키 값을 URL 디코딩
	                    readPosts = URLDecoder.decode(cookie.getValue(), "UTF-8");
	                } catch (UnsupportedEncodingException e) {
	                    e.printStackTrace(); // 디코딩 예외 처리
	                }
	                break;
	            }
	        }
	    }
	    
	    List<Board> readBoards = new ArrayList<>();
	    if (!readPosts.isEmpty()) {
	        String[] postIds = readPosts.split(",");
	        for (String id : postIds) {
	            if (!id.isEmpty()) {
	                readBoards.add(service.getBoard(Integer.parseInt(id)));
	            }
	        }
	    }
	    
	    model.addAttribute("readBoards", readBoards);
	    return "board/cookie"; // cookie.html 파일로 이동
	}
	
	
	
	
	@PostMapping("/edit")
	public String edit(Board b) {
		service.editBoard(b);
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







