package kov.develop.controller;

import kov.develop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RootController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }
}
