package com.university.feemanagement.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.university.feemanagement.entities.User;



public class CustomUserDetails implements UserDetails{

	private static final long serialVersionUID = -347716030959432733L;
	private User user;
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	  Collection<GrantedAuthority> authorities = new ArrayList<>();
	  SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
	  authorities.add(authority);
	  return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();	
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

