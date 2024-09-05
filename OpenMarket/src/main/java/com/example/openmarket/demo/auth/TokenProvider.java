package com.example.openmarket.demo.auth;

import com.example.openmarket.demo.users.UserDto; // 수정된 패키지
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class TokenProvider {

	// 토큰 유효 시간
	private final long expiredTime = 1000 * 60 * 60 * 1L; // 1시간

	// 암호화에 사용할 키 생성
	private final Key key = Keys.hmacShaKeyFor(
					"dffasdfgeqrrthfghgfhjgdhgaipiohdfgghjghkjhkjhfsdfgjjhhgjgh".getBytes(StandardCharsets.UTF_8));

	private final UserDetailsService userDetailsService;

	// 토큰 생성하여 반환
	public String getToken(UserDto dto) {
		return Jwts.builder()
						.setSubject(dto.getUsername()) // 사용자의 아이디
						.setHeader(createHeader()) // 토큰의 헤더 정보 셋
						.setClaims(createClaims(dto)) // 클레임 정보 셋
						.setExpiration(new Date((new Date()).getTime() + expiredTime)) // 토큰 만료 시간 설정
						.signWith(key, SignatureAlgorithm.HS256)
						.compact();
	}

	// 헤더 정보 생성해서 반환
	private Map<String, Object> createHeader() {
		Map<String, Object> map = new HashMap<>();
		map.put("typ", "JWT");
		map.put("alg", "HS256");
		map.put("regDate", System.currentTimeMillis());
		return map;
	}

	// 클레임 생성해서 반환
	private Map<String, Object> createClaims(UserDto dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", dto.getUsername());
		map.put("roles", dto.getType());
		return map;
	}

	// 클레임 바디 반환
	private Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	// username 반환
	public String getUserName(String token) {
		return (String) getClaims(token).get("username");
	}

	// role 반환
	public String getRole(String token) {
		return (String) getClaims(token).get("roles");
	}

	// 요청 헤더에서 토큰을 꺼내 반환
	public String resolveToken(HttpServletRequest req) {
		return req.getHeader("Authorization"); // 일반적으로 "Authorization" 헤더를 사용
	}

	// 토큰 유효성 검사
	public boolean validateToken(String token) {
		try {
			Claims claims = getClaims(token);
			return !claims.getExpiration().before(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 토큰 인증
	public Authentication getAuthenticate(String token) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(getUserName(token));
		return new UsernamePasswordAuthenticationToken(
						userDetails, "", userDetails.getAuthorities());
	}


}
