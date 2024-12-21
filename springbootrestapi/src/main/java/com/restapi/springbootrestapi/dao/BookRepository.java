package com.restapi.springbootrestapi.dao;



import org.springframework.data.repository.CrudRepository;

import com.restapi.springbootrestapi.entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{

	public Book findByBookId(int bookId);
}
