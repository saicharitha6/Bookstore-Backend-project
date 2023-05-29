package com.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.Model.Book;

import com.BookStore.Services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bs;
	
	@PostMapping("/books")
	private  ResponseEntity<Book> saveBook(@RequestBody Book b){
		return ResponseEntity.ok().body(this.bs.addBook(b));
	}
	@GetMapping("/books")
	private  List<Book> getAllBooks(){
		return this.bs.searchAllBooks();
	}
	@GetMapping("/books/{bid}")
	private  ResponseEntity<Book> getBook(@PathVariable int bid){
		return ResponseEntity.ok(this.bs.searchBook(bid));
	}
}
