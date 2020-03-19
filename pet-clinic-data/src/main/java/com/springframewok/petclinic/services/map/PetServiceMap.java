package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.Pet;
import com.springframewok.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {
}
