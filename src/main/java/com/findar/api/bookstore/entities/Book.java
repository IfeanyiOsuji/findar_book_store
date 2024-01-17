package com.findar.api.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "BOOKS")
@DynamicUpdate
public class Book {
    /*
     * A model class for creating database table
     * */
    @Id
    @Column(name = "ID")

    private String id; //A random String will be generated for the id at construction

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    private String isbn; // International Standard Book Number
    private String genre;
    private String publicationYear;

    @Column(name = "price", nullable = false)
    private double price;


    private int quantityInStock;
    private boolean available;

    @NotNull
    private Date createdAt;
    @NotNull
    private Date updatedAt;
    public Book() {

        this.id = UUID.randomUUID().toString().substring(0, 25);
    }

    public Book(String title, String author, String isbn, String genre, String publicationYear, double price, int quantityInStock,
                Date createdAt, Date updatedAt) {
        this.id = UUID.randomUUID().toString().substring(0, 25);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.createdAt = createdAt;
        this. updatedAt = updatedAt;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public boolean isAvailable(){
        this.available = this.quantityInStock > 0;
        return  this.available;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date date){
        this.updatedAt = updatedAt;
    }
    public Date getUpdatedAt(){
        return this.updatedAt;
    }

}
