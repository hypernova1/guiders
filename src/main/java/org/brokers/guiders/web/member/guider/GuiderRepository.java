package org.brokers.guiders.web.member.guider;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuiderRepository extends JpaRepository<Guider, Long> {
    Optional<Guider> findByEmail(String email);
}
