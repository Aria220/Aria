package com.yixutech.library.entity;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = -8034549921199160968L;

	private Long id;
	private String name;
	private String author;
	private Integer amount;
	private Integer borrowCount;

	public Book() {
		super();
	}

	public Book(String name, String author, Integer amount, Integer borrow_count) {
		super();
		setName(name);
		setAuthor(author);
		setAmount(amount);	
		setBorrowCount(borrow_count);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getBorrowCount() {
		return borrowCount;
	}

	public void setBorrowCount(Integer borrowCount) {
		this.borrowCount = borrowCount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", amount=" + amount + ", borrow_count="
				+ borrowCount + "]";
	}

}
