package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;

public class userServiceImpl implements UserService {

	private UserDao userDao=null;
	public userServiceImpl() {
		userDao=(UserDao)UserFactory.getInstance("dao");
	}
	
	
	@Override
	public User login(int userId, String password) throws AuthenticationException {
		User user=userDao.authenticate(userId, password);
		if(user==null) {
			throw new AuthenticationException("Sorry something went wrong");//This error we will get when we lose connectivity to the server.
		}
		return user;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User userRegistered=userDao.userStore(user);
		return userRegistered;
	}

	@Override
	public User updatePhone(int userId, long phone) {
		// TODO Auto-generated method stub
		User found=null;
		List<User> all=userDao.fetchAllUsers();
		for(User u:all) {
			if(u.getUserId()==userId) {
				found=u;
				break;
			}
		}
		found.setPhone(phone);
		User updateUser=userDao.updateUser(userId,found);
		return updateUser;
	}

	@Override
	public User updatePassword(int userId, String password) {
		User found=null;
		List<User> all=userDao.fetchAllUsers();
		for(User u:all) {
			if(u.getUserId()==userId) {
				found=u;
				break;
			}
		}
		found.setPassword(password);
		User updateUser=userDao.updateUser(userId,found);
		return updateUser;
	}

	@Override
	public User getUser(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User found=null;
		List<User> all=userDao.fetchAllUsers();
		for(User u:all) {
			if(u.getUserId()==userId) {
				found=u;
				break;
			}
		}
		if(found==null) {
			throw new UserNotFoundException("Sorry User Does Not Exist.");
		}
		return found;
	}


	@Override
	public List<User> fetchAllUsers() {
		return userDao.fetchAllUsers();
	}



}
