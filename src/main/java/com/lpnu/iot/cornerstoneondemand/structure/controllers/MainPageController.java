package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }
}
