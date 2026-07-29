package com.coforge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.entities.LibraryCard;
import com.coforge.entities.Student;
import com.coforge.repositories.LibraryCardRepository;

@Service
public class LibraryCardService {
	
	@Autowired
	LibraryCardRepository repository;
	
	public List<LibraryCard> getAllCards() {
		return repository.findAll();
	}
	

    public LibraryCard addCard(LibraryCard card) {

        Student student = card.getStudent();

        if(student != null) {
            card.setStudent(student);
        }

        return repository.save(card);
    }

}
