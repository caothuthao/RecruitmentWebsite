package com.vti.mock.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DataUtils {

	private DataUtils() {
	}

	public static String genBcryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	public static void main(String[] args) {
		System.out.println("BCrypt hash: " + genBcryptPassword("123456"));
	}

}
