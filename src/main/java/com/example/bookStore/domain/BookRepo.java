package com.example.bookStore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;




public interface BookRepo extends CrudRepository<Book, Long> {

	List<Book> findByAuthor(String author);  
}
