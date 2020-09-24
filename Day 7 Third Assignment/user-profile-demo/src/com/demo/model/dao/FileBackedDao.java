package com.demo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.crypto.spec.DESedeKeySpec;

import com.demo.model.bean.User;

public class FileBackedDao implements UserDao {

	//private static List<User> list1=new ArrayList<User>();
	
	private List<User> userList=desrialize();
	
	private void serialize(List<User> usersList) {
		try {
			FileOutputStream fos=new FileOutputStream("users.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(usersList);
			fos.flush();
			oos.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//It has to read and return all the users from the file
	private List<User> desrialize(){
		try {
			FileInputStream fis=new FileInputStream("users.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			userList=(List<User>)ois.readObject();
			ois.close();
			fis.close();
		}catch(FileNotFoundException | EOFException e) {
			userList=new ArrayList<User>();
			serialize(userList);
		}
		catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/*private static List<User> list1=desril();
	
	private static List<User> desril() {
		try {
			FileInputStream fis=new FileInputStream("file1.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<User> list=(List<User>)ois.readObject();
			ois.close();
			fis.close();
			return list;
		}catch(FileNotFoundException e) {
		userList=new ArrayList<User>();
			serializable(userList);
		}
		catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
		}
		return null;
	}
	
	
	private static void serializable(List<User> l) {
		try {
			FileOutputStream fos=new FileOutputStream("file1.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			if(l!=null) {
			oos.writeObject(l);
			}
			fos.flush();
			oos.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}*/
	
	@Override
	public User storeUser(User user) {
		this.userList=desrialize();
		int generatedId=userList.size()+1;
		user.setUserId(generatedId);
		this.userList.add(user);
		serialize(this.userList);
		return user;
	}


	@Override
	public User[] getAllUser() {
		this.userList=desrialize();
		User[] allUser=new User[userList.size()];
		allUser=userList.toArray(allUser);
		return allUser;
	}

	@Override
	public User fetchId(int id) {
		User found=null;
		Iterator<User> it1=userList.iterator();
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

		Iterator<User> it1=userList.iterator();
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
