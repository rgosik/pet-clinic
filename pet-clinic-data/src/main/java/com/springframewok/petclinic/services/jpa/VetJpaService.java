package com.springframewok.petclinic.services.jpa;

import com.springframewok.petclinic.model.Vet;
import com.springframewok.petclinic.repositories.VetRepository;
import com.springframewok.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetJpaService extends AbstractJpaService<Vet, VetRepository> implements VetService {
    public VetJpaService(VetRepository repository) {
        super(repository);
    }
}
