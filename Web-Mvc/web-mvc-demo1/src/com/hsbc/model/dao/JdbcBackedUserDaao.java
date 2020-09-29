package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedUserDaao implements UserDao{

	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user=null;
		try {
			Connection connection=DBUtility.getConnection();
			String loginQuery="select * from user_table where user_id=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1,userId);
			preparedStatement.setString(2,password);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				user=new User();
				user.setUserId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setPhone(resultSet.getLong(4));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if(user==null) {
				throw new AuthenticationException("Sorry Username or Password is incorrect.");//This throws error directly.
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

	@Override
	public User userStore(User user) {
		// TODO Auto-generated method stub
		try {
		Connection connection=DBUtility.getConnection();
		PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
		ResultSet rs = sequenceStatement.executeQuery();
		int seq = 0;
		if(rs.next()) {
			seq = rs.getInt(1);
		} 
		PreparedStatement insertStatement=connection.prepareStatement("insert into user_table values(?,?,?,?)");
		insertStatement.setInt(1,seq);//In first question mark insert userId
		insertStatement.setString(2,user.getName());
		insertStatement.setString(3,user.getPassword());
		insertStatement.setLong(4,user.getPhone());
		int resultSet=insertStatement.executeUpdate();
		sequenceStatement.close();
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
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		List<User> all=new ArrayList<User>();
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement selectStatement=connection.prepareStatement("select * from user_table");
			ResultSet selectQuery=selectStatement.executeQuery();
			while(selectQuery.next()) {
				User user=new User();
				user.setUserId(selectQuery.getInt("user_id"));
				user.setName(selectQuery.getString("name"));
				user.setPassword(selectQuery.getString("password"));
				user.setPhone(selectQuery.getLong("phone"));
				all.add(user);
			}
			selectStatement.close();
			selectQuery.close();
			connection.close();
		}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return all;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement updateStatement=connection.prepareStatement("update user_table set phone=?,password=? where user_id=?");
			String phone=Long.toString(user.getPhone());
			updateStatement.setString(1,phone);
			updateStatement.setString(2,user.getPassword());
			updateStatement.setInt(3,userId);
			int resultSet=updateStatement.executeUpdate();
			updateStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
