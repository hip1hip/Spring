package com.example.openmarket.demo.auth;

import com.example.openmarket.demo.users.UserDto;
import com.example.openmarket.demo.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody UserDto userDto) {
    authService.register(userDto);
    return ResponseEntity.ok("User registered successfully");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody UserDto userDto) {
    String token = authService.login(userDto);
    return ResponseEntity.ok(token);
  }
}
