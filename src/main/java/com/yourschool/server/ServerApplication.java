package com.yourschool.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		
		String encode = new BCryptPasswordEncoder().encode("test");
		System.out.println("\n\n\n\n\n");
		System.out.println(encode);
		System.out.println("\n\n\n\n\n");
		
		SpringApplication.run(ServerApplication.class, args);
		
		int d= 3; 
		int b = d++; 
	}

}


























