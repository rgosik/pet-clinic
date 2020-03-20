package com.springframewok.petclinic.services.jpa;

import com.springframewok.petclinic.model.Visit;
import com.springframewok.petclinic.repositories.VisitRepository;
import com.springframewok.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository> implements VisitService {
    public VisitJpaService(VisitRepository repository) {
        super(repository);
    }
}
