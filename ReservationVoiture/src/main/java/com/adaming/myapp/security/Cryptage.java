package com.adaming.myapp.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Cryptage {

	public static void main(String[] args) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(12);
		System.out.println(bc.encode("thomas"));
	}
}
