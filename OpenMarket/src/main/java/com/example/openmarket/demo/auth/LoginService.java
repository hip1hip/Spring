package com.example.openmarket.demo.auth;

import com.example.openmarket.demo.users.User;
import com.example.openmarket.demo.users.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LoginService {

  private final AuthenticationManager authenticationManager;
  private final TokenProvider tokenProvider;
  private final UserDetailsService userDetailsService;

  public LoginService(AuthenticationManager authenticationManager, TokenProvider tokenProvider, UserDetailsService userDetailsService) {
    this.authenticationManager = authenticationManager;
    this.tokenProvider = tokenProvider;
    this.userDetailsService = userDetailsService;
  }

  public String login(LoginDto loginDto) {
    // 인증 처리
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

    // UserDetails 객체를 통해 UserDto 객체 생성
    UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
    UserDto userDto = new UserDto();
    userDto.setUsername(userDetails.getUsername());
    userDto.setType(User.UserType.valueOf(userDetails.getAuthorities().stream()
            .map(authority -> authority.getAuthority())
            .collect(Collectors.joining(", ")))); // 권한을 문자열로 변환

    // 토큰 생성
    return tokenProvider.getToken(userDto);
  }
}
