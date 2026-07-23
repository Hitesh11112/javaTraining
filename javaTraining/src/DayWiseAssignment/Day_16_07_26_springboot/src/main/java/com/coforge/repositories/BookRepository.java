package com.coforge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coforge.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	//prefix findBy or getBy to the property name
//	List<Book> findByAuthor(String author);
	
//	Book findByTitle(String title);
	
	Book findByAuthorMobile(String author);
	
	
	//select * from book where title like 's%'
	///native queries
//	@Query(value="select * from book where author=?",nativeQuery = true)
//	List<Book> getAllBookByAuthorName(@Param("author") String author);
//	@Query(value="select * from book where title=?",nativeQuery=true)
//	Book findByTitle(String title);

//	@Query(value="select b from Book b where b.title = :title?")
//	@Query("select b from Book b where b.title = :title")
//	Book findByTitle(@Param("title") String title);

	@Query(name="getBookByTitle")
	Book findByTitle(@Param("title") String title);
	
	//jpql queries
//	@Query(value="select b from Book b where author=:author")
	
	//named queries 
	@Query(name="getAllBooksByAuthor")
	List<Book> getAllBookByAuthorName(@Param("author") String author);
}
