package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.Owner;
import com.springframewok.petclinic.services.OwnerService;
import com.springframewok.petclinic.services.PetService;
import com.springframewok.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractServiceMap<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {

        if (object.getPets() != null) {
            object.getPets().forEach(pet -> {
                if (pet.getId() == null) {
                    petService.save(pet);
                }
                if (pet.getPetType().getId() == null) {
                    petTypeService.save(pet.getPetType());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

}
