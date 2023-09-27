package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    PersonRepository personRepository;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("person", new Person());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("person") Person person, Model model) {
        if (isValidUser(person)) {
            model.addAttribute("message", "Login was successful!");
            return "testPage";
        } else {
            model.addAttribute("message", "Login failed. Please try again.");
        }
        return "login";
    }

    private boolean isValidUser(Person person) {
        return personRepository.existsByNameAndPassword(person.getName(), person.getPassword());
    }
}


