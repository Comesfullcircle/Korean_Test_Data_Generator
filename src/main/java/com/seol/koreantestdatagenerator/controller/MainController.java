package com.seol.koreantestdatagenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String MainPage(){
        return "forward:/table-schema";
    }

}
