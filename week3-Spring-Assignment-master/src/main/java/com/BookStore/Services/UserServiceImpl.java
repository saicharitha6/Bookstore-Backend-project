package com.BookStore.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BokStore.Exception.UserException;
import com.BookStore.Model.User;
import com.BookStore.Repository.UserRepository;



@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository ur;
	@Override
	public User createUser(User u) {
		return ur.save(u);
	}

	@Override
	public void suspendUser(int id) {
		Optional<User> user=this.ur.findById(id);
		if(user.isPresent()) {
			this.ur.deleteById(id);
		}
		else throw new UserException("User is not found");
	}

	@Override
	public User updateUser(User u) {
		Optional<User> users=this.ur.findById(u.getUserId());
		if(users.isPresent()) {
			User newUser=users.get();
			newUser.setUserId(u.getUserId());
			newUser.setUserName(u.getUserName());
			newUser.setUserEmail(u.getUserEmail());
			newUser.setUserContact(u.getUserContact());
			newUser.setUserBalance(u.getUserBalance());
			return this.ur.save(newUser);
		}
		else throw new UserException("User is not found");
	}
	
	@Override
	public void addMoney(int uid, double moneyToAdd) {
		if(moneyToAdd%500!=0) throw new UserException("Enter the amount in the multiples of 500...");
		 Optional<User> user=this.ur.findById(uid);
		 if(user.isPresent()) {
			User newUser=user.get();
			double totalAfterAdding = newUser.getUserBalance() + moneyToAdd;
			newUser.setUserBalance(totalAfterAdding);
			ur.save(newUser);
	}
		 else throw new UserException("User is not found");
	}

	@Override
	public User getUserById(int u) {
		Optional<User> user=this.ur.findById(u);
		if(user.isPresent()) return user.get();
		else throw new UserException("User is not found");
	}

	@Override
	public void deductMoney(int uid, double moneyToDeduct) {
		Optional<User> user=this.ur.findById(uid);
			User newUser=user.get();
			double totalAfterDeducting = newUser.getUserBalance() - moneyToDeduct;
			newUser.setUserBalance(totalAfterDeducting);
			ur.save(newUser);		
	}
}
