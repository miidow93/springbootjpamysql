package com.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Book;
import com.sample.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	BookRepository bookRepo;	
	
	@GetMapping("/all")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Book> getAllBooks() {
		/*System.out.println("Get all books");
		List<Book> books = new ArrayList<Book>();*/
		//bookRepo.findAll().forEach(books::add);
		return bookRepo.findAll();
	}
	
	@PostMapping("/create")
	@CrossOrigin(origins="http://localhost:4200")
	public Book addBook(@RequestBody Book b) {
		Book _book = bookRepo.saveAndFlush(new Book(b.getTitle(), b.getPages()));
		return _book;
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
		bookRepo.deleteById(id);
		return new ResponseEntity<>("Book has been deleted ", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book b) {
		Optional<Book> bookData = bookRepo.findById(id);
		
		if(bookData.isPresent()) {
			Book _b = bookData.get();
			_b.setTitle(b.getTitle());
			_b.setPages(b.getPages());
			return new ResponseEntity<>(bookRepo.saveAndFlush(_b), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*@GetMapping("/table")
	@CrossOrigin(origins="http://localhost:4200")
	public List<String> getColumnNames() {

		return bookRepo.findColumnsName("db_springboot", "book");
	} */

}
