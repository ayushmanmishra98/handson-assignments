package com.hsbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hsbc.model.beans.User;
import com.hsbc.model.utility.DBUtility;

public class SelectQueryMain {
	public static void main(String[] args) {
		try {
			Connection connection=DBUtility.getConnection();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter name,password,phone number");
			String name=scanner.next();
			String password=scanner.next();
			long phone=scanner.nextLong();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			PreparedStatement insertStatement=connection.prepareStatement("insert into user_table values(?,?,?,?)");
			insertStatement.setInt(1,seq);//In first question mark insert userId
			insertStatement.setString(2,name);
			insertStatement.setString(3,password);
			insertStatement.setLong(4,phone);
			int resultSet=insertStatement.executeUpdate();
			List<User> list1=new ArrayList<User>();
			PreparedStatement selectStatement=connection.prepareStatement("select * from user_table");
			ResultSet selectQuery=selectStatement.executeQuery();
			while(selectQuery.next()) {
				User user=new User();
				user.setUserId(selectQuery.getInt("user_id"));
				user.setName(selectQuery.getString("name"));
				user.setPassword(selectQuery.getString("password"));
				user.setPhone(selectQuery.getLong("phone"));
				list1.add(user);
			}
			Iterator<User> iterator=list1.iterator();
			while(iterator.hasNext()) {
				User temp=iterator.next();
				System.out.println(temp);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
