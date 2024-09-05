package com.example.openmarket.demo.auth;

import com.example.openmarket.demo.users.UserDto;
import com.example.openmarket.demo.users.User;
import com.example.openmarket.demo.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserDetailsService userDetailsService;
  private final TokenProvider tokenProvider;
  private final AuthenticationManager authenticationManager;

  public void register(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword())); // 비밀번호 암호화
    user.setEmail(userDto.getEmail());
    user.setPhoneNumber(userDto.getPhoneNumber());
    user.setType(userDto.getType());
    userRepository.save(user);
  }

  public String login(UserDto userDto) {
    try {
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword())
      );
      return tokenProvider.getToken(userDto);
    } catch (AuthenticationException e) {
      throw new RuntimeException("Invalid username or password");
    }
  }
}
