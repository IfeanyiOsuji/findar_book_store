package com.findar.api.bookstore;

import com.findar.api.bookstore.dto.request.BookRequest;
import com.findar.api.bookstore.dto.response.BookResponse;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.repository.BookRepository;
import com.findar.api.bookstore.services.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceImplTest {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private BookRepository repository;
    @Test
    void contextLoads() {
    }
    @Test
    public void testBookCanBeAdded() throws BookAlreadyExistException {
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
        assertThat(savedBook).isNotNull();

    }
    @Test
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

}
