package com.example.bookStore;

import org.springframework.data.repository.CrudRepository;

import com.example.bookStore.domain.Book;
import java.util.List;




public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByAuthor(String author);  
}
