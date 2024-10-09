package com.example.openmarket.demo.member;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String type;
}
