package com.BookStore.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	private long bookIsbn;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String category;
	
	public long getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
//	@OneToMany
//	private List<Reviews> review;
//	
//	public List<Reviews> getReview() {
//		return review;
//	}
//	public void setReview(List<Reviews> review) {
//		this.review = review;
//	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		
		return "Book [bookIsbn=" + bookIsbn + ", bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor="
				+ bookAuthor + ", bookPrice=" + bookPrice + ", category=" + category + "]";
	}
	
}
