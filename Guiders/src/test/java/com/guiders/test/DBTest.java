package com.guiders.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guiders.web.essay.dao.EssayDAO;
import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.member.dao.MemberDAO;
import com.guiders.web.member.dao.MyPageDAO;
import com.guiders.web.member.domain.GuiderVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void timeTest() {
		System.out.println("현재 시간 : " + sqlSession.getMapper(TestDAO.class).getTime());
	}
	
	@Test
	public void authInsertTest() {
		/*sqlSession.getMapper(MemberDAO.class).insertAuth("admin@guiders.com");*/
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
	
	@Test
	public void testEssay() {
		int eno = 6;
		EssayVO vo = sqlSession.getMapper(EssayDAO.class).selectEssay(eno);
		System.out.println(vo);
	}
	
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
  public void getAuthTest() {
    System.out.println(Arrays.toString(
        sqlSession.getMapper(MemberDAO.class).getAuthList("admin@guiders.com").toArray()));
  }
  
  @Test
  public void essaySelect() {
	  System.out.println(sqlSession.getMapper(EssayDAO.class).selectEssay(7));
  }
  
  @Test
  public void essayListTest() {
	  System.out.println(sqlSession.getMapper(EssayDAO.class).selectEssayList());
  }

  @Test
  public void essayUpdateTest() {
	  EssayVO vo = new EssayVO();
	  vo.setEno(10);
	  vo.setEtitle("으잉....?");
	  vo.setEcontent("<p>으윽..........................</p>");
	  sqlSession.getMapper(EssayDAO.class).updateEssay(vo);
  }
  
  @Test
  public void likecntSelectTest() {
	  Map<String, String> map = new HashMap<>();
	  map.put("eno", "13");
	  map.put("email", "test@naver.com");
	  System.out.println(sqlSession.getMapper(EssayDAO.class).selectLikeCnt(map));
  }
  
  @Test
  public void insertRecommendTest() {
	  Map<String, String> map = new HashMap<>();
	  map.put("eno", "13");
	  map.put("email", "swon9@naver.com");
	  sqlSession.getMapper(EssayDAO.class).insertRecommend(map);
  }
  
  @Test
  public void getCountTest() {
	  System.out.println(sqlSession.getMapper(EssayDAO.class).getCount("13"));
  }

  @Test
  public void getLikeEssayTest() {
	  List<EssayVO> list = sqlSession.getMapper(MyPageDAO.class).selectMyLikeEssay("test@naver.com");
	  
	  System.out.println(Arrays.toString(list.toArray()));
  }
}
