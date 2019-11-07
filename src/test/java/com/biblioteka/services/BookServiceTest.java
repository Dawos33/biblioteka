package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Book;
import com.biblioteka.entities.BookRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bean;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        bean = new BookService(bookRepository);
    }

    @Test
    public void addBook() {
        Book book = GenericBuilder.of(Book::new)
                .with(Book::setIsbn, "1234567891")
                .with(Book::setTitle, "Test")
                .with(Book::setAuthorName, "Jan")
                .with(Book::setAuthorSurname, "Kowalski")
                .with(Book::setPublishingHouse, "publishingHouse")
                .with(Book::setPublishingYear, 2018)
                .with(Book::setDescription, "Opis ksiazki")
                .build();

        bean.addBook("1234567891", "Test", "Jan", "Kowalski", "publishingHouse", 2018, "Opis ksiazki");

        verify(bookRepository, times(1)).save(book);

    }

    /*@Test
    public void findBookById() {
    }*/
}