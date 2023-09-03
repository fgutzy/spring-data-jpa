package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class RegisterController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("newPerson", new Person());
        return "register";
    }

    @PostMapping("/register")
    public String createNewPerson(@ModelAttribute("newPerson") Person newPerson){
        personRepository.save(newPerson);
        return "register";
    }
}
