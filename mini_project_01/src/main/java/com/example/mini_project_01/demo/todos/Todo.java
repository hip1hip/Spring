package com.example.mini_project_01.demo.todos;

import com.example.mini_project_01.demo.users.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity  //jpa entitiy
public class Todo {
    @Id   //pk 정의
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne  //board: member => 다대일
    @JoinColumn(nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE) //on delete cascade 설정
    private User userid;  //연관되는 entity터입으로 지정
}
