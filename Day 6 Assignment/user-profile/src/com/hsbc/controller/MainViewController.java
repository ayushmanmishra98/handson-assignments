package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class MainViewController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		// This is getting service object
		UserService service = (UserService) UserFactory.getInstance(Type.SERVICE);
		int option = 0;
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Find User by id 4: Update PhoneNo. 5: Update Password 6: Exit");
			System.out.println("*****************************************************************************************");
			option = scanner.nextInt();
			switch(option) {
			case 1: 
				User user = new User();
				System.out.println("Enter name");		
				user.setName(scanner.next());
//				String name = scanner.next();
//				user.setName(name);
				
				System.out.println("Enter password");	
				user.setPassword(scanner.next());
				System.out.println("Enter phone no");	
				user.setPhone(scanner.nextLong());
				User createdUser = service.storeUser(user);
				System.out.println("User created with an id: "+createdUser.getUserId());
				break;
			case 2: 
				User[] users = service.getAllUsers();
				for(User temp : users) {
					if(temp!=null)
					System.out.println(temp);
				}
				break;
			case 3:
				System.out.println("Enter a id to search");
				try {
				User userFound=service.fetchUserById(scanner.nextInt());
				System.out.println(userFound);
				}catch(UserNotFoundException e) {
					System.err.println("Error : "+e.getMessage());//err prints in read color
				}
				break;
			case 4:
				System.out.println("Enter User Id and updated phone number to update phone No");
				try {
					int userId=scanner.nextInt();
					long newPhoneNo=scanner.nextLong();
					User updatePhone=service.updatePhoneNo(userId,newPhoneNo);
					System.out.println(updatePhone);
				}catch(UserNotFoundException e) {
					System.err.println("Error : "+e.getMessage());//err prints in read color
				}
				break;
			case 5:
				System.out.println("Enter User Id and password to update");
				try {
					int userId=scanner.nextInt();
					scanner.nextLine();
					String password=scanner.nextLine();
					User updatePawword=service.updatePassword(userId, password);
					System.out.println(updatePawword);
				}catch(UserNotFoundException e) {
					System.err.println("Error : "+e.getMessage());//err prints in read color
				}
				break;
			}
		} while(option != 6);
		
		scanner.close();
	}

}
