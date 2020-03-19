package com.springframewok.petclinic.services.jpa;

import com.springframewok.petclinic.model.PetType;

import com.springframewok.petclinic.repositories.PetTypeRepository;
import com.springframewok.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeJpaService extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {
    public PetTypeJpaService(PetTypeRepository repository) {
        super(repository);
    }
}
