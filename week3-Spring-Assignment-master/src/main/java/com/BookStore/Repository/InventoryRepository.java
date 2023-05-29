package com.BookStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BookStore.Model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory,Integer>{
	@Query(value="Select * from Inventory i order by book_likes desc",nativeQuery = true)
	List<Inventory> sortByLikes();
	@Query(value="Select * from Inventory i order by book_date_added desc",nativeQuery = true)
	List<Inventory> sortByDate();
}
