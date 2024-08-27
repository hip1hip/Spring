package com.example.demo.guestbook;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
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
public class Guestbook {
	@Id   //pk 정의
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 넘버링
	private int num;
	
	/* @Column(name="memberid", nullable) */
	private String writer;
	private Date wdate;
	private String pwd;
	private String content;
	
	/*
	 * @Transient private MultipartFile f;
	 */
	
	@PrePersist //insert 전 자동호출
	public void makeDate() {
		wdate = new Date();
	}
}