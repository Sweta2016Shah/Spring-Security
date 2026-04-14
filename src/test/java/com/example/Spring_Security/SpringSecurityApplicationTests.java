package com.example.Spring_Security;

import com.example.Spring_Security.entities.User;
import com.example.Spring_Security.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

//	@Test
//	void contextLoads() {
//		User user= new User(4L, "sweta@gmail.com", "123");
//		String token =jwtService.generateToken(user);
//		System.out.println(token);
//
//		long id = jwtService.getUserIdFromToken(token);
//
//		System.out.println(id);
//	}

}
