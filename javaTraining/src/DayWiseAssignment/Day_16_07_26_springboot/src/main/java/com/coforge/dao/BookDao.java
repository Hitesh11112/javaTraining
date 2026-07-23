package com.coforge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Book;
import com.coforge.repositories.BookRepository;

@Repository
public class BookDao {

	final BookRepository repo;

	BookDao(BookRepository repo) { this.repo = repo; }
	
	//getAllBooks
	public List<Book> getAllBooks() {
		return repo.findAll();
	}
	//addBook
	public Book addBook(Book book) {
		return repo.save(book);
	}
	//GetBookById
	public Optional<Book> getBookById(Long id) {
		return repo.findById(id);
	}
	//updateBook
	public Book updateBook(Long id, Book book) {
		return repo.save(book);
	}
	//deleteBook
	public void deleteBook(Long id) {
		repo.deleteById(id);
	}
	
	public List<Book> findByAuthor(String author) {
		return repo.getAllBookByAuthorName(author);
	}
	
	public Book findByTitle(String title) {
		return repo.findByTitle(title);
	}
}
