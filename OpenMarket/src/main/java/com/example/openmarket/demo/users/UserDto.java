package com.example.openmarket.demo.users;

import lombok.Data;

@Data
public class UserDto {
  private int id;
  private String username;
  private String password;
  private String email;
  private String phoneNumber;
  private User.UserType type;

}
