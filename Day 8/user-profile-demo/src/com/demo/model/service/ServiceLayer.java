package com.demo.model.service;

import com.demo.exception.UserNotFoundException;
import com.demo.model.bean.User;

public interface ServiceLayer {
	public User store(User user);
	public User[] getAll();
	public User fetchById(int id) throws UserNotFoundException;
	public User updatePhone(int id,String newPhoneNumber) throws UserNotFoundException;
		
}
