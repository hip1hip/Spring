package com.example.demo.product;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.member.Member;

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
//@Entity  
public class ProductDto {
	private int num;
	private String name;
	private int price;
	private int amount;
	private Member seller;
	private String img;  //상품 이미지 경로 
	private MultipartFile f;  //폼에서 전송한 이미지 저장할 변수 
}
