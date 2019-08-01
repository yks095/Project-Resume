package com.kiseok.service;

import com.kiseok.domain.Projects;
import com.kiseok.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Projects> findProjectList()   {

        return projectRepository.findAll();
    }

}
