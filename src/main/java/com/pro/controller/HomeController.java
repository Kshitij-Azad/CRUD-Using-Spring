package com.pro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Books;
import com.pro.repository.BooksRepository;

@RestController
public class HomeController {

	@Autowired
	private BooksRepository booksRepository;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to spring boot CRUD";
	}
	
	
	//Add Data
	@PostMapping("/saveBooks")
	public Books saveData(@RequestBody Books books) {
		booksRepository.save(books);
		return books;
	}
	
	//Show Single Data By Id
	@GetMapping("/getBook/{bookid}")
	public Books getBookData(@PathVariable int bookid)
	{
		Optional<Books> books = booksRepository.findById(bookid);
		Books books1=books.get();
		return books1;
	}
	
	//Show All Data present in database
	@GetMapping("/getAllBooks")
	public List<Books> getAll(){
		List<Books> booksList =booksRepository.findAll();
		return booksList;
	}
	
	//Delete Data by Id
	@DeleteMapping("/deleteBook/{bookid}")
	public String deleteBook(@PathVariable int bookid) {
		Books books=booksRepository.findById(bookid).get();
		if(books!=null)
			booksRepository.delete(books);
		return "Delete Successfully!";
	}
	
	//Update Data By Id
	@PutMapping("/updateBook/{bookid}")
	public ResponseEntity<Books> updateProduct(@PathVariable Integer bookid, @RequestBody Books updatedBook) {
	    Optional<Books> existingBookOpt = booksRepository.findById(bookid);

	    if (existingBookOpt.isPresent()) {
	        Books existingBook = existingBookOpt.get();

	        // Update the fields of the existing product with values from the updated product
	        existingBook.setBookname(updatedBook.getBookname());
	        existingBook.setDescription(updatedBook.getDescription());
	        existingBook.setPrice(updatedBook.getPrice());
	        
	        booksRepository.save(existingBook);
	        return ResponseEntity.ok(existingBook);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
