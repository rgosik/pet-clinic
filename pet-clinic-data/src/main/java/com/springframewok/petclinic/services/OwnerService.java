package com.springframewok.petclinic.services;

import com.springframewok.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
