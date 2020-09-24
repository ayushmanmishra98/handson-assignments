package com.demo.model.service;

import com.demo.exception.UserNotFoundException;
import com.demo.model.bean.User;
import com.demo.model.dao.UserDao;
import com.demo.model.utility.Type;
import com.demo.model.utility.UserFactory;

public class ServiceLayerImpl implements ServiceLayer{
	
	UserDao dao;
	public ServiceLayerImpl() {
		dao=(UserDao)UserFactory.getInstance(Type.DAO);
	}

	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		User u=dao.storeUser(user);
		return u;
	}

	@Override
	public User[] getAll() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	@Override
	public User fetchById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User u=dao.fetchId(id);
		if(u==null)
			throw new UserNotFoundException("Not Found");			
		return u;
	}

	@Override
	public User updatePhone(int id,String newPhoneNumber) throws UserNotFoundException {
		User u=fetchById(id);
		if(u==null)
			throw new UserNotFoundException("Not Found");
		u.setPhoneNo(newPhoneNumber);
		dao.update(id,u);
		return u;
	}

}
