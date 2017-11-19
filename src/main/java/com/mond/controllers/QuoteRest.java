package com.mond.controllers;

import com.mond.entity.Quote;
import com.mond.model.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 19.11.2017.
 */
@RestController
public class QuoteRest {

    QuoteService quoteService;

    @Autowired
    public QuoteRest(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping("/quotes/{id}")
    public Quote getAuthoryId (@PathVariable("id") int id){
        return quoteService.getById(id);
    }
}
