package com.kiseok.controller;

import com.kiseok.domain.Projects;
import com.kiseok.repository.ProjectRepository;
import com.kiseok.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectService projectService;

    @GetMapping
    public String projectView(Model model) {
        System.out.println("1");
        model.addAttribute("projects_list", projectService.findProjectList());

        return "/project";
    }

    @GetMapping("/register")
    public String projectRegisterView() {
        System.out.println("2");
        return "/registerProject";
    }

    @PostMapping("/save")
    public ResponseEntity<?> postProjects(@RequestBody Projects projects) {

        projects.setRegisteredDateNow();
        projectRepository.save(projects);
        System.out.println("3");
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}