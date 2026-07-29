package com.coforge.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.Book;
import com.coforge.service.BookService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	final BookService service;

	BookController(BookService service) { this.service = service; }
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(HttpServletRequest request) {
		
		logger.info("getAllBooks api started "+ LocalDateTime.now());
		logger.info("ApiName : {} ", request.getRequestURI());
		logger.info("Method Name : ", request.getMethod());
		
		List<Book> bookList = service.getAllBooks();
		
		logger.info("All Books retrieved");
		logger.info("getAllBooks api closing now " + LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.OK).body(bookList);
	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
		Book savedBook = service.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
		Book bkList = service.getBookById(id);
		return ResponseEntity.status(HttpStatus.OK).body(bkList);
	}

	@PatchMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		Book bkList = service.updateBook(id, book);
		return ResponseEntity.status(HttpStatus.OK).body(bkList);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
		service.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/books/author/{author}")
	public List<Book> findByAuthor(@PathVariable("author") String author) {
		return service.findByAuthor(author);
	}
	
	@GetMapping("/books/title/{title}")
	public Book findByTitle(@PathVariable("title") String title) {
		return service.findByTitle(title);
	}
	
}
