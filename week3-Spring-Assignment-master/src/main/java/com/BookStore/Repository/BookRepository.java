package com.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookStore.Model.Book;


public interface BookRepository  extends JpaRepository<Book,Integer> {

}
