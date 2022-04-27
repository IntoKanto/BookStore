package com.example.bookStore;
import java.util.ArrayList;
import java.util.List;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepo;
import com.example.bookStore.domain.Category;
import com.example.bookStore.domain.CategoryRepo;

@SpringBootApplication
public class BookStoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner book(BookRepo brepo, CategoryRepo crepo) {
		return (args) -> {
			
			List<Book> books = new ArrayList<>();
		
			crepo.save(new Category("Fantasy", books));
			crepo.save(new Category("Horror", books));
			crepo.save(new Category("Comedy", books));
			
			
			brepo.save(new Book("978-123-321-1", "Rails", "Thomas Heinemeier", 2005, 25.00, crepo.findByName("Fantasy").get(0)));
			brepo.save(new Book("789-987-524-2", "Riisia tiskin alta", "Liisa Karvinen", 2015, 30.00, crepo.findByName("Comedy").get(0)));	
			
			
			

		};
	}


}
