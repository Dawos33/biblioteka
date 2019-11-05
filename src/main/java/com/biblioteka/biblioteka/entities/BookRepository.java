package com.biblioteka.biblioteka.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List findByTitle(String title);
    List findByAuthorSurname(String surname);
    List findBookByAuthorSurnameOrTitle(String surname, String title);
    Book deleteBookById(Integer id);



}
