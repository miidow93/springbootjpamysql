package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long Id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="pages")
	private int pages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		this.Id = id;
	}

	public Book(String title, int pages) {
		super();
		this.title = title;
		this.pages = pages;
	}
	
	public Book() {}
	
	@Override
	public String toString() {
		return "Book { id = " + Id + ", title = " + title + ", pages = " + pages + " } " ;
	}
}
