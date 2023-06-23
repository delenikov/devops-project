package com.devops.backend.controllers;

import com.devops.backend.models.Book;
import com.devops.backend.models.BookDto;
import com.devops.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = {"/books", "/api/books"})
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(object -> ResponseEntity.ok().body(object))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(object -> ResponseEntity.ok().body(object))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if (this.bookService.findById(id).isEmpty())
            return new ResponseEntity<>(id, HttpStatus.OK);
        return ResponseEntity.badRequest().build();
    }
}
