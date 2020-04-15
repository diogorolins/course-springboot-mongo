package com.diogorolins.wsmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String Text;
	private Date date;
	private AuthorDTO author;
	
	public CommentDTO() {
		
	}

	public CommentDTO(String text, Date date, AuthorDTO author) {
		super();
		Text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
