package com.kiseok.repository;

import com.kiseok.domain.Introductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroductionRepository extends JpaRepository<Introductions, Long > {
}
