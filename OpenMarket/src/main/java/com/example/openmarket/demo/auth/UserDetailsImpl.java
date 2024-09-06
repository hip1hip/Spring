package com.example.openmarket.demo.auth;

import com.example.openmarket.demo.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Setter
@Getter
public class UserDetailsImpl implements UserDetails {

	private final Member m;
	
	public UserDetailsImpl(Member m) {
		this.m = m;
	}

	//user의 권한 정보 설정
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(m.getType()));
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return m.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return m.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}