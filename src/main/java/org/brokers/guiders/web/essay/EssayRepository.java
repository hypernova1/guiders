package org.brokers.guiders.web.essay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EssayRepository extends JpaRepository<Essay, Long>, CrudRepository<Essay, Long> {

    List<Essay> findTop6OrderByLikeCountDesc();

}
