package com.guiders.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBTest {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void timeTest() {
		System.out.println("현재 시간 : " + sqlSession.getMapper(TestDAO.class).getTime());
	}

}
