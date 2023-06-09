package com.makun.web.jsp;

import java.sql.Date;

public class A005notice {
	private int id;
	private String title ;
	private Date regdate ;
	private String writer_id;
	private int hit ;
	private String files;
	private String content;
	
	public A005notice() {
		this.title = "";
		this.regdate = null;
		this.writer_id = "";
		this.hit = 0;
		this.files = "";
		this.content = "";
		
	}
	public A005notice(String title, Date regdate, String writer_id, int hit, String files, String content) {

		this.title = title;
		this.regdate = regdate;
		this.writer_id = writer_id;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}
	
	public A005notice(int id, String title, Date regdate, String writer_id, int hit, String files, String content) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.writer_id = writer_id;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
