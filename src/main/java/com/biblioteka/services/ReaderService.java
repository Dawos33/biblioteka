package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Order;
import com.biblioteka.entities.Reader;
import com.biblioteka.entities.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public void addReader(String login, String password, String name, String surname, String address, String city, String postcode, String phoneNumber, String email, List<Order> orders){

        readerRepository.save(GenericBuilder.of(Reader::new)
                .with(Reader::setLogin, login)
                .with(Reader::setPassword, password)
                .with(Reader::setName, name)
                .with(Reader::setSurname,surname)
                .with(Reader::setAddress, address)
                .with(Reader::setCity, city)
                .with(Reader::setPostcode, postcode)
                .with(Reader::setPhoneNumber, phoneNumber)
                .with(Reader::setEmail, email)
                .with(Reader::setOrders, orders)
                .build());
    }
    public void deleteReader(Integer id){
        readerRepository.delete(id);
    }
}
