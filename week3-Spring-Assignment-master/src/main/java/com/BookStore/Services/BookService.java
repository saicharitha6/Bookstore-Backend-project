package com.BookStore.Services;

import java.util.List;

import com.BookStore.Model.Book;

public interface BookService {
	Book addBook(Book b);
	Book searchBook(int id);
	List<Book> searchAllBooks();
	//void addReview();
}
