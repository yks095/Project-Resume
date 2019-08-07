package com.kiseok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class UserController {

    @GetMapping("/login")
    public String loginView()   {
        return "/login";
    }

    @GetMapping("/register")
    public String registerView()    {
        return "/register";
    }

    @GetMapping("/forgot/id")
    public String forgotIdView()    {
        return "/findID";
    }

    @GetMapping("/forgot/pw")
    public String forgotPwView()    {
        return "/findPW";
    }

}
