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

    public Projects findProject(Long idx)   {
        return projectRepository.getOne(idx);
    }

    public Projects modifyProject(Long idx, Projects projects)  {
        Projects modifiedProject = projectRepository.getOne(idx);

        modifiedProject.setName(projects.getName());
        modifiedProject.setPeriod(projects.getPeriod());
        modifiedProject.setPersons(projects.getPersons());
        modifiedProject.setDescription(projects.getDescription());
        modifiedProject.setRegisteredDateNow();

        return modifiedProject;
    }

    public void saveModifiedProject(Projects modifiedProject)   {
        projectRepository.save(modifiedProject);
    }

}
