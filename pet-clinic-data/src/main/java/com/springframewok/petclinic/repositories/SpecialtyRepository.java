package com.springframewok.petclinic.repositories;

import com.springframewok.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
