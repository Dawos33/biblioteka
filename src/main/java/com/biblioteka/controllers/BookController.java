package com.biblioteka.controllers;

import com.biblioteka.entities.Book;
import com.biblioteka.entities.BookRepository;
import com.biblioteka.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
                        @RequestParam(value = "description", required = false) String description,
                        @RequestParam("id_kategoria") Integer idCategory,
                        @RequestParam(value = "id_order", required = false) Integer idOrder) {
        bookService.addBook(isbn, title, authorName, authorSurname, publishingHouse, publishingYear, description, idCategory, idOrder);
    }

    @PostMapping("/updateBook")
    public void updateBook(@Valid @RequestBody Book book){
        bookRepository.save(book);
    }
    @DeleteMapping(value = "/book/{id}")
    public void deleteBokk (@PathVariable("id") Integer id){
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List getBookByAuthorOrTitle(@RequestParam(value = "authorSurname", required = false) String authorSurname,
                                       @RequestParam(value = "title", required = false) String title){

        return bookRepository.findBookByAuthorSurnameOrTitle(authorSurname, title);
    }


}
