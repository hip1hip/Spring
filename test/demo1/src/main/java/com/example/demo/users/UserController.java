package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController

@CrossOrigin(origins = "*")  //요청받을 ip주소
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


        //추가
        @PostMapping("")
        public ResponseEntity<?> add(@RequestBody  UserDto userDto) {
//            Map<String, Object> map = new HashMap<>();
            System.out.println(userDto);
            try {
                UserDto savedUser = userService.saveUser(userDto);
                return ResponseEntity.ok(savedUser);
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An error occurred while saving the user");
            }
        }




    //전체조회
    @GetMapping("")
    public Map list(){
        Map map = new HashMap();
        ArrayList<UserDto> list = userService.getAll();
        map.put("list", list);
        return map;
    }
}
