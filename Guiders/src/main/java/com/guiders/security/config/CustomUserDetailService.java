package com.guiders.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.guiders.web.member.domain.MemberVO;
import com.guiders.web.member.service.MemberService;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

		MemberVO memberVO = memberService.loginCheck(email);
		
		if(memberVO == null) {
			throw new 
			UsernameNotFoundException("no user found with username : " + email);
		}
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		List<String> list = new ArrayList<String>();
		list = memberService.getAuthList(email); //로그인한 사용자의 권한 리스트 가져오기
		
		for(int i = 0; i < list.size(); i++) {
			roles.add(new SimpleGrantedAuthority(list.get(i)));
		}
		
		UserCustom user = new UserCustom(memberVO.getEmail(),memberVO.getMname(), memberVO.getPassword(), roles);
		/*System.out.println("User : " + user);*/
		
		return user;
	}
}
