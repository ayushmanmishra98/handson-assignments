package com.demo.model.dao;

import com.demo.model.bean.User;

public class ArrayBackedUser implements UserDao{

	private static User[] u=new User[10];
	
	private static int counter=0;
	
	@Override
	public User storeUser(User user) {
		u[counter++]=user;
		return user;
	}

	@Override
	public User[] getAllUser() {
		return u;
	}

	@Override
	public User fetchId(int id) {
		User r=null;
		for(int i=0;i<counter;i++) {
			if(u[i].getUserId()==id) {
				r=u[i];
				break;
			}
		}
		return r;
	}

	@Override
	public User update(int id, User user) {
		for(int i=0;i<counter;i++) {
			if(u[i].getUserId()==id) {
				u[i]=user;
				break;
			}
		// TODO Auto-generated method stub
	}
		return user;
	
}

}