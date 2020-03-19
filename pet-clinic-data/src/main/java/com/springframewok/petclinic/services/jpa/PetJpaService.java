package com.springframewok.petclinic.services.jpa;

import com.springframewok.petclinic.model.Pet;
import com.springframewok.petclinic.repositories.PetRepository;
import com.springframewok.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetJpaService extends AbstractJpaService<Pet, PetRepository> implements PetService {
    public PetJpaService(PetRepository repository) {
        super(repository);
    }
}
