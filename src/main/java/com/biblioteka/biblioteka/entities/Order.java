package com.biblioteka.biblioteka.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zamowienie")
public class Order {
    @Id
    @Column(name = "id_zamowienie")
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Book> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_czytelnika")
    private Reader reader;

    @Column(name = "data_zamowienia")
    private String isbn;

    @Column(name = "data_odbioru")
    private String title;

    @Column(name = "data_zwrotu")
    private String authorName;

    @Column(name = "termin_zwrotu")
    private String authorSurname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", books=" + books +
                ", reader=" + reader +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                '}';
    }
}
