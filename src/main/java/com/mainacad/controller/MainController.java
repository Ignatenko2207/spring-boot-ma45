package com.mainacad.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Profile("jsp")
public class MainController {

    @GetMapping()
    public String getLandingPage() {
        return "authorization";
    }
}
