package com.BookStore.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BokStore.Exception.UserException;
import com.BookStore.Model.Inventory;
import com.BookStore.Repository.InventoryRepository;

@Service
@Transactional
public class InventoryService {
	@Autowired private InventoryRepository ir;
	
	public Inventory addToInventory(Inventory i) {
		return this.ir.save(i);
	}

	public Inventory searchBook(int bid) {
		Optional<Inventory> inv=this.ir.findById(bid);
		if(inv.isPresent()) return inv.get();
		else throw new UserException("User is not found");
	}
	
	public void borrowBook(int bid) {
		Optional<Inventory> inventory=this.ir.findById(bid);
		Inventory inv=inventory.get();
		long newCount=inv.getBookCount()-1;
		inv.setBookCount(newCount);
		ir.save(inv);		
	}
	public List<String> sortByLikes(){
		List<String> likes=new ArrayList<>();
		List<Inventory> inv=this.ir.sortByLikes();
		for(Inventory i:inv) {
			likes.add(i.toString());
		}
		return likes;
	}
	public List<String> sortByDate(){
		List<String> dates=new ArrayList<>();
		List<Inventory> inv=this.ir.sortByDate();
		for(Inventory i:inv) {
			dates.add(i.toString());
		}
		return dates;
	}
}
