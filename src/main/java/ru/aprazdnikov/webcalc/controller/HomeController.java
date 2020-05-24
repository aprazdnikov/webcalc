package ru.aprazdnikov.webcalc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String renderIndex() {
        return "index";
    }

}
