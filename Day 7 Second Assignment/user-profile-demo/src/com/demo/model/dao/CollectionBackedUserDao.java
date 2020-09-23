package com.demo.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.demo.model.bean.User;

public class CollectionBackedUserDao implements UserDao {

	private static List<User> list1=new ArrayList<User>();
	
	
	
	@Override
	public User storeUser(User user) {
		// TODO Auto-generated method stub
		list1.add(user);
		return user;
	}

	@Override
	public User[] getAllUser() {
		User[] allUser=new User[list1.size()];
		allUser=list1.toArray(allUser);
		return allUser;
	}

	@Override
	public User fetchId(int id) {
		User found=null;
		/*User[] allUser=getAllUser();
		for(int i=0;i<allUser.length;i++) {
			if(allUser[i].getUserId()==id) {
				found=allUser[i];
				break;
			}
		}*/
		Iterator<User> it1=list1.iterator();
		while(it1.hasNext()) {
		User u=it1.next();
		if(u.getUserId()==id) {
			found=u;
			break;
		}
		}
		return found;
	}

	@Override
	public User update(int id, User user) {
		/*User[] allUser=getAllUser();
		for(int i=0;i<allUser.length;i++) {
			if(allUser[i].getUserId()==id) {
				allUser[i]=user;
				break;
			}
		}*/
		Iterator<User> it1=list1.iterator();
		while(it1.hasNext()) {
		User u=it1.next();
		if(u.getUserId()==id) {
			u=user;
			break;
		}
		}
		return user;
	}

}