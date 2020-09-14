package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	


	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository){
		return(args) ->{
			
			log.info("saving books");											
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Romance"));
			
			brepository.save(new Book("John","beatates","21121223-1",2001, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("smith","gttt","232333243-1",2009,crepository.findByName("Romance").get(0)));
			brepository.save(new Book("johnson","farouh","234234234-1",1997, crepository.findByName("Fiction").get(0)));
			
		};
	
	}
}
