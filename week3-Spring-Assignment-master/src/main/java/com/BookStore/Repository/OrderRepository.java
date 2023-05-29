package com.BookStore.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BookStore.Model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	@Query(value = "Select * from bookstore.orders o where o.user_id=?1", nativeQuery = true)
	List<Orders> findNoOfUsers(int user_id);
	
	@Query(value = "Select * from bookstore.orders o", nativeQuery = true)
	List<Orders> findAllTransaction();
}
