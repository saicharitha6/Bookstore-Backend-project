package com.BookStore.Services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BokStore.Exception.UserException;
import com.BookStore.Model.Book;
import com.BookStore.Model.Inventory;
import com.BookStore.Model.Orders;
import com.BookStore.Model.User;
import com.BookStore.Repository.BookRepository;
import com.BookStore.Repository.InventoryRepository;
import com.BookStore.Repository.OrderRepository;
import com.BookStore.Repository.UserRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired private OrderRepository or;
	@Autowired private UserRepository ur;
	@Autowired private BookRepository br;
	@Autowired private InventoryRepository ir;
	@Autowired private UserService us;
	@Autowired private InventoryService is;
	
	public Orders addOrder(Orders o) {
		Optional<User> userDetail=this.ur.findById(o.getUserId());
		Optional<Book> bookDetail=this.br.findById(o.getBookId());
		Optional<Inventory> invDetail=this.ir.findById(o.getBookId());
		if(userDetail.isPresent()) {
			User userObj= userDetail.get();
			Book bookObj= bookDetail.get();
			Inventory invObj= invDetail.get();
			
			System.out.println(userObj);System.out.println(bookObj);System.out.println(invObj);
			
			double balance=userObj.getUserBalance();
			double bookPrice=bookObj.getBookPrice();
			if((bookPrice*0.2)>balance) throw new UserException("Balance is low...");
			else {
				if(invObj.getBookCount()<=0) throw new UserException("Book is Out of Stock...");
				else {
					List<Orders> users=this.or.findNoOfUsers(userObj.getUserId());
					if(users.size()>2) throw new UserException("Your Bag is Full, Can't Add...");
					else {
						for(Orders u:users) {
							int bookId=u.getBookId();
							if(u.getDateofReturn()==null && bookId==bookObj.getBookId()) throw new UserException("Already ordered...");
						}
						this.us.deductMoney(userObj.getUserId(), bookPrice*0.2);
						this.is.borrowBook(bookObj.getBookId());
					}
				}
			}
		}
		return this.or.save(o);
	}
	public void returnOrder(int oid) {
		Optional<Orders> orderDetail=this.or.findById(oid);
		if(! orderDetail.isPresent()) throw new UserException("No such order....");
		Orders o=orderDetail.get();
		Optional<User> userDetail=this.ur.findById(o.getUserId());
		Optional<Book> bookDetail=this.br.findById(o.getBookId());
		Optional<Inventory> invDetail=this.ir.findById(o.getBookId());
		if(userDetail.isPresent()) {
			User userObj= userDetail.get();
			Book bookObj= bookDetail.get();
			Inventory invObj= invDetail.get();
			
			double balance=userObj.getUserBalance();
			double bookPrice=bookObj.getBookPrice();
			userObj.setUserBalance(balance+(0.1*bookPrice));
			invObj.setBookCount(invObj.getBookCount()+1);
			o.setDateofReturn(LocalDate.now());
			o.setStatus("Yes");
		}
	}
	public List<String> returnUserTransaction(int uid) {
		List<String> transac=new ArrayList<>();
		List<Orders> users=this.or.findNoOfUsers(uid);
		for(Orders o:users) {
			transac.add(o.toString());
		}
		return transac;
	}
	public List<String> returnAllTransaction() {
		List<String> transac=new ArrayList<>();
		List<Orders> users=this.or.findAllTransaction();
		for(Orders o:users) {
			transac.add(o.toString());
		}
		return transac;
	}
}
