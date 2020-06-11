/**
 * 
 */
package com.jogsoft.apps.pnr.authservice.config;

import com.jogsoft.apps.pnr.authservice.domain.User;
import com.jogsoft.apps.pnr.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @author Julius Oduro
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		User foundUser = user.orElseThrow(() -> new UsernameNotFoundException("User with userName: " + username + " not found"));

		return new org.springframework.security.core.userdetails.User(foundUser.getUserName(),
				foundUser.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority(foundUser.getRole())));
	}

}
