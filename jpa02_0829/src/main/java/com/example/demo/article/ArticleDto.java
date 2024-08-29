package com.example.demo.article;


import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.member.Member;

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
public class ArticleDto {
	private int num ;
	private Member writer;  //연관되는 entity터입으로 지정 
	private Date wdate;
	private String title;
	private String content;
	private String data;
	private int cnt;
	private MultipartFile  f;
}
