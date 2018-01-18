package com.anilnayak.springboot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anilnayak.springboot.dao.IUserInfoDAO;
import com.anilnayak.springboot.model.UserInfo;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserInfoDAO userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
		UserDetails userDetails = (UserDetails) new User(activeUserInfo.getUserName(), activeUserInfo.getPassword(),
				Arrays.asList(authority));
		System.out.println("Password::::"+activeUserInfo.getPassword());
		return userDetails;
	}
}