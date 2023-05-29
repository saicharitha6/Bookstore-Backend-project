package com.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookStore.Model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
}
