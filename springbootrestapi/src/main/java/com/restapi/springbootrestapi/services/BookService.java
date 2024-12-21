package com.restapi.springbootrestapi.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.springbootrestapi.dao.BookRepository;
import com.restapi.springbootrestapi.entity.Book;
@Component
public class BookService {
	
//	private static List<Book> list=new ArrayList();
//	
//	static {
//			list.add(new Book(1,"java 8","Vaishali Shah"));
//			list.add(new Book (2,"python","Guido Van Rossum"));
//			list.add(new Book(3,"On a winter's night","Munshi Premchand"));	
//	}
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks()
	{
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	public Book getBookByID(int id)
	{
		Book book=null;
		try {
		//book=list.stream().filter(n->n.getBookId()==id).findFirst().get();
			book=this.bookRepository.findByBookId(id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return book;
	}
	
	//adding the book
	
	public Book addBook(Book book) {
	    if (book == null) {
	        throw new IllegalArgumentException("Book object cannot be null");
	    }
	    // Save and return the book
	    return this.bookRepository.save(book);
	}

	
	//Delete the book
	public void deleteBook(int id)
	{
		//list=list.stream().filter(n->n.getBookId()!=id).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
	}
	
	// update book
	
	public void updateBook(Book book,int bid)
	{
//		list=list.stream().map(n->{
//			if(n.getBookId()==bid)
//			{
//				n.setBookTitle(book.getBookTitle());
//				n.setBookAuthor(book.getBookAuthor());
//			}
//			return n;
//		}).collect(Collectors.toList());
		book.setBookId(bid);
		this.bookRepository.save(book);
	}
}
