package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;

import org.springframework.ui.Model;
@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	
	@GetMapping("/BookList")
	public String BookList(Model model) {		
		
		model.addAttribute("books",repository.findAll());
		
		return "bookList";
	}
	
	
    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }  
	

    @GetMapping("/book/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }  
    
	@GetMapping("/add")
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());	
		model.addAttribute("categories", crepository.findAll());

		return "addBook";
		
	}
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:BookList";
	}
	
	 @GetMapping("/delete/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../BookList";
	    } 
	 @GetMapping("/edit/{id}")
		public String edit(@PathVariable("id")Long bookId, Model model) {
		 model.addAttribute("book", repository.findById(bookId));
		 model.addAttribute("categories", crepository.findAll());

		return "editBook";
		}
	 @GetMapping("/login")
		 public String login() {
			 return "login";
		 }
	 @GetMapping("/hello")
	 	public String hello() {
		 return "hello";
	 }
	 @GetMapping({"/", "/home"})
		public String homeSecure() {
			return "home";
		}
	 @GetMapping("/logout")
	 	public String logout() {
		 return "redirect:login";
	 }
	 

	 
}
