package com.springboot.bankapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.bankapp.model.Role;
import com.springboot.bankapp.model.UserInfo;
import com.springboot.bankapp.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
				UserInfo myUser = userRepository.findByUsername(username);				 
				Role role = myUser.getRole();
				List<GrantedAuthority> authorities = new ArrayList<>();
				SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role.getName());
				authorities.add(sga);
			    return new User(myUser.getUsername(), myUser.getPassword(), authorities);
	}

}