package com.coforge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.LibraryCard;
import com.coforge.services.LibraryCardService;

@RestController
public class LibraryCardController {

    @Autowired
    private LibraryCardService service;

    @PostMapping("/card")
    public LibraryCard addCard(@RequestBody LibraryCard card) {
        return service.addCard(card);
    }
}
