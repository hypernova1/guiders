package com.guiders.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guiders.web.member.domain.GuiderVO;
import com.guiders.web.member.service.MemberService;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

		GuiderVO guiderVO = memberService.readMember(email);
		
		if(guiderVO == null) {
			throw new 
			UsernameNotFoundException("no user found with username : "+ email);
		}
		
		System.out.println(guiderVO.getEmail());
		System.out.println(guiderVO.getMname());
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		List<String> list = new ArrayList<>();
		list = memberService.getAuthList(email); //로그인한 사용자의 권한 리스트 가져오기
		
		for(int i = 0; i < list.size(); i++) {
			roles.add(new SimpleGrantedAuthority(list.get(i)));
		}
		
		UserDetails user = new User(guiderVO.getMname(), guiderVO.getPassword(), roles);
		
		System.out.println("User : " + user);
		
		return user;
	}
	
}
