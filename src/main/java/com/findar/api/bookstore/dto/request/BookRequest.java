package com.findar.api.bookstore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class BookRequest implements Serializable {
    @NotNull(message ="title should not be null")
    @NotBlank(message = "title should not be empty")
    private String title;

    @NotNull(message ="author should not be null")
    @NotBlank(message = "author should not be empty")
    private String author;
    private String isbn; // International Standard Book Number
    private String genre;
    @Length(min = 4, max = 4)
    private String publicationYear;
    @NotNull(message = "please insert price")
    private double price;
    private int quantityInStock;

    public BookRequest(String title, String author, String isbn, String genre, String publicationYear, double price, int quantityInStock) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public BookRequest() {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
