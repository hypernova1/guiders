package com.guiders.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.guiders.web.essay.dao.EssayDAO;
import com.guiders.web.essay.domain.EssayVO;
import com.guiders.web.member.dao.MyPageDAO;
import com.guiders.web.util.PageCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EssayTest {

  @Autowired
  private SqlSession sqlSession;

  @Test
  public void essayInsertTest() {
    EssayVO vo = new EssayVO();
    for (int i = 0; i < 100; i++) {
      vo.setEmail("test@naver.com");
      vo.setEtitle("안녕하세요!!!!!!!!!! 누워서 자고싶다......" + i);
      vo.setEcontent("프로젝트가 다 끝나갑니다..........ㅠㅠㅠ 정말 슬프네요");
      vo.setField("잡담전문");
      vo.setLang("Java");
      sqlSession.getMapper(EssayDAO.class).insertEssay(vo);
    }



  }

  @Test
  public void testEssay() {
    int eno = 6;
    EssayVO vo = sqlSession.getMapper(EssayDAO.class).selectEssay(eno);
    System.out.println(vo);
  }

  @Test
  public void essaySelect() {
    System.out.println(sqlSession.getMapper(EssayDAO.class).selectEssay(7));
  }

  @Test
  public void essayListTest() {
    Integer startNum = 0;
    PageCriteria cri = new PageCriteria();
    cri.setKeyword("java");
    System.out.println(sqlSession.getMapper(EssayDAO.class).selectEssayList(startNum, cri));
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

  @Test
  public void getEssayCount() {
    PageCriteria cri = new PageCriteria();
    cri.setKeyword("이");
    System.out.println(sqlSession.getMapper(EssayDAO.class).selectEssayCount(cri));
  }

}
