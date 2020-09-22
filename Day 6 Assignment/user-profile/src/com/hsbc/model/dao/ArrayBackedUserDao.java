package com.hsbc.model.dao;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;

public class ArrayBackedUserDao implements UserDao {

	// temporary database
	private static User[] userArray = new User[10];
	
	private static int index = 0;
	
	@Override
	public User store(User user) {
		userArray[index++] = user;
		return user;
	}
	@Override
	public User[] fetchUsers() {
		return userArray;
	}
	
	@Override
	public User fetchUserById(int userId){
		
		User user=null;
		for(int i=0;i<index;i++) {
			if(userArray[i].getUserId()==userId) {//query sql
				user=userArray[i];
				return user;
			}
		}
		return null;
		//throw new UserNotFoundException("User Record with an id "+userId+" not found");//this is same as return only returns error
		
		//Dao can raise some connection error. 
		/*for(User temp:userArray) {
			if(temp.getUserId()==userId) {
				fetched=temp;
				break;
			}
		}
		if(fetched==null) {
			throw new UserNotFoundException("User Id not present in database");
		}
		return fetched;*/
	}
	@Override
	public User updateUser(int userId, User user) {
		for(int i=0;i<index;i++) {
			if(userArray[i].getUserId()==userId) {
				userArray[i]=user;
			}
		}
		return user;
	}

}
