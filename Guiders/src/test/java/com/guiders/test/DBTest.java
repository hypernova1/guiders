package com.guiders.test;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guiders.member.dao.MemberDAO;
import com.guiders.member.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void timeTest() {
		System.out.println("현재 시간 : " + sqlSession.getMapper(TestDAO.class).getTime());
	}
	
	@Test
	public void insertTest() {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		
		MemberVO vo = new MemberVO();
		vo.setEmail("admin@guiders.com");
		vo.setPassword(passEncoder.encode("1234"));
		vo.setMname("관리자");
		vo.setGender(1);
		vo.setPhone("010-123-4567");
		vo.setPhoto("photo.png");
		vo.setCtno(1);
		
		sqlSession.getMapper(MemberDAO.class).insertMember(vo);
		sqlSession.getMapper(MemberDAO.class).selectMemberList();
	}
	
	@Test
	public void authInsertTest() {
		sqlSession.getMapper(MemberDAO.class).insertAuth("admin@guiders.com");
	}
	
	@Test
	public void getAuthTest() {
		System.out.println(
				Arrays.toString(
						sqlSession.getMapper(MemberDAO.class).getAuthList("admin@guiders.com").toArray()
						));
	}
	
}
