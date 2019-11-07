package com.biblioteka.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List findByTitle(String title);
    List findByAuthorSurname(String surname);
    List findBookByAuthorSurnameOrTitle(String surname, String title);
    Book deleteBookById(Integer id);
    Optional<Book> findById(Integer id);



}
