package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("person", new Person());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("person") Person person, Model model) {
        System.out.println(person.name + " naminger");
        System.out.println(person.password + " passwortinger");
        if (isValidUser(person)) {
            model.addAttribute("message", "Login successful!");
        } else {
            model.addAttribute("message", "Login failed. Please try again.");
        }
        return "login";
    }

    private boolean isValidUser(Person person) {
        return person.getName().equals("test") && person.getPassword().equals("test");
    }
}


