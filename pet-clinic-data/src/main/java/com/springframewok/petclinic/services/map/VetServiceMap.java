package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.Vet;
import com.springframewok.petclinic.services.SpecialtyService;
import com.springframewok.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        object.getSpecialities().forEach(speciality -> {
            if (speciality.getId() == null) {
                specialtyService.save(speciality);
            }
        });
        return super.save(object);
    }

}
