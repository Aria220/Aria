package com.yixutech.library.entity;

import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {

	private static final long serialVersionUID = -7522698106869895237L;

	private Long id;
	private Long bookId;
	private Long userId;
	private Date borrowTime;
	private Date returnTime;

	public Borrow() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", bookId=" + bookId + ", userId=" + userId + ", borrowTime=" + borrowTime
				+ ", returnTime=" + returnTime + "]";
	}

}
