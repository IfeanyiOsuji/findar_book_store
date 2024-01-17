package com.findar.api.bookstore.exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String s) {
        super(s);
    }
}
