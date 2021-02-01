package org.brokers.guiders.web.essay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EssayRepositoryCustom {

    Page<Essay> searchByKeyword(String keyword, Pageable pageable);

}
