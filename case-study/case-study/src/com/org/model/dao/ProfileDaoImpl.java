package com.org.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.model.utility.DBUtility;
import com.org.exception.AuthenticationException;
import com.org.exception.NotFound;
import com.org.model.beans.Contact;
import com.org.model.beans.Profile;

public class ProfileDaoImpl implements ProfileDao{

	
	
	
	@Override
	public Profile store(Profile profile) {
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for profile_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			PreparedStatement insertStatement=connection.prepareStatement("insert into Profile values(?,?,?,?,?)");
			insertStatement.setInt(1,seq);
			profile.setProfileId(seq);
			insertStatement.setString(2,profile.getName());
			insertStatement.setString(3,profile.getPassword());
			insertStatement.setLong(4,profile.getPhoneNo());
			insertStatement.setString(5,profile.getDOB());
			int resultSet=insertStatement.executeUpdate();
			sequenceStatement.close();
			insertStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return profile;
	}
	
	@Override
	public Profile authenticate(int id, String password) throws AuthenticationException {
		Profile profile=null;
		try {
			Connection connection=DBUtility.getConnection();
			String loginQuery="select * from profile where profile_id=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,password);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				profile=new Profile();
				profile.setProfileId(resultSet.getInt(1));
				profile.setName(resultSet.getString(2));
				profile.setPassword(resultSet.getString(3));
				profile.setPhoneNo(resultSet.getLong(4));
				profile.setDOB(resultSet.getString(5));
				return profile;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if(profile==null) {
				throw new AuthenticationException("Sorry Username or Password is incorrect.");
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return profile;
		
	}

	@Override
	public List<Profile> getAll() {
		List<Profile> all=new ArrayList<Profile>();
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement selectStatement=connection.prepareStatement("select * from Profile");
			ResultSet selectQuery=selectStatement.executeQuery();
			while(selectQuery.next()) {
				Profile profile=new Profile();
				profile.setProfileId(selectQuery.getInt("profile_id"));
				profile.setName(selectQuery.getString("name"));
				profile.setPassword(selectQuery.getString("password"));
				profile.setPhoneNo(selectQuery.getLong("phonenumber"));
				profile.setDOB(selectQuery.getString("dob"));
				all.add(profile);
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
	public Profile updateProfile(int id, Profile profile) {
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement updateStatement=connection.prepareStatement("update profile set phonenumber=?,password=?,dob=? where profile_id=?");
			String phone=Long.toString(profile.getPhoneNo());
			updateStatement.setString(1,phone);
			updateStatement.setString(2,profile.getPassword());
			updateStatement.setString(3,profile.getDOB());
			updateStatement.setInt(4,id);
			int resultSet=updateStatement.executeUpdate();
			updateStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return profile;
	}

	@Override
	public Contact addContact(int id,Contact contact){
		
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for contact_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			PreparedStatement insertStatement=connection.prepareStatement("insert into profile_contacts values(?,?,?,?)");
			insertStatement.setInt(1,seq);
			contact.setId(seq);
			insertStatement.setString(2,contact.getName());
			insertStatement.setLong(3,contact.getPhone());
			insertStatement.setInt(4,id);
			int resultSet=insertStatement.executeUpdate();
			insertStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public List<Contact> getAllContact(int id) {
		List<Contact> all=new ArrayList<Contact>();
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement selectStatement=connection.prepareStatement("select * from profile_contacts where profile_id=?");
			selectStatement.setInt(1,id);
			ResultSet selectQuery=selectStatement.executeQuery();
			while(selectQuery.next()) {
				Contact contact=new Contact();
				contact.setId(selectQuery.getInt(1));
				contact.setName(selectQuery.getString(2));
				contact.setPhone(selectQuery.getLong(3));				
				all.add(contact);
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
	public Contact get(int id, int contactId) {
		Contact contact=null;
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement selectStatement=connection.prepareStatement("select * from profile_contacts where id=? and profile_id=?");
			selectStatement.setInt(1,contactId);
			selectStatement.setInt(2,id);
			ResultSet selectQuery=selectStatement.executeQuery();
			while(selectQuery.next()) {
				contact=new Contact();
				contact.setId(selectQuery.getInt(1));
				contact.setName(selectQuery.getString(2));
				contact.setPhone(selectQuery.getLong(3));				
			}
			selectStatement.close();
			selectQuery.close();
			connection.close();
		}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return contact;
	}

	@Override
	public int delete(int id, int convertId) throws NotFound {
		int flag=0;
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement deleteStatement=connection.prepareStatement("delete from profile_contacts where id=? and profile_id=?");
			deleteStatement.setInt(1,convertId);
			deleteStatement.setInt(2,id);
			int resultSet=deleteStatement.executeUpdate();
			if(resultSet==0) {
				flag=0;
			}
			else {
				flag=1;
			}
			System.out.println(resultSet);
			deleteStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteProfile(int id) throws NotFound {
		int flag=0;
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement deleteStatement=connection.prepareStatement("delete from profile_contacts where profile_id=?");
			deleteStatement.setInt(1,id);
			int resultSet=deleteStatement.executeUpdate();
			deleteStatement.close();
			PreparedStatement deleteStatement2=connection.prepareStatement("delete from profile where profile_id=?");
			deleteStatement2.setInt(1,id);
			int resultSet2=deleteStatement2.executeUpdate();
			if(resultSet!=0 & resultSet2 !=0) {
				flag=1;
			}
			else {
				flag=0;
			}
			deleteStatement2.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Contact updateContact(int profileId, int contactId, Contact found) {
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement updateStatement=connection.prepareStatement("update profile_contacts set name=?,phone=? where id=? and profile_id=?");
			String phone=Long.toString(found.getPhone());
			updateStatement.setString(1,found.getName());
			updateStatement.setString(2,phone);
			updateStatement.setInt(3,contactId);
			updateStatement.setInt(4,profileId);
			int resultSet=updateStatement.executeUpdate();
			updateStatement.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

}
