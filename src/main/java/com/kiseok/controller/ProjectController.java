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
        System.out.println("1");
        model.addAttribute("projects_list", projectService.findProjectList());

        return "/project";
    }

    @GetMapping("/register")
    public String projectRegisterView() {
        System.out.println("2");
        return "/registerProject";
    }

    @GetMapping("/look//{idx}")
    public String showProject(Model model, @PathVariable("idx")Long idx)  {
        model.addAttribute("show_project", projectService.findProject(idx));
        return "/showProject";
    }

    @PostMapping("/save")
    public ResponseEntity<?> postProjects(@RequestBody Projects projects) {

        projects.setRegisteredDateNow();
        projectRepository.save(projects);
        System.out.println("3");
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/modify/{idx}")
    public ResponseEntity<?> putProjects(@RequestBody Projects projects, @PathVariable("idx")Long idx) {

        Projects modifiedProject = projectRepository.getOne(idx);
        modifiedProject.setName(projects.getName());
        modifiedProject.setPeriod(projects.getPeriod());
        modifiedProject.setPersons(projects.getPersons());
        modifiedProject.setDescription(projects.getDescription());
        modifiedProject.setRegisteredDateNow();

        projectRepository.save(modifiedProject);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteProjects(@PathVariable("idx")Long idx)  {
        projectRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}