package com.guiders.web.essay;

import com.guiders.util.PageCriteria;
import com.guiders.web.member.GuiderVO;
import com.guiders.web.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EssayServiceImpl implements EssayService {

    private final SqlSession sqlSession;

    @Override
    public void writeEssay(EssayVO essayVO) {
        Map<String, String> param = new HashMap<>();
        param.put("email", essayVO.getEmail());
        param.put("type", "guider");
        GuiderVO guider = sqlSession.getMapper(MemberDAO.class).selectByEmail(param);
        essayVO.setField(guider.getField());
        essayVO.setLang(guider.getLang());
        sqlSession.getMapper(EssayDAO.class).insertEssay(essayVO);
    }

    @Override
    public EssayVO readEssay(int eno) {
        return sqlSession.getMapper(EssayDAO.class).selectEssay(eno);
    }

    @Override
    public void modifyEssay(EssayVO essayVO) {
        sqlSession.getMapper(EssayDAO.class).updateEssay(essayVO);
    }

    @Override
    public List<EssayVO> getEssayList(Integer startNum, PageCriteria cri) {
        return sqlSession.getMapper(EssayDAO.class).selectEssayList(startNum, cri);
    }

    @Transactional
    @Override
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

    @Override
    public boolean confirmLike(Map<String, String> map) {
        int count = sqlSession.getMapper(EssayDAO.class).selectLikeCnt(map);
        return count == 1;
    }

    @Override
    public void removeEssay(Integer eno) {
        sqlSession.getMapper(EssayDAO.class).deleteEssay(eno);
    }

    @Override
    public Integer getEssayCount(PageCriteria cri) {
        return sqlSession.getMapper(EssayDAO.class).selectEssayCount(cri);
    }

    @Override
    public List<Map<String, Object>> getTopEssay() {
        return sqlSession.getMapper(EssayDAO.class).selectTopEssay();
    }

}
