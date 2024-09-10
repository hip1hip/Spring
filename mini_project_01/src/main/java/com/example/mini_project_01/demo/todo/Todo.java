package com.example.mini_project_01.demo.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity  //jpa entitiy
public class Todo {
    @Id   //pk 정의
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    private String content;
}
