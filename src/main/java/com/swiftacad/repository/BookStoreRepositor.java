package com.swiftacad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftacad.entity.BookStore;

@Repository
public interface BookStoreRepositor extends CrudRepository<BookStore, Long> {

}
