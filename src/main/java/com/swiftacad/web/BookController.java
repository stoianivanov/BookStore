package com.swiftacad.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swiftacad.entity.Book;
import com.swiftacad.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		bookRepository.save(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/books", method= RequestMethod.GET)
	public ResponseEntity<List<Book>> findAll(){
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findById(@PathVariable Long id){
		Optional<Book> bookOpt  = bookRepository.findById(id);
		if(bookOpt.isPresent()) {
			return new ResponseEntity<>(bookOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
