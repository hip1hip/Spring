package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//stereotype 클래스 종류 구별 , 클라이언트에 요청을 받아서 처리하는게 컨트롤러 
@Controller  // fullstack 컨트롤러 
public class HomeController {
	
	@GetMapping("/") // get 요청만 받음  / url 적음 / 루트에 오는 get 요청만 받겠다 / 그럼 하단의 컨트롤러 자동 실행 
	public String home() {  // 요청을 처리하는 뷰 페이지 경로를 반환 
		return "index";   //webapp 은 기본 루트라서 그 밑에 폴더만 적어줌 /views/index.jsp
	}
	

	
}
