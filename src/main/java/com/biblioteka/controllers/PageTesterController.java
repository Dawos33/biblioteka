package com.biblioteka.controllers;

import com.biblioteka.entities.Book;
import com.biblioteka.entities.BookRepository;
import com.biblioteka.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PageTesterController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    public PageTesterController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/hello")
    public String helloPage() {
        return "Hello World";
    }

    /*@GetMapping("/addBook")
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
    }*/

    /*@PostMapping(path = "/addBook2")
    public void addBook2(@RequestBody String isbn, String title, String authorName, String authorSurname, String publishingHouse, Integer publishingYear, String description) {
        bookService.addBook(isbn, title, authorName, authorSurname, publishingHouse, publishingYear, description);
    }*/

    @RequestMapping("/dbTest")
    //@RequestBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        Book book = new Book().withIsbn("21212342");
        bookRepository.save(book);

        for (Book i : bookRepository.findAll()) {
            response.append(i).append("<br>");
        }

        return response.toString();

    }
}
