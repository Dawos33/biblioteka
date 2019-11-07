package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Book;
import com.biblioteka.entities.BookRepository;
import com.biblioteka.entities.Category;
import com.biblioteka.entities.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
                .with(Book::setId,1)
                .with(Book::setIsbn, "1234567891")
                .with(Book::setTitle, "Test")
                .with(Book::setAuthorName, "Jan")
                .with(Book::setAuthorSurname, "Kowalski")
                .with(Book::setPublishingHouse, "publishingHouse")
                .with(Book::setPublishingYear, 2018)
                .with(Book::setDescription, "Opis ksiazki")
                .with(Book::setCategory, GenericBuilder.of(Category::new)
                        .with(Category::setId, 1)
                        .build())
                .with(Book::setOrder, GenericBuilder.of(Order::new)
                        .with(Order::setId, 1)
                        .build())
                .build();

        bean.addBook("1234567891", "Test", "Jan", "Kowalski", "publishingHouse", 2018, "Opis ksiazki", 1, 1);

        verify(bookRepository, times(1)).save(book);

    }

    @Test
    public void findBookById() {
        when(bookRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(GenericBuilder.of(Book::new)
                .with(Book::setId, 1)
                .with(Book::setIsbn, "1234567891")
                .with(Book::setTitle, "Test")
                .with(Book::setAuthorName, "Jan")
                .with(Book::setAuthorSurname, "Kowalski")
                .with(Book::setPublishingHouse, "publishingHouse")
                .with(Book::setPublishingYear, 2018)
                .with(Book::setDescription, "Opis ksiazki")
                .with(Book::setCategory, GenericBuilder.of(Category::new)
                        .with(Category::setId, 1)
                        .build())
                .with(Book::setOrder, GenericBuilder.of(Order::new)
                        .with(Order::setId, 1)
                        .build())
                .build()));

        Book book = bean.findBookById(1);

        assertEquals("Test", book.getTitle());
        assertEquals("Kowalski", book.getAuthorSurname());
        assertEquals("Opis ksiazki", book.getDescription());

    }
}