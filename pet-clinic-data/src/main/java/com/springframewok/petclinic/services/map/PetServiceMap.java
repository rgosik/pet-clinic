package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.Pet;
import com.springframewok.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractServiceMap<Pet> implements PetService {
}
