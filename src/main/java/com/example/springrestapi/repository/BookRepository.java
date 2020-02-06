package com.example.springrestapi.repository;

import com.example.springrestapi.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
