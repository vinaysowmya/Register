package PasswordEncrypter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public String generator(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String changedPassword = passwordEncoder.encode(password);
		System.out.println(changedPassword);
		return changedPassword;

	}
}
