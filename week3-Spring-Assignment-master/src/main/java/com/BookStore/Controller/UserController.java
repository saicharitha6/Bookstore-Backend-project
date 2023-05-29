package com.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.Model.User;
import com.BookStore.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService us;
	

	@PostMapping("/user")
	private  ResponseEntity<User> saveUser(@RequestBody User u){
		return ResponseEntity.ok().body(this.us.createUser(u));
	}
	
	@PutMapping("/user/{uid}")
	private  ResponseEntity<User> updateUser(@PathVariable int uid, @RequestBody User u){
		u.setUserId(uid);
		return ResponseEntity.ok().body(this.us.updateUser(u));
	}
	
	@GetMapping("/user/{uid}")
	private  User getUserById(@PathVariable int uid){
		return this.us.getUserById(uid);
	}
	
	@DeleteMapping("/user/{uid}")
	private HttpStatus deleteUser(@PathVariable int uid) {
		this.us.suspendUser(uid);
		return HttpStatus.OK;
	}
	
	@PutMapping("/user/addMoney/{uid}")
	 @ResponseStatus(HttpStatus.OK)
	private  void updateMoney(@PathVariable int uid, @RequestBody User u){
		us.addMoney(uid,u.getUserBalance());
	}
}
