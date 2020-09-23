package com.demo.controller;

import java.util.Scanner;

import com.demo.exception.UserNotFoundException;
import com.demo.model.bean.User;
import com.demo.model.service.ServiceLayer;
import com.demo.model.utility.Type;
import com.demo.model.utility.UserFactory;

public class ControllerMain {

	public static void main(String[] args) {
		ServiceLayer s1=(ServiceLayer) UserFactory.getInstance(Type.SERVICE);
		Scanner sc=new Scanner(System.in);
		int option=0;
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Find User by id 4: Update PhoneNo. 5: Update Password 6: Exit");
			System.out.println("*****************************************************************************************");
			option = sc.nextInt();
			switch (option) {
			case 1:
				User u=new User();
				u.setName(sc.next());
				u.setPassword(sc.next());
				u.setPhoneNo(sc.next());
				User u1=s1.store(u);
				System.out.println(u1.getUserId());
				break;
			case 2:
				User[] u2=s1.getAll();
				for(User t:u2) {
					if(t!=null)
						System.out.println(t);
				}
				break;
			case 3:
				try {
				User u3=s1.fetchById(sc.nextInt());
				System.out.println(u3);
				}catch(UserNotFoundException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					User u4=s1.updatePhone(sc.nextInt(),sc.next());
				}catch(UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}while(option!=5);
	}

}
