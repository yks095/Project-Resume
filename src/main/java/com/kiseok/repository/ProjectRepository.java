package com.kiseok.repository;

import com.kiseok.domain.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {
//    List<Projects> findAll();

}
