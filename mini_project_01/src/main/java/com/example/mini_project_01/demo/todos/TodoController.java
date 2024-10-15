package com.example.mini_project_01.demo.todos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*")  //요청받을 ip주소
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    //todo 작성
    @PostMapping("")
    public Todo add( TodoDto to){
//        Map map = new HashMap();
        log.info(to.toString() + "======================");
        System.out.println(to);
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
        TodoDto dto = service.getTodo(to.getId());
        dto.setContent(to.getContent());
        try {
            service.save(dto);
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;

    }


    //삭제
    @DeleteMapping("/{id}")
    public Map del(@PathVariable("id") int id){
        Map<String, String> response = new HashMap<>();
        try{
            service.delTodo(id);
            response.put("status", "success");
        }catch (Exception e){
            response.put("status", "error");
        }
        return response;
    }



}
