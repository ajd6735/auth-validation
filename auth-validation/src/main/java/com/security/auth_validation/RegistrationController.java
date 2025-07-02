package com.security.auth_validation;

import com.security.auth_validation.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new AppUser());
        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") AppUser user, Model model){
        try{
            userService.registerUser(user);
            model.addAttribute("message", "Registration successful! Please login.");
            return "login";
        } catch (Exception e){
            model.addAttribute("error", "An error occurred during registration. Please try again later.");
            return "register";
        }
    }

}
