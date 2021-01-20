package org.brokers.guiders.web.essay;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.brokers.guiders.util.PageCriteria;
import org.brokers.guiders.web.member.Guider;
import org.brokers.guiders.web.member.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EssayService {

    private final SqlSession sqlSession;

    public void writeEssay(Essay essay) {
        Map<String, String> param = new HashMap<>();
        param.put("email", essay.getWriter().getEmail());
        param.put("type", "guider");
        Guider guider = sqlSession.getMapper(MemberDAO.class).selectByEmail(param);
        essay.setField(guider.getField());
        essay.setLang(guider.getLang());
        sqlSession.getMapper(EssayDAO.class).insertEssay(essay);
    }

    public Essay readEssay(int eno) {
        return sqlSession.getMapper(EssayDAO.class).selectEssay(eno);
    }

    public void modifyEssay(Essay essay) {
        sqlSession.getMapper(EssayDAO.class).updateEssay(essay);
    }

    public List<Essay> getEssayList(Integer startNum, PageCriteria cri) {
        return sqlSession.getMapper(EssayDAO.class).selectEssayList(startNum, cri);
    }

    @Transactional
    public int addRecommend(Map<String, String> map) {
        String eno = map.get("eno");
        Integer cnt = sqlSession.getMapper(EssayDAO.class).selectLikeCnt(map);
        if (cnt == 0) { // 좋아요를 누른 적이 없다면 카운트 +1
            sqlSession.getMapper(EssayDAO.class).insertRecommend(map);
            sqlSession.getMapper(EssayDAO.class).increaseLikeCnt(Integer.parseInt(eno));
        } else { // 누른 적이 있다면 카운트 -1
            sqlSession.getMapper(EssayDAO.class).deleteRecommend(map);
            sqlSession.getMapper(EssayDAO.class).decreaseLikeCnt(Integer.parseInt(eno));
        }
        return sqlSession.getMapper(EssayDAO.class).getCount(eno);
    }

    public boolean confirmLike(Map<String, String> map) {
        int count = sqlSession.getMapper(EssayDAO.class).selectLikeCnt(map);
        return count == 1;
    }

    public void removeEssay(Integer eno) {
        sqlSession.getMapper(EssayDAO.class).deleteEssay(eno);
    }

    public Integer getEssayCount(PageCriteria cri) {
        return sqlSession.getMapper(EssayDAO.class).selectEssayCount(cri);
    }

    public List<Map<String, Object>> getTopEssay() {
        return sqlSession.getMapper(EssayDAO.class).selectTopEssay();
    }

}
