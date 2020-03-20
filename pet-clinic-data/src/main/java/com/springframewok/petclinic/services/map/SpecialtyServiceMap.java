package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.Specialty;
import com.springframewok.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty> implements SpecialtyService {
}
