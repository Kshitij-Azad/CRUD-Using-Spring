package com.pro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	private int bookid;
	private String bookname;
	private int price;
	private String description;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookid, String bookname, int price, String description) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.description = description;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", price=" + price + ", description="
				+ description + "]";
	}
	
	
}
