package com.example.mini_project_01.demo.users;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    // 추가 수정
    public UserDto saveUser(UserDto user) {
        User entity = userDao.save( new User(user.getUserid(), user.getUsername(),user.getPassword()));
        return new UserDto(entity.getUserid(), entity.getUsername(),entity.getPassword());

    }

    public UserDto getUser(String userid) {
        User entity = userDao.findById(userid).orElse(null);
        if (entity != null) {
            return new UserDto(entity.getUserid(), entity.getUsername(), entity.getPassword());
        }
        return null;
    }
}
