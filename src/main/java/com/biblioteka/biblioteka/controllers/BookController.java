package com.biblioteka.biblioteka.controllers;

import com.biblioteka.biblioteka.entities.BookRepository;
import com.biblioteka.biblioteka.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }
    @GetMapping("/addBook")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Book created!")
    @ResponseBody
    public void addBook(@RequestParam("isbn") String isbn,
                        @RequestParam("title") String title,
                        @RequestParam("authorName") String authorName,
                        @RequestParam("authorSurname") String authorSurname,
                        @RequestParam("publishingHouse") String publishingHouse,
                        @RequestParam("publishingYear") Integer publishingYear,
                        @RequestParam(value = "description", required = false) String description) {
        bookService.addBook(isbn, title, authorName, authorSurname, publishingHouse, publishingYear, description);
    }
    @GetMapping("/search")
    public List getBookByAuthorOrTitle(@RequestParam(value = "authorSurname", required = false) String authorSurname,
                                       @RequestParam(value = "title", required = false) String title){

        return bookRepository.findBookByAuthorSurnameOrTitle(authorSurname, title);
    }


}
