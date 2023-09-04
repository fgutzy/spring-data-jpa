package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String createNewPerson(@ModelAttribute("newPerson") Person newPerson, @RequestParam(value = "repeatPassword") String password2,
    Model model){
        if(isValidUser(newPerson)){
            if (newPerson.getPassword().equals(password2)){
                model.addAttribute("message", "registered succesfully");
                personRepository.save(newPerson);
                return "testPage";
            } else{
                model.addAttribute("message", "passwords dont match");
            }
        } else{
            model.addAttribute("message", "username taken");

        }
        return "register";
    }

    boolean isValidUser(Person person){
        return !personRepository.existsByName(person.getName());
    }
}
