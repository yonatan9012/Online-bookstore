package com.example.Online.bookstore.controller;

import com.example.Online.bookstore.dto.BookIn;
import com.example.Online.bookstore.model.Book;
import com.example.Online.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertBook(@RequestBody BookIn bookIn) {
        Book book = bookIn.toBook(bookIn);
        book = bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookIn bookIn) {
        Optional<Book> dbBook = bookService.findById(id);
        bookIn.updateBook(dbBook.get());
        Book updatedBook = bookService.save(dbBook.get());
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        Optional<Book> dbBook = bookService.findById(id);
        bookService.delete(dbBook.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}