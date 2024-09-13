package com.example.mini_project_01.demo.todos;

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
        return dao.save(new Todo(to.getId(), to.getContent(), to.getUserid()));
    }

    //수정
    public TodoDto getTodo(int id) {
        Todo to = dao.findById(id).orElse(null);
        return new TodoDto(to.getId(), to.getContent(), to.getUserid());
    }

    //전체 조회
    public ArrayList<TodoDto> getAll(){
        List<Todo> l = dao.findAll();
        ArrayList<TodoDto> list = new ArrayList<>();
        for(Todo to:l) {
            list.add(new TodoDto(to.getId(), to.getContent(), to.getUserid()));
        }
        return list;
    }

    //삭제
    public void delTodo(int id) {
        dao.deleteById(id);
    }



}
