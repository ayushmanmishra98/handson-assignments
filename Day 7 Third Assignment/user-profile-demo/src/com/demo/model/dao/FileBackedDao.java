package com.demo.model.dao;

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
	
	
	private static List<User> list1=desrialize();
	
	public static List<User> desrialize() {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis=new FileInputStream("fildedb1.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<User> list=(List<User>)ois.readObject();
			ois.close();
			fis.close();
			return list;
		}catch(FileNotFoundException e) {
			serialize(null);
			System.out.println("File not present.");
		}
		catch(IOException e) {
			System.out.println("Error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void serialize(User user) {
		try {
		FileOutputStream fos=new FileOutputStream("fildedb1.ser");//Any extension
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		if(user!=null) {
		oos.writeObject(user);
		fos.flush();
		oos.close();
		fos.close();
		}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public User storeUser(User user) {
		list1.add(user);
		serialize(user);
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
