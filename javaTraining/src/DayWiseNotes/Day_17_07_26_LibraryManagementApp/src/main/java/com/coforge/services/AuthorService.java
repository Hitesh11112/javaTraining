package com.coforge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.entities.Author;
import com.coforge.entities.Book;
import com.coforge.repositories.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public Author addAuthor(Author author) {

        
        return repository.save(author);
    }
}