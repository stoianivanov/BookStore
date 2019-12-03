package com.swiftacad.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swiftacad.entity.BookStore;
import com.swiftacad.repository.BookStoreRepositor;

@RestController
public class BookStoreController {

	@Autowired
	private BookStoreRepositor bookStoreRepository;
	
	@RequestMapping(value = "bookstore", method = RequestMethod.POST)
	public ResponseEntity<BookStore> createBookStore(@RequestBody BookStore newBookStore){
		BookStore b = bookStoreRepository.save(newBookStore);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
}
