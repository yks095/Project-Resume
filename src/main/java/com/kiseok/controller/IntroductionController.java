package com.kiseok.controller;

import com.kiseok.domain.Introductions;
import com.kiseok.repository.IntroductionRepository;
import com.kiseok.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/introduction")
public class IntroductionController {

    @Autowired
    IntroductionRepository introductionRepository;

    @Autowired
    IntroductionService introductionService;

    @GetMapping
    public String introductionView(Model model) {
        model.addAttribute("introductions_list", introductionService.findIntroductionList());

        return "/introduction/introduction";
    }

    @GetMapping("/register")
    public String introductionRegisterView() {
        return "/introduction/registerIntroduction";
    }

    @GetMapping("/look/{idx}")
    public String showIntroduction(Model model, @PathVariable("idx")Long idx)  {
        model.addAttribute("show_introduction", introductionService.findIntroduction(idx));
        return "/introduction/showIntroduction";
    }

    @PostMapping("/save")
    public ResponseEntity<?> postIntroductions(@RequestBody Introductions introductions) {

        introductions.setRegisteredDateNow();
        introductionRepository.save(introductions);

        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/modify/{idx}")
    public ResponseEntity<?> putIntroductions(@PathVariable("idx") Long idx, @RequestBody Introductions introductions) {

        Introductions modifiedIntroduction = introductionService.modifyIntroduction(idx, introductions);
        introductionService.saveModifiedIntroduction(modifiedIntroduction);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteIntroductions(@PathVariable("idx") Long idx)  {
        introductionRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}