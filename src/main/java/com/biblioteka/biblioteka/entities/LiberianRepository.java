package com.biblioteka.biblioteka.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiberianRepository extends CrudRepository<Liberian, Integer> {
}
