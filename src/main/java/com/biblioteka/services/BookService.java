package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Book;
import com.biblioteka.entities.BookRepository;
import com.biblioteka.entities.Category;
import com.biblioteka.entities.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public void addBook(String isbn, String title, String authorName, String authorSurname, String publishingHouse, Integer publishingYear, String description, Integer idCategory, Integer idOrder) {

        bookRepository.save(GenericBuilder.of(Book::new)
                .with(Book::setIsbn, isbn)
                .with(Book::setTitle, title)
                .with(Book::setAuthorName, authorName)
                .with(Book::setAuthorSurname, authorSurname)
                .with(Book::setPublishingHouse, publishingHouse)
                .with(Book::setPublishingYear, publishingYear)
                .with(Book::setDescription, description)
                .with(Book::setCategory, GenericBuilder.of(Category::new)
                        .with(Category::setId, idCategory)
                        .build())
                .with(Book::setOrder, GenericBuilder.of(Order::new)
                        .with(Order::setId, idOrder)
                        .build())
                .build());
    }

    public Book findBookById(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public void deleteBook (Integer id){
        bookRepository.deleteBookById(id);
    }

}
