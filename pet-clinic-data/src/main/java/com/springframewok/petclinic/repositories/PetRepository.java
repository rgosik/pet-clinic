package com.springframewok.petclinic.repositories;

import com.springframewok.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
