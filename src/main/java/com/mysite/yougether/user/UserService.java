package com.mysite.yougether.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public SiteUser create(String username, String password, String email) {
	
		SiteUser user=new SiteUser();
			user.setUsername(username);
			user.setEmail(email);
			
			//BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();   // SecurityConfig클래스에서 정의
			user.setPassword(passwordEncoder.encode(password));
			this.userRepository.save(user);
			
			return user;
	}
}
