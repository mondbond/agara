package com.mond.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 19.11.2017.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndex(){
        System.out.println("INDEX!!!!");
        return "index";
    }
}
