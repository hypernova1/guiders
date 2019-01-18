package com.guiders.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
<<<<<<< HEAD

import com.guiders.web.essay.dao.EssayDAO;
import com.guiders.web.essay.domain.EssayVO;
=======
>>>>>>> work
import com.guiders.web.member.dao.MemberDAO;
import com.guiders.web.member.domain.GuiderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
<<<<<<< HEAD
	
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
	public void selectMemberTest() {
		
		System.out.println(sqlSession.getMapper(MemberDAO.class).selectMember("test@naver.com").getEmail());
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
	
	
	@Test
	public void essayInsertTest() {
		EssayVO vo = new EssayVO();
		vo.setEmail("test@naver.com");
		vo.setEtitle("안녕하세요!");
		vo.setEcontent("미세먼지 그으켬이네요오.....");
		vo.setField("잡담전문");
		vo.setLang("Java");
		
		sqlSession.getMapper(EssayDAO.class).insertEssay(vo);
		
	}
=======

  @Inject
  private SqlSession sqlSession;

  
  @Test
  public void insertTest() {

    BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
    for(int i = 1; i <= 100; i++) {
      GuiderVO vo = new GuiderVO();
      Map<String, String> param = new HashMap<>();
      vo.setEmail("follower" + i + "@guiders.com");
      vo.setPassword(passEncoder.encode("1111"));
      vo.setMname("follower" + i);
      vo.setGender(1);
      vo.setPhone("010-123-4567");
      vo.setPhoto("photo.png");
      vo.setCtno(1);
      vo.setQuote("aaa");
      vo.setIntrodution("aaaa");
      param.put("email", vo.getEmail());
      param.put("auth", "ROLE_MEMEBER");
      sqlSession.getMapper(MemberDAO.class).insertMember(vo);
      sqlSession.getMapper(MemberDAO.class).insertAuth(param);
    }
  }

  @Test
  public void selectMemberTest() {

    System.out
        .println(sqlSession.getMapper(MemberDAO.class).selectMember("test@naver.com").getEmail());
  }

  @Test
  public void authInsertTest() {
  }

  @Test
  public void getAuthTest() {
    System.out.println(Arrays.toString(
        sqlSession.getMapper(MemberDAO.class).getAuthList("admin@guiders.com").toArray()));
  }

>>>>>>> work
}
