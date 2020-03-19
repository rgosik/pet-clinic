package com.springframewok.petclinic.repositories;

import com.springframewok.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
