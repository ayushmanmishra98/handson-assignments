package com.demo.model.dao;

import com.demo.model.bean.User;

public interface UserDao {
	public User storeUser(User user);
	public User[] getAllUser();
	public User fetchId(int id);
	public User update(int id,User user);
}
