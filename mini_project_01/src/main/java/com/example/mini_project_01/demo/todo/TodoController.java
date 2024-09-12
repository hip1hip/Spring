package com.example.mini_project_01.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")  //요청받을 ip주소
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    //todo 작성
    @PostMapping("")
    public Todo add(@RequestBody TodoDto to){
//        Map map = new HashMap();
        try {
            return service.save(to);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //전체조회
    @GetMapping("")
    public Map list(){
        Map map = new HashMap();
        ArrayList<TodoDto> list = service.getAll();
        map.put("list", list);
        return map;
    }

    @PutMapping("")
    public Map edit(TodoDto to) {
        Map map = new HashMap();
        TodoDto dto = service.getTodo(to.getNum());
        dto.setContent(to.getContent());
        try {
            service.save(dto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;

    }


    //삭제
    @DeleteMapping("/{num}")
    public Map del(@PathVariable("num") int num){
        Map map = new HashMap();
        try{
            service.delTodo(num);

        }catch (Exception e){
            System.out.println(e);
        }
        return map;
    }



}
