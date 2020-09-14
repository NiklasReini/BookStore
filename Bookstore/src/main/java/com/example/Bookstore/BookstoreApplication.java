package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CatregoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	


	@Bean
	public CommandLineRunner demo(BookRepository repository, CatregoryRepository crepository){
		return(args) ->{
			
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Reality"));
			crepository.save(new Category("Romance"));
			
			Book a = new Book("John","beatates","21121223-1",2001);
			Book b = new Book("smith","gttt","232333243-1",2009);
			Book c = new Book("johnson","farouh","234234234-1",1997);
			
			
			repository.save(a);
			repository.save(b);
			repository.save(c);
			
			
		};
	
	}
}
