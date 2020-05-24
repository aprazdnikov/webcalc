package ru.aprazdnikov.webcalc.controllers;

import org.springframework.web.bind.annotation.*;
import ru.aprazdnikov.webcalc.json.CalculateData;


@RestController
public class HomeController {

    @RequestMapping("/")
    public String renderIndex() {
        return "index";
    }

    @PostMapping("/post")
    public CalculateData getCalculateDate(@RequestBody CalculateData body) {
        CalculateData json = new CalculateData();

        if (body != null) {
            json = body;
        }
        return json;
    }
}
