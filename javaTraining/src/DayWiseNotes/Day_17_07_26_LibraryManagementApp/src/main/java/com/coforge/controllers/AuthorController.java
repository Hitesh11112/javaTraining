package com.coforge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.Author;
import com.coforge.services.AuthorService;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return service.addAuthor(author);
    }
}