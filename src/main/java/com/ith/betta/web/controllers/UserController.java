package com.ith.betta.web.controllers;

import com.ith.betta.web.models.User;
import com.ith.betta.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
//
//
//    }

    @ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String userForm(Locale locale, Model model) {
        model.addAttribute("users", userService.list());
        return "editUser";
    }

    @PostMapping("/addUser")

    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model){

        userService.save(user);
        return "redirect:/editUser";
    }
}
