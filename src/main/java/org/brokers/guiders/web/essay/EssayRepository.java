package org.brokers.guiders.web.essay;

import org.apache.ibatis.annotations.Param;
import org.brokers.guiders.util.PageCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface EssayRepository extends JpaRepository<Essay, Long> {

    void insertEssay(Essay essay);

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
