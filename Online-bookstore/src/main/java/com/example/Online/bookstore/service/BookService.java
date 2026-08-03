package com.example.Online.bookstore.service;

import com.example.Online.bookstore.model.Book;
import com.example.Online.bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    // --- פעולות בסיסיות (CRUD) ---

    public Iterable<Book> all() {
        return repository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public void delete(Book book) {
        repository.delete(book);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // --- פעולות ייעודיות לחנות הספרים ---

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> searchByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findBooksCheaperThan(Double maxPrice) {
        return repository.findByPriceLessThan(maxPrice);
    }

    public List<Book> findBooksInPriceRange(Double minPrice, Double maxPrice) {
        return repository.findByPriceBetween(minPrice, maxPrice);
    }
}
