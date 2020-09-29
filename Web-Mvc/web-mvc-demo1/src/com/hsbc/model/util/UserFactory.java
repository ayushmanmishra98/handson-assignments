package com.hsbc.model.util;

import com.hsbc.model.dao.JdbcBackedUserDaao;
import com.hsbc.model.service.userServiceImpl;

public class UserFactory {
	public static Object getInstance(String type) {
		if(type.equals("dao")) {
			return new JdbcBackedUserDaao();
		}		
		if(type.equals("service")) {
			return new userServiceImpl();
		}
		return null;
	}
}
