package com.springframewok.petclinic.services.jpa;

import com.springframewok.petclinic.model.Specialty;
import com.springframewok.petclinic.repositories.SpecialtyRepository;
import com.springframewok.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialtyJpaService extends AbstractJpaService<Specialty, SpecialtyRepository> implements SpecialtyService {
    public SpecialtyJpaService(SpecialtyRepository repository) {
        super(repository);
    }
}
