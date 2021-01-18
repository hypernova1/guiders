package org.brokers.guiders.web.essay;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.brokers.guiders.util.PageCriteria;

public interface EssayDAO {

    void insertEssay(Essay essay);

    Essay selectEssay(Integer eno);

    List<Essay> selectEssayList(@Param("startNum") Integer startNum, @Param("cri") PageCriteria cri);

    void updateEssay(Essay essay);

    void deleteEssay(Integer eno);

    Integer selectLikeCnt(Map<String, String> map);

    void insertRecommend(Map<String, String> map);

    void deleteRecommend(Map<String, String> map);

    Integer getCount(String eno);

    Integer selectEssayCount(PageCriteria cri);

    List<Map<String, Object>> selectTopEssay();

    void increaseLikeCnt(Integer eno);

    void decreaseLikeCnt(Integer eno);
}
