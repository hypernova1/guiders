package org.brokers.guiders.web.essay;

import org.apache.ibatis.annotations.Param;
import org.brokers.guiders.util.PageCriteria;

import java.util.List;
import java.util.Map;

public interface EssayDAO {

    void insertEssay(Essay essay);

    Essay selectEssay(Integer eno);

    List<Essay> selectEssayList(@Param("startNum") Integer startNum, @Param("cri") PageCriteria cri);

    void insertRecommend(Map<String, String> map);

    Integer getCount(String eno);

    Integer selectEssayCount(PageCriteria cri);

}
