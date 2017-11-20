package com.mond.controllers;

import com.mond.entity.Author;
import com.mond.model.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Iterator;
import java.util.List;

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


    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public void addAuthor (WebRequest webRequest){
        System.out.println(webRequest.getHeader("Content-Type"));
        System.out.println(webRequest.getHeader("Accept-Encoding"));
        System.out.println("IS = " + webRequest.getParameter("name"));
        System.out.println("IS22 = " + webRequest.getParameter("22"));

        Iterator<String> list = webRequest.getHeaderNames();
        System.out.println("ISrrr = " + list.next());

//        Author author = new Author(webRequest.getParameter("name"), webRequest.getParameter("info"));
//        authorService.save(author);
    }

    private String getEncoded(String str){

        return new String();
    }
}
