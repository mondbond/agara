package com.mond.controllers;

import com.mond.entity.Author;
import com.mond.model.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 19.11.2017.
 */

@RestController
public class AuthorREST {

    AuthorService authorService;

    @Autowired
    public AuthorREST(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors/{id}")
    public Author getAuthoryId (@PathVariable("id") int id){
        return authorService.getById(id);
    }
}
