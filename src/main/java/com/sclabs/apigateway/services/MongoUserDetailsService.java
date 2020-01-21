package com.sclabs.apigateway.services;

import com.sclabs.apigateway.models.Users;
import com.sclabs.apigateway.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService {
  @Autowired
  private UsersRepository repository;

  @Override
  public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
    final Users user = repository.findByUsername(email);
    if (user == null) {
      throw new UsernameNotFoundException("User Not found");
    }
    final List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
    return new User(user.getUsername(), user.getPassword(), authorities);
  }
}