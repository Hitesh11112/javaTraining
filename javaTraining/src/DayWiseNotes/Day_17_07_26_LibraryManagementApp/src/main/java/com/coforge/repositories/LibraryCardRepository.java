package com.coforge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.entities.LibraryCard;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Integer>{
	

}
