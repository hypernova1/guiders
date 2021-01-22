package org.brokers.guiders.web.essay;

import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EssayCustomRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Essay> findAll(Criteria criteria) {

        JPAQuery<?> query = new JPAQuery<>(em);

        QEssay qEssay = QEssay.essay;

        return null;
    }
}
