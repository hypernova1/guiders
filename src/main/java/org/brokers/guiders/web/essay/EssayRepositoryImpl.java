package org.brokers.guiders.web.essay;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EssayRepositoryImpl implements EssayRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<Essay> searchByKeyword(String keyword, Pageable pageable) {
        QEssay qEssay = QEssay.essay;
        QueryResults<Essay> result = queryFactory.selectFrom(qEssay)
                .where(qEssay.title.contains(keyword).or(qEssay.content.contains(keyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(result.getResults(), pageable, result.getTotal());
    }
}
