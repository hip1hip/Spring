package com.example.openmarket.demo.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;


//필터클래스 추가 
//요청이 올때마다 요청 헤더에서 토큰을 꺼내 유효성 체크 
@RequiredArgsConstructor
public class JwtAuthenticationFilter  extends GenericFilterBean{
	
	public final TokenProvider provider;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin" , "*");
		res.setHeader("Access-Control-Allow-Credentials" , "true");
		res.setHeader("Access-Control-Allow-Methods" , "*");
		res.setHeader("Access-Control-Allow-Max-Age" , "3600");
		res.setHeader("Access-Control-Allow-Headers" , "Origin, X-Requested-Wuth, Content-Type, Acceot," + "Authorization");
		res.setStatus(HttpServletResponse.SC_OK);
		
		String token = provider.resolveToken((HttpServletRequest)request);
		//헤더에 토큰이 있고 토큰의 파기 시간이 남아있으면 정상 
		if(token !=null && provider.validateToken(token)) {
			Authentication a = provider.getAuthenticate(token);
			SecurityContextHolder.getContext().setAuthentication(a);
			
		}
		//연결된 다음 필터 실행 
		chain.doFilter(request, response);
	}
	
	

}
