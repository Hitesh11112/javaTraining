package com.coforge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.dao.BookDao;
import com.coforge.entities.Book;
import com.coforge.exceptions.BookNotFoundException;

@Service
public class BookService {
	
	final BookDao dao;

	BookService(BookDao dao) { 
		this.dao = dao;
	}
	
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}
	
	public Book addBook(Book book) {
		return dao.addBook(book);
	}
	
	public Book getBookById(Long id) {
		return dao.getBookById(id)
				.orElseThrow(()->new BookNotFoundException("Book with this id not existed"));
	}
	
	public Book updateBook(Long id, Book book) {
		
		Book exBook = dao.getBookById(id)
				.orElseThrow(()->new BookNotFoundException("Book with this id not existed"));
		
		if(book.getTitle() != null) exBook.setTitle(book.getTitle());
		if(book.getAuthor() != null)exBook.setAuthor(book.getAuthor());
		if(book.getPrice() != 0) exBook.setPrice(book.getPrice());
		return dao.addBook(exBook);
	
	}

	public void deleteBook(Long id) {
		Book exBook = dao.getBookById(id)
				.orElseThrow(()->new BookNotFoundException("Book with this id not existed"));;
		if(exBook != null) {
			dao.deleteBook(id);
		}else { 
			System.out.println("No book available");
		
		}
	}
	
	public List<Book> findByAuthor(String author) {
		return dao.findByAuthor(author);
	}
	
	public Book findByTitle(String title) {
		return dao.findByTitle(title);
	}
	
}
