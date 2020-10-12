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
import com.example.Bookstore.model.User;
import com.example.Bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	


	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository userRepository){
		return(args) ->{
			
			log.info("saving books");											
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Romance"));
			
			brepository.save(new Book("John","beatates","21121223-1",2001, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("smith","gttt","232333243-1",2009,crepository.findByName("Romance").get(0)));
			brepository.save(new Book("johnson","farouh","234234234-1",1997, crepository.findByName("Fiction").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			
		};
	
	}
}
