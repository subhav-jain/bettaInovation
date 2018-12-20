package com.ith.betta.web.controllers;


import com.ith.betta.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "hello";
    }
}
