package net.codejava;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawpassword = "admin2022";
		String encodedPassword = encoder.encode(rawpassword);
		System.out.println(encodedPassword);
	}

}
