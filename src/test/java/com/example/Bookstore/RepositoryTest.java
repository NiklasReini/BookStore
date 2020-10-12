package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    private BookRepository repository;

    
    

    @Test
    public void findByTitleTest() {
    	
    	
        List<Book> books = repository.findByTitle("beatates");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("beatates");
    }
    
    @Test
    public void createNewBook() {
 
    	Book book = new Book("John","beatates","21121223-1",2001, new Category("Fiction"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}