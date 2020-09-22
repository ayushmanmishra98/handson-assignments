package com.hsbc.model.utility;

import com.hsbc.model.dao.ArrayBankUserDao;
import com.hsbc.model.service.AccountServiceImpl;

public class UserFactory {
	public static Object getInstance(Type type) {
		Object obj=null;
		switch (type) {
		case DAO:
			obj=new ArrayBankUserDao();
			break;
		case SERVICE:
			obj=new AccountServiceImpl();
			break;
		}
		return obj;
	}
}
