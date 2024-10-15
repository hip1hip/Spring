package com.example.mini_project_01.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")  //요청받을 ip주소
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //추가
    @PostMapping("/join")
    public Map add(@RequestBody UserDto userDto) {
        Map<String, Object> map = new HashMap<>();
        try {
            UserDto Dto = userService.saveUser(userDto);
            map.put("user", Dto);
        } catch (Exception e) {
            map.put("error", "가입 중 오류가 발생했습니다: " + e.getMessage());
        }
        return map;
    }

    //로그인
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData)  {
        Map<String, Object> map = new HashMap<>();
        boolean flag = false;

        // 요청에서 userid와 password를 가져옴
        String userid = loginData.get("userid");
        String password = loginData.get("password");

        UserDto Dto = userService.getUser(userid);
        if(Dto!=null && Dto.getPassword().equals(password)) {
            flag = true;
            map.put("userid", Dto.getUserid());
//            map.put("type",	Dto.getType());
        }

        //세션저장  - 세션보고 백엔드에서 누군지 알 수 있게 / [인터셉터]나 필터

        map.put("flag", flag);
        return map;

    }


}
