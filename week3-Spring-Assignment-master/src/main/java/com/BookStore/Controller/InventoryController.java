package com.BookStore.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.Model.Inventory;
import com.BookStore.Services.InventoryService;

@RestController
public class InventoryController {
	@Autowired private InventoryService is;
	
	@PostMapping("/inventory")
	private  ResponseEntity<Inventory> addInv(@RequestBody Inventory i){
		return ResponseEntity.ok().body(this.is.addToInventory(i));
	}
	@GetMapping("/inventory/{bid}")
	private  Inventory getBook(@PathVariable int bid){
		return this.is.searchBook(bid);
	}
	
	@GetMapping("/sortByLikes")
	private ResponseEntity<List<String>> sortByLikes(){
		return ResponseEntity.ok().body(this.is.sortByLikes());
	}
	@GetMapping("/sortByDateAdded")
	private ResponseEntity<List<String>> sortByDate(){
		return ResponseEntity.ok().body(this.is.sortByDate());
	}
}
