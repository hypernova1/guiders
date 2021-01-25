package org.brokers.guiders.web.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository<T extends Member> extends JpaRepository<T, Long> {

    Optional<T> findByEmail(String email);
}
