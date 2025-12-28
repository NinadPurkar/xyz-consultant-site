package com.example.ninad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login()
    {
        return "login"; //looks for login.html page in temples
    }

    @GetMapping("/admin/home")
    public String adminHome()
    {
        return "admin/home";       // looks for admin/home.html
    }
}
