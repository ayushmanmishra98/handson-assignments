package com.demo.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.demo.exception.UserNotFoundException;
import com.demo.model.bean.User;
import com.demo.model.utility.DBUtility;

public class JDBCBackedUserDao implements UserDao {
	
	
	private List<User> list=getList();
	
	
	public List<User> getList() {
	try {
		Connection connection=DBUtility.getConnection();
		PreparedStatement selectStatement=connection.prepareStatement("select * from user_impl");
		ResultSet selectQuery=selectStatement.executeQuery();
		list=new ArrayList<User>();
		while(selectQuery.next()) {
			User user=new User();
			user.setUserId(selectQuery.getInt("user_id"));
			user.setName(selectQuery.getString("name"));
			user.setPassword(selectQuery.getString("password"));
			user.setPhoneNo(selectQuery.getString("phone"));
			list.add(user);
		}
		selectStatement.close();
		connection.close();
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
	}


	@Override
	public User storeUser(User user) {
		// TODO Auto-generated method stub
		//int generatedId=list.size()+1;
		//user.setUserId(generatedId);
		list.add(user);
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq==0) {
				System.out.println("Invalid id");
				return null;
			}
			//PreparedStatement insertStatement=connection.prepareStatement("insert into user_impl values(next value for user_seq,?,?,?)");
			//insertStatement.setInt(1,user.getUserId());//In first question mark insert userId
			PreparedStatement insertStatement=connection.prepareStatement("insert into user_impl values(?,?,?,?)");
			insertStatement.setInt(1, seq);
			insertStatement.setString(2,user.getName());
			insertStatement.setString(3,user.getPassword());
			insertStatement.setString(4,user.getPhoneNo());
			int resultSet=insertStatement.executeUpdate();
			System.out.println("User created with an id = "+seq);
			insertStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User[] getAllUser() {
		list=getList();
		User[] allUser=new User[list.size()];
		allUser=list.toArray(allUser);
		return allUser;
	}

	@Override
	public User fetchId(int id) {
		User found=null;
		Iterator<User> it1=list.iterator();
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
		Iterator<User> it1=list.iterator();
		while(it1.hasNext()) {
		User u=it1.next();
		if(u.getUserId()==id) {
			u=user;
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update user_impl set phone=? where user_id=?");
				updateStatement.setString(1,u.getPhoneNo());
				updateStatement.setInt(2,id);
				int resultSet=updateStatement.executeUpdate();
				updateStatement.close();
				connection.close();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		}
		return user;
	}
}
