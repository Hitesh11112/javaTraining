package com.coforge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}