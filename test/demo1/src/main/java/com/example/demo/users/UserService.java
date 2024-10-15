package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    // 추가 수정
    public UserDto saveUser(UserDto user) {
        User entity = userDao.save( new User(user.getName(), user.getScore()));
        return new UserDto(entity.getName(), entity.getScore());

    }

    //전체 조회
    public ArrayList<UserDto> getAll(){
        List<User> l = userDao.findAll();
        ArrayList<UserDto> list = new ArrayList<>();
        for(User entity:l) {
            list.add(new UserDto(entity.getName(), entity.getScore()));
        }
        return list;
    }



    public UserDto getUser(String userid) {
        User entity = userDao.findById(userid).orElse(null);
        if (entity != null) {
            return new UserDto(entity.getName(), entity.getScore());
        }
        return null;
    }
}