package com.anilnayak.springboot.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
		System.out.println(encoder.encode("t123"));
		System.out.println("$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q");
	}
}