package com.findar.api.bookstore;

import com.findar.api.bookstore.dto.request.BookRequest;
import com.findar.api.bookstore.dto.response.BookResponse;
import com.findar.api.bookstore.entities.Book;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.exceptions.BookNotFoundException;
import com.findar.api.bookstore.exceptions.NoAvailableBookException;
import com.findar.api.bookstore.repository.BookRepository;
import com.findar.api.bookstore.services.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceImplTest {
    @Autowired
    private BookServiceImpl bookService;
@Autowired
    private BookRepository repository;
    @Test
    @BeforeEach
    void contextLoads() {

    }


    @Test
    @DirtiesContext
    public void testBookCanBeAdded() throws BookAlreadyExistException {
        //given
        BookRequest request = new BookRequest(
                "Physics",
                "Sam",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                10
        );
        //when

        BookResponse savedBook = bookService.addBook(request);

        //then
        assertThat(savedBook).isNotNull();

    }
    @Test
    @DirtiesContext
    public void testBookAlreadyExistException() throws BookAlreadyExistException {
        //given
        BookRequest request = new BookRequest(
                "Biology",
                "Osuji",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                10

        );
        //when
        BookResponse savedBook = bookService.addBook(request);

        //then
        assertThrows(BookAlreadyExistException.class,()->{
            bookService.addBook(request);
        });

    }
    @Test
    @DirtiesContext
    void testBookCanBeUpdated() throws BookNotFoundException {
        //given
        BookRequest request = new BookRequest(
                "Biology",
                "Osuji",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                10

        );
        BookRequest requestToUpdate = new BookRequest(
                "Biology",
                "Osuji",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                500.00,
                20
        );
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getIsbn(),
                request.getGenre(),
                request.getPublicationYear(),
                request.getPrice(),
                request.getQuantityInStock(),
                new Date(),
                new Date()

        );
        //when
        Book bookToSave = repository.save(book);
        BookResponse updatedBook = bookService.updateBookDetails(bookToSave.getId(), requestToUpdate);

        //then
        assertThat(updatedBook).isNotNull();

    }

    @Test
    @DirtiesContext
    void testListAvailableBooks() throws BookAlreadyExistException, NoAvailableBookException {
        //given
        BookRequest request = new BookRequest(
                "Maths",
                "Joy        ",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                10

        );

        BookRequest request1 = new BookRequest(
                "Maths1",
                "Joy1",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                0

        );
        bookService.addBook(request);
        bookService.addBook(request1);

        //when
        List<BookResponse> books = bookService.listAvailableBooks(0, 1);

        //then
        assertThat(books.size()).isEqualTo(1);

    }

    @Test
    @DirtiesContext
    public void testBooksNotAvailableThrowsNoAvailableBooksException() throws BookAlreadyExistException {
        BookRequest request = new BookRequest(
                "English",
                "Mercy",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                0

        );

        BookRequest request1 = new BookRequest(
                "Maths2",
                "Joy2",
                "isbn:oiuuyttrt",
                "textbook",
                "2010",
                200.00,
                0

        );

        //when
        bookService.addBook(request);
        bookService.addBook(request1);

        //then
        assertThrows(NoAvailableBookException.class, ()->{
            bookService.listAvailableBooks(0,1);
        });
    }

}
