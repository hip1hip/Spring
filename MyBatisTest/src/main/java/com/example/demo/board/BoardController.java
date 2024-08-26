package com.example.demo.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		// 쿠키에서 읽은 글 목록 가져오기
		List<String> readPosts = getExistingPostsFromCookie(request);

		// 읽은 글 목록을 모델에 추가
		model.addAttribute("readPosts", readPosts);

		// 전체 게시글 목록을 모델에 추가
		model.addAttribute("list", service.getAll());

		return "board/list";
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
	public Map <String , Object >getAjax(int num) {
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
	public String detail(int num , Model model, HttpServletRequest request, HttpServletResponse response) {
		// 현재 게시글 정보를 가져오는 코드
		Board board = service.getBoard(num);
		model.addAttribute("b", board);

		// 기존 쿠키 값을 가져와 새로운 값을 추가
		String existingPosts = String.join("-", getExistingPostsFromCookie(request));
		String newCookieValue = num + (existingPosts.isEmpty() ? "" : "-") + existingPosts;

		//  쿠키에 저장
		Cookie cookie = new Cookie("readPosts", newCookieValue);
		cookie.setMaxAge(60 * 60 * 24);
		cookie.setPath("/");
		response.addCookie(cookie);

		return "/board/detail";
	}

	private List<String> getExistingPostsFromCookie(HttpServletRequest request) {
		List<String> posts = new ArrayList<>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("readPosts".equals(cookie.getName())) { // 쿠키 이름 통일
					String[] postIds = cookie.getValue().split("-");
					for (String postId : postIds) {
						posts.add(postId);
					}
				}
			}
		}
		return posts;
	}



	@GetMapping("/readPosts")
	public String getReadPosts(HttpServletRequest request, Model model) {
		// 쿠키에서 저장된 글 번호를 가져와 ArrayList에 저장
		ArrayList<Integer> readPosts = new ArrayList<>();
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("readPosts")) {
					String[] postNums = cookie.getValue().split("-");
					for (String num : postNums) {
						if (!num.isEmpty()) {
							readPosts.add(Integer.parseInt(num));

						}
					}
				}
			}
		}

		// 글 번호로 게시물 정보를 가져와 모델에 추가
		ArrayList<Board> boards = new ArrayList<>();
		for (Integer postNum : readPosts) {
			boards.add(service.getBoard(postNum));
		}

		model.addAttribute("readPosts", boards);
		return "/board/readPosts";
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
	public String getTitel(String title, Model m) {
		m.addAttribute("list",service.getByTitle(title));
		return "board/list";
	}
	
	@GetMapping("/getbywriter")
	public String getByWriter(String writer, Model m) {
		m.addAttribute("list",service.getByWriter(writer));
		return "board/list";
	}

}


