package com.example.mywebapplication2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/Home")
    public String redirectHome() {
        return "Home";
    }

//
//    @GetMapping(value = "/Tickets.html")
//    public String redirectTickets() {
//        return "Tickets";
//    }

//    @GetMapping(value = "/About.html")
//    public String redirectAbout() {
//        return "About";
//    }



}