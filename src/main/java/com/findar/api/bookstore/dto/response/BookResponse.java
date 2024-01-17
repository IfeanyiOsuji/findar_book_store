package com.findar.api.bookstore.dto.response;

import java.io.Serializable;
import java.util.Date;

public class BookResponse implements Serializable {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String publicationYear;
    private double price;
    private int quantityInStock;
    private boolean available;
    private Date createdAt;
    private Date updatedAt;

    public BookResponse(String id, String title, String author, String isbn, String genre, String publicationYear, double price, int quantityInStock, boolean available,
                        Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.available = available;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BookResponse() {
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }



    public Date getUpdatedAt() {
        return updatedAt;
    }


}
