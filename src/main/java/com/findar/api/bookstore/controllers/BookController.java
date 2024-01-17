package com.findar.api.bookstore.controllers;

import com.findar.api.bookstore.dto.request.BookRequest;
import com.findar.api.bookstore.dto.response.BookResponse;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.exceptions.BookNotFoundException;
import com.findar.api.bookstore.exceptions.NoAvailableBookException;
import com.findar.api.bookstore.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/book")
public class BookController {
    private final BookService bookService;
@Autowired
    public BookController(final BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/addBook")
    public ResponseEntity<BookResponse> addBook(@RequestBody @Valid BookRequest request) throws BookAlreadyExistException {
            return new ResponseEntity<>(bookService.addBook(request), HttpStatus.CREATED);

    }
    @PatchMapping("/updateBook/id/{id}")
    public ResponseEntity<BookResponse> updateBookDetails(@PathVariable String id, @RequestBody BookRequest request) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.updateBookDetails(id, request), HttpStatus.OK);
    }
    @GetMapping("listAvailableBooks/{pageNumber}/{size}")
    public ResponseEntity<List<BookResponse>> listAllBooks(@PathVariable int pageNumber, @PathVariable int size ) throws NoAvailableBookException {
        return new ResponseEntity<>(bookService.listAvailableBooks(pageNumber, size), HttpStatus.OK);
    }

    @DeleteMapping("deleteBook/id/{id}")
    public ResponseEntity<String> deleteBookFromStore(@PathVariable String id) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.deleteBookFromStore(id), HttpStatus.OK);
    }
}
