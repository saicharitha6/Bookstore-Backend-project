package com.BookStore.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	private int orderId;
	private int userId;
	private int bookId;
	private String status; //yes=returned, no=not returned
	private LocalDate dateofRent;
	private LocalDate dateofReturn;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDateofReturn() {
		return dateofReturn;
	}
	public void setDateofReturn(LocalDate dateofReturn) {
		this.dateofReturn = dateofReturn;
	}
	public LocalDate getDateofRent() {
		return dateofRent;
	}
	public void setDateofRent(LocalDate dateofRent) {
		this.dateofRent = dateofRent;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", bookId=" + bookId + ", status=" + status
				+ ", dateofRent=" + dateofRent + ", dateofReturn=" + dateofReturn + "]";
	}
	
}
