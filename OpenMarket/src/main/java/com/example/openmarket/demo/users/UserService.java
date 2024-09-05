package com.example.openmarket.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void registerUser(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setEmail(userDto.getEmail());
    user.setPhoneNumber(userDto.getPhoneNumber());
    user.setType(userDto.getType());
    userRepository.save(user);
  }

  public UserDto getUserById(int id) {
    User user = userRepository.findById((long) id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    return convertToDto(user);
  }

  public void updateUser(int id, UserDto userDto) {
    User user = userRepository.findById((long) id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPhoneNumber(userDto.getPhoneNumber());
    user.setType(userDto.getType());
    userRepository.save(user);
  }

  private UserDto convertToDto(User user) {
    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    dto.setPhoneNumber(user.getPhoneNumber());
    dto.setType(user.getType());
    return dto;
  }
}
