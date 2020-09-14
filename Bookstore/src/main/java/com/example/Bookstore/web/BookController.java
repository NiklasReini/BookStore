package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CatregoryRepository;

import org.springframework.ui.Model;
@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CatregoryRepository crepository;
	
	@GetMapping("/BookList")
	public String BookList(Model model) {		
		
		model.addAttribute("books",repository.findAll());
		
		return "bookList";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());	
		model.addAttribute("departments", crepository.findAll());
		return "addBook";
		
	}
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:BookList";
	}
	
	 @GetMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../BookList";
	    } 
	 @GetMapping("/edit/{id}")
		public String edit(@PathVariable("id")Long bookId, Model model) {
		 model.addAttribute("book", repository.findById(bookId));
		 model.addAttribute("departments", crepository.findAll());
		return "editBook";
		}

	 
}
