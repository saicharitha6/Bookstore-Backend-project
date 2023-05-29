package com.BookStore.Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	@Id
	@Column(name="book_id")
	private int bookId;
	@Column(name="book_count")
	private long bookCount;
	@Column(name="book_likes")
	private int bookLikes;
	@Column(name="book_date_added")
	private Date bookDateAdded;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public long getBookCount() {
		return bookCount;
	}
	public void setBookCount(long bookCount) {
		this.bookCount = bookCount;
	}
	public int getBookLikes() {
		return bookLikes;
	}
	public void setBookLikes(int bookLikes) {
		this.bookLikes = bookLikes;
	}
	public Date getBookDateAdded() {
		return bookDateAdded;
	}
	public void setBookDateAdded(Date bookDateAdded) {
		this.bookDateAdded = bookDateAdded;
	}
	@Override
	public String toString() {
		return "Inventory [bookId=" + bookId + ", bookCount=" + bookCount + ", bookLikes=" + bookLikes
				+ ", bookDateAdded=" + bookDateAdded + "]";
	}
	
	
}
