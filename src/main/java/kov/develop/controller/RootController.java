package kov.develop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

/**
 * Welcome page
 */

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "users";
    }
}
