package com.springframewok.petclinic.repositories;

import com.springframewok.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<Specialty, Long> {
}
