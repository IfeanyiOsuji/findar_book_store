package com.findar.api.bookstore.services;

import com.findar.api.bookstore.dto.request.BookRequest;
import com.findar.api.bookstore.dto.response.BookResponse;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.exceptions.BookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    public BookResponse addBook(BookRequest request) throws BookAlreadyExistException;
    public BookResponse updateBookDetails(String id, BookRequest request) throws BookNotFoundException;
    public Page<BookResponse> listAvailableBooks(int pageNumber, int pageSize);



    public String deleteBookFromStore(String id);
}
