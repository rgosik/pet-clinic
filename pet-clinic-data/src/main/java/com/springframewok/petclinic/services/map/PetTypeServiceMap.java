package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.PetType;
import com.springframewok.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractServiceMap<PetType> implements PetTypeService{
}
