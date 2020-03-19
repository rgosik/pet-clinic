package com.springframewok.petclinic.services;

import com.springframewok.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner> {

    Owner findByLastName(String lastName);
}
