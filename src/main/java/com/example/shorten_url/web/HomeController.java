package com.example.shorten_url.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageName", "index");
        return "index";
    }

    @GetMapping("/{page}")
    public String page(@PathVariable String page, Model model) {
        model.addAttribute("pageName", page);
        return "index";
    }
}