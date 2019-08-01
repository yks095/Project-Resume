package com.kiseok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/introduction")
public class IntroductionController {

    @GetMapping
    public String introductionView()    {
        return "/introduction";
    }
}
