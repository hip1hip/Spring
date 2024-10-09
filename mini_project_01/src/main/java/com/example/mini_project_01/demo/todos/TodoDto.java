package com.example.mini_project_01.demo.todos;


import com.example.mini_project_01.demo.users.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {
    private int id;
    private String content;
    private User userid;
}
