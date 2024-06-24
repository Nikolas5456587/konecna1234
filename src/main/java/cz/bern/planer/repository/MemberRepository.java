package cz.bern.planer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bern.planer.entities.Member;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);
}
