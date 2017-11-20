package com.mond.controllers;

import com.mond.model.AuthorService;
import com.mond.model.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 19.11.2017.
 */

@Controller
public class IndexController {

    QuoteService quoteService;

    @Autowired
    public IndexController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/add_author")
    public String showAddAuthor(Model model){
        model.addAttribute("quote", quoteService.getRandomQuote());
        return "add_author";
    }
}
