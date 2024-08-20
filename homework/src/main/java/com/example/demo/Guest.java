package com.example.demo;

public class Guest {
	private int id;
	private String writer;
	private String pwd;
	private String wdate;
	private String content ;
	
	public Guest () {}
	public Guest(int id, String writer, String pwd, String wdate, String content ) {
		super();
		this.id = id;
		this.writer = writer;
		this.pwd = pwd;
		this.wdate = wdate;
		this.content  = content ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getContent() {
		return content ;
	}
	public void setContent(String content ) {
		this.content  = content ;
	}
	
	@Override
	public String toString() {
		return "Guest [id=" + id + ", writer=" + writer + ", pwd=" + pwd + ", wdate=" + wdate + ", content=" + content
				+ "]";
	}
	
	

}
