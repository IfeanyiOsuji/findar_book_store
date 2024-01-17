package com.findar.api.bookstore.services;

import com.findar.api.bookstore.dto.request.BookRequest;
import com.findar.api.bookstore.dto.response.BookResponse;
import com.findar.api.bookstore.entities.Book;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(final BookRepository repository){
        this.bookRepository = repository;
    }


    @Override
    public BookResponse addBook(BookRequest request) throws BookAlreadyExistException {
        Book book = bookRepository.findByTitle(request.getTitle());
        if(book != null && book.getTitle().equalsIgnoreCase(request.getTitle()) && book.getAuthor().equalsIgnoreCase(request.getAuthor()) && book.getPublicationYear()==request.getPublicationYear()){
            throw new BookAlreadyExistException(String.format("Book with title %s already exist", request.getTitle()));
        }
        Book newBook = new Book(request.getTitle(), request.getAuthor(), request.getIsbn(),
                request.getGenre(), request.getPublicationYear(), request.getPrice(),
                request.getQuantityInStock(), new Date(), new Date());
        Book savedBook =  bookRepository.save(newBook);
        return mapBookToResponse(savedBook);
    }

    @Override
    public BookResponse updateBookDetails(String id, BookRequest request) {
        return null;
    }

    @Override
    public Page<BookResponse> listAvailableBooks(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public String deleteBookFromStore(String id) {
        return null;
    }

    public String checkBookAvailability() {
        return null;
    }
    private BookResponse mapBookToResponse(Book book){

        return  new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getGenre(),
                book.getPublicationYear(),
                book.getPrice(),
                book.getQuantityInStock(),
                book.isAvailable(),
                book.getCreatedAt(),
                book.getUpdatedAt()

        );

    }
}
