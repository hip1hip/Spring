package com.example.openmarket.demo.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
  private String username;
  private String password;
  private String email;
  private String role; // 예: ROLE_USER
}
