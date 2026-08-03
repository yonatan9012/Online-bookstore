package com.example.Online.bookstore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;

@Entity @Table(name="book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank @Length(min = 2, max = 100)
    private String title;

    @NotBlank @Length(min = 2, max = 50)
    private String author;

    @Min(1) @Max(1500)
    private Double price;

    @Min(1) @Max(5000)
    private Integer pages;

    @Length(max = 500)
    private String coverImage;

    public Book(){}

    public Book(String title, String author, Double price, Integer pages, String coverImage) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.coverImage = coverImage;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}