package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Admin;
import com.biblioteka.entities.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void addAdmin(String login, String password){
        adminRepository.save(GenericBuilder.of(Admin::new)
                .with(Admin::setLogin, login)
                .with(Admin::setPassword, password)
                .build());
    }
}
