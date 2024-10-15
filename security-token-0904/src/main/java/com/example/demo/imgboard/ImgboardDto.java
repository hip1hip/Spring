package com.example.demo.imgboard;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.users.Users;

import jakarta.persistence.Entity;
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
public class ImgboardDto {
	private int num;
	private Users writer;
	private String title;
	private String img;  
	private MultipartFile f; 
	
	
	
	
}
