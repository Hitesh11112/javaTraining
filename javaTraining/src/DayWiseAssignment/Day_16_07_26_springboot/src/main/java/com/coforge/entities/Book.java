package com.coforge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="book")
@NamedQuery(
		name="getBookByTitle",
		query="select b from Book b where title=:title"
)

@NamedQuery(
		name="getAllBooksByAuthor",
		query="select b from Book b where author=:author"
)
public class Book {
	//minimal annotations required to create a table are 2, @Entity,@Id
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	@Size(min=3,message="title can't be less than 3 chars")
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	@Pattern(regexp = "^[6-9][0-9]{9}$",message="Mobile Number "
			+ " must start with either 6,7,8,9 with a length of 10 digits")
	private String authorMobile;
	@Email(message="Please enter valid email")
	private String email;
	@DecimalMin(value="100",inclusive=true,message="book min cost is 100 rs/-")
	private double price;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getAuthorMobile() {
		return authorMobile;
	}

	public void setAuthorMobile(String authorMobile) {
		this.authorMobile = authorMobile;
	}

	public Book() {
		super();
	}

	public Book(Long bookId, String title, String author, double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
}
