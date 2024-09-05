package com.example.openmarket.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService; // 사용자 서비스를 위한 클래스

  // 사용자 정보 조회
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable int id) {
    UserDto userDto = userService.getUserById(id);
    return ResponseEntity.ok(userDto);
  }

  // 사용자 정보 수정
  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
    userService.updateUser(id, userDto);
    return ResponseEntity.ok("User updated successfully");
  }
}
