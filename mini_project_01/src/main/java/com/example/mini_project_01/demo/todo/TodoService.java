package com.example.mini_project_01.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoDao dao;

    //추가, 수정
    public Todo save(TodoDto to){
        return dao.save(new Todo(to.getNum(), to.getContent()));
    }

    //수정
    public TodoDto getTodo(int num) {
        Todo to = dao.findById(num).orElse(null);
        return new TodoDto(to.getNum(), to.getContent());
    }

    //전체 조회
    public ArrayList<TodoDto> getAll(){
        List<Todo> l = dao.findAll();
        ArrayList<TodoDto> list = new ArrayList<>();
        for(Todo to:l) {
            list.add(new TodoDto(to.getNum(), to.getContent()));
        }
        return list;
    }

    //삭제
    public void delTodo(int num) {
        dao.deleteById(num);
    }



}
