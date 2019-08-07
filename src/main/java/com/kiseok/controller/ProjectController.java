package com.kiseok.controller;

import com.kiseok.domain.Projects;
import com.kiseok.repository.ProjectRepository;
import com.kiseok.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectService projectService;

    @GetMapping
    public String projectView(Model model) {
        model.addAttribute("projects_list", projectService.findProjectList());

        return "/project/project";
    }

    @GetMapping("/register")
    public String projectRegisterView() {
        return "/project/registerProject";
    }

    @GetMapping("/look/{idx}")
    public String showProject(Model model, @PathVariable("idx")Long idx)  {
        model.addAttribute("show_project", projectService.findProject(idx));
        return "/project/showProject";
    }

    @PostMapping("/save")
    public ResponseEntity<?> postProjects(@RequestBody Projects projects) {

        projects.setRegisteredDateNow();
        projectRepository.save(projects);

        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/modify/{idx}")
    public ResponseEntity<?> putProjects(@PathVariable("idx") Long idx, @RequestBody Projects projects) {

        Projects modifiedProject = projectService.modifyProject(idx, projects);
        projectService.saveModifiedProject(modifiedProject);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteProjects(@PathVariable("idx") Long idx)  {
        projectRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}