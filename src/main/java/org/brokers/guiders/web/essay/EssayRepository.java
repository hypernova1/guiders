package org.brokers.guiders.web.essay;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EssayRepository extends JpaRepository<Essay, Long> {

    List<Essay> findTop6OrderByLikeCountDesc();

}
