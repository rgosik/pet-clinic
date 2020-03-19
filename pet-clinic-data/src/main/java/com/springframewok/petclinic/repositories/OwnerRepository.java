package com.springframewok.petclinic.repositories;

import com.springframewok.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
