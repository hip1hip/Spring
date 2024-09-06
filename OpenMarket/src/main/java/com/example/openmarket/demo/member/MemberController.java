package com.example.openmarket.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.openmarket.demo.auth.TokenProvider;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {
	@Autowired
	private MemberService service;

	@Autowired
	private TokenProvider provider;

	@Autowired
	private AuthenticationManagerBuilder abuilder;

	@PostMapping("/join")
	public ResponseEntity<Map<String, Object>> join(@RequestBody MemberDto dto) {
		boolean flag = true;
		MemberDto savedDto = null;
		try {
			savedDto = service.save(dto);
		} catch (Exception e) {
			flag = false;
			System.out.println(e);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("flag", flag);
		if (savedDto != null) {
			map.put("dto", savedDto);
		}
		return ResponseEntity.ok(map);
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
		String id = loginRequest.get("id");
		String pwd = loginRequest.get("pwd");

		System.out.println("인증 되는중?");
		UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(id, pwd);
		Authentication auth = abuilder.getObject().authenticate(authtoken);
		boolean flag = auth.isAuthenticated(); // 인증결과
		System.out.println("인증결과:" + flag);

		Map<String, Object> map = new HashMap<>();
		if (flag) { // 정상 인증
			String token = provider.getToken(service.getMember(id));
			map.put("token", token);
			map.put("id", id);
			map.put("type", service.getMember(id).getType()); // MemberDto의 type 반환
		}
		map.put("flag", flag);

		return ResponseEntity.ok(map);
	}

	@GetMapping("/auth/meminfo")
	public Map info() {
		Map map = new HashMap();
		Authentication auth =
				SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName(); //username 추출
		MemberDto dto = service.getMember(id);
		map.put("dto", dto);
		return map;
	}



}