package com.biblioteka.authorization.repository;

import com.biblioteka.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
