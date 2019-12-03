package com.swiftacad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftacad.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByName(String name);
	List<Book> findByNameAndIsbn(String name, String isbn); 
}
