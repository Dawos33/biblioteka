package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Book;
import com.biblioteka.entities.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public void addBook(String isbn, String title, String authorName, String authorSurname, String publishingHouse, Integer publishingYear, String description) {

        bookRepository.save(GenericBuilder.of(Book::new)
                .with(Book::setIsbn, isbn)
                .with(Book::setTitle, title)
                .with(Book::setAuthorName, authorName)
                .with(Book::setAuthorSurname, authorSurname)
                .with(Book::setPublishingHouse, publishingHouse)
                .with(Book::setPublishingYear, publishingYear)
                .with(Book::setDescription, description)
                .build());

    }

}
