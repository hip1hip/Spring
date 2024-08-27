package com.example.demo.member;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity  //jpa entitiy
public class Member {
	@Id   //pk 정의
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 넘버링
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String type;
	
}
