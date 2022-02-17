package com.example.bookStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookStore.domain.Book;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner book(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("978-123-321-1", "Rails", "Thomas Heinemeier", 2005, 25.00));
			repository.save(new Book("789-987-524-2", "Riisia tiskin alta", "Liisa Karvinen", 2015, 30.00));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}


}
