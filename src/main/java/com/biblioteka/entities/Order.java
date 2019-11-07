package com.biblioteka.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "zamowienie")
public class Order {
    @GeneratedValue
    @Id
    @Column(name = "id_zamowienie")
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Book> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_czytelnika")
    private Reader reader;

    @Column(name = "data_zamowienia")
    private Date orderDate;

    @Column(name = "data_odbioru")
    private Date receptionDate;

    @Column(name = "data_zwrotu")
    private Date returnDate;

    @Column(name = "termin_zwrotu")
    private Date deadline;

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", books=" + books +
                ", reader=" + reader +
                ", isbn='" + orderDate + '\'' +
                ", title='" + receptionDate + '\'' +
                ", authorName='" + returnDate + '\'' +
                ", authorSurname='" + deadline + '\'' +
                '}';
    }
}
