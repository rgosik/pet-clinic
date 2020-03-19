package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.PetType;
import com.springframewok.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService{
}
