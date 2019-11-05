package com.biblioteka.biblioteka.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kategoria")
public class Category {

    @GeneratedValue
    @Id
    @Column(name = "id_kategoria")
    private Integer id;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "category")
    private List<Book> books;

    @Column(name = "nazawa_kategorii")
    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Kategoria{" +
                "id_kategoria=" + id +
                ", nazawa_kategorii='" + categoryName + '\'' +
                '}';
    }
}
