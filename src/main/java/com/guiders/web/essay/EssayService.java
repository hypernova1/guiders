package com.guiders.web.essay;

import java.util.List;
import java.util.Map;

import com.guiders.util.PageCriteria;

public interface EssayService {

    void writeEssay(EssayVO essayVO);

    EssayVO readEssay(int eno);

    List<EssayVO> getEssayList(Integer startNum, PageCriteria cri);

    void modifyEssay(EssayVO essayVO);

    void removeEssay(Integer eno);

    int addRecommend(Map<String, String> map);

    boolean confirmLike(Map<String, String> map);

    Integer getEssayCount(PageCriteria cri);

    List<Map<String, Object>> getTopEssay();


}
