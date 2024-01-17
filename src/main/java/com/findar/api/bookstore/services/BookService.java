package com.findar.api.bookstore.services;

import com.findar.api.bookstore.dto.request.BookRequest;
import com.findar.api.bookstore.dto.response.BookResponse;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.exceptions.BookNotFoundException;
import com.findar.api.bookstore.exceptions.NoAvailableBookException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public BookResponse addBook(BookRequest request) throws BookAlreadyExistException;
    public BookResponse updateBookDetails(String id, BookRequest request) throws BookNotFoundException;
    public List<BookResponse> listAvailableBooks(int pageNumber, int pageSize) throws NoAvailableBookException;



    public String deleteBookFromStore(String id) throws BookNotFoundException;
}
