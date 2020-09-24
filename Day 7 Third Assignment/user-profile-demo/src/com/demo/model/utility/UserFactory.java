package com.demo.model.utility;

import com.demo.model.dao.ArrayBackedUser;
import com.demo.model.dao.CollectionBackedUserDao;
import com.demo.model.dao.FileBackedDao;
import com.demo.model.service.ServiceLayerImpl;

public class UserFactory {
	public static Object getInstance(Type type) {
		Object obj=null;
		switch(type) {
		case DAO:
			//obj=new ArrayBackedUser();
			//obj=new CollectionBackedUserDao();
			obj=new FileBackedDao();
			break;
		case SERVICE:
			obj=new ServiceLayerImpl();
			break;
		}
		return obj;
	}
}
