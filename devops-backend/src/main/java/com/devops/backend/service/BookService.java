package com.devops.backend.service;

import com.devops.backend.models.Book;
import com.devops.backend.models.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    void deleteById(Long id);
}
