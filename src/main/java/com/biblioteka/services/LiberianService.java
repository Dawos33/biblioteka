package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Liberian;
import com.biblioteka.entities.LiberianRepository;
import org.springframework.stereotype.Service;

@Service
public class LiberianService {
    private final LiberianRepository liberianRepository;

    public LiberianService(LiberianRepository liberianRepository) {
        this.liberianRepository = liberianRepository;
    }

    public void addLiberian(String login, String password){

        liberianRepository.save(GenericBuilder.of(Liberian::new)
                .with(Liberian:: setLogin, login)
                .with(Liberian::setPassword, password)
                .build());
    }
}
