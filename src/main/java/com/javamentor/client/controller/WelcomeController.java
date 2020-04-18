package com.javamentor.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String printError(ModelMap model) {

        List<String> messages = new ArrayList<>();
        messages.add("Error");

        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}