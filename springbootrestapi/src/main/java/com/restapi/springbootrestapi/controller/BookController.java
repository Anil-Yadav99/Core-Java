package com.restapi.springbootrestapi.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springbootrestapi.entity.Book;
import com.restapi.springbootrestapi.services.BookService;


@RestController
public class BookController {
	@Autowired
     private BookService bookservice;
	//@RequestMapping(value="/books", method=RequestMethod.GET)

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list=this.bookservice.getAllBooks();
		if(list.size()<0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	    return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
	    Book book=this.bookservice.getBookByID(id);
	    if(book==null)
	    {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    else
	    {
	    	return ResponseEntity.status(HttpStatus.CREATED).body(book);
	    }
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book b=null;
		try {
		 b= this.bookservice.addBook(book);
		 return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
	    try {
	        // Call the delete service method
	        this.bookservice.deleteBook(bookId);
	        // Return HTTP 200 (OK) on success
	        return ResponseEntity.status(HttpStatus.OK).build();
	    } catch (Exception e) {
	        // Log the exception message if needed
	        System.err.println("Error while deleting book: " + e.getMessage());
	        // Return HTTP 204 (No Content) if deletion fails
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	}

	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		try {
		this.bookservice.updateBook(book,bookId);
		return ResponseEntity.ok().body(book);
		}
		catch(Exception e)
		{
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
