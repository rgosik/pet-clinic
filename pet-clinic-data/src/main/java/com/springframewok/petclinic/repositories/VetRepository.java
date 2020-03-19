package com.springframewok.petclinic.repositories;

import com.springframewok.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
