package com.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.Model.Orders;
import com.BookStore.Services.OrderService;

@RestController
public class OrderController {
	@Autowired private OrderService os;
	
	@PostMapping("/orders")
	private  ResponseEntity<Orders> saveOrder(@RequestBody Orders o){
		return ResponseEntity.ok().body(this.os.addOrder(o));
	}
	@PutMapping("/return/{oid}")
	private  ResponseEntity<String> returnOrder(@PathVariable int oid){
		this.os.returnOrder(oid);
		return ResponseEntity.ok().body("Successfully returned...");
	}
	
	@GetMapping("/transaction/{uid}")
	private  ResponseEntity<List<String>> returnUserTrans(@PathVariable int uid){
		
		return ResponseEntity.ok().body(this.os.returnUserTransaction(uid));
	}
	@GetMapping("/transactions")
	private  ResponseEntity<List<String>> returnAllTrans(){
		
		return ResponseEntity.ok().body(this.os.returnAllTransaction());
	}
}
