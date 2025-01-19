package com.seol.koreantestdatagenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAccountController {

    @GetMapping("/my-account")
    public String myAccount(Model model) {
        model.addAttribute("nickname", "김우빈");
        model.addAttribute("email","우빈@gmail.com");

        return "my-account";
    }

}
