package com.example.Online.bookstore.dto;

import com.example.Online.bookstore.model.Book;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;

public class BookIn implements Serializable {

    @NotBlank @Length(min = 2, max = 100)
    private String title;

    @NotBlank @Length(min = 2, max = 50)
    private String author;

    @Min(1) @Max(1500)
    private Double price;

    @Min(1) @Max(5000)
    private Integer pages;

    public BookIn() {}

    public Book toBook(BookIn bookIn) {
        return new Book(
                bookIn.getTitle(),
                bookIn.getAuthor(),
                bookIn.getPrice(),
                bookIn.getPages(),
                null // coverImage נשאר ריק ביצירה ראשונית, בדומה לתמונת הפרופיל
        );
    }

    public void updateBook(Book book) {
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setPrice(this.price);
        book.setPages(this.pages);
    }

    // --- Getters and Setters ---

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}