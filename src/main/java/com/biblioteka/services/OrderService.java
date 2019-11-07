package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Book;
import com.biblioteka.entities.Order;
import com.biblioteka.entities.OrderRepository;
import com.biblioteka.entities.Reader;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(List<Book> books, Reader reader, Date orderDate, Date receptionDate, Date returnDate, Date deadline){
        orderRepository.save(GenericBuilder.of(Order::new)
                .with(Order::setBooks, books)
                .with(Order::setReader, reader)
                .with(Order::setOrderDate, orderDate)
                .with(Order::setReceptionDate, receptionDate)
                .with(Order::setReturnDate, returnDate)
                .with(Order::setDeadline, deadline)
                .build());
    }
}
