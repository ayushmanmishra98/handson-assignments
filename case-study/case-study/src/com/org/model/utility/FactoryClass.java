package com.org.model.utility;

import com.org.model.dao.ProfileDaoImpl;
import com.org.model.service.ProfileServiceImpl;

public class FactoryClass {
		public static Object getInstance(Type type) {
			switch(type) {
			case DAO:
				return new ProfileDaoImpl();
			case SERVICE:
				return new ProfileServiceImpl();
			}
			return null;
		}
}
