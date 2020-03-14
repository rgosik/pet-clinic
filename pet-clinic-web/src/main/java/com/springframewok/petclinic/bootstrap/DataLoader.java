package com.springframewok.petclinic.bootstrap;


import com.springframewok.petclinic.model.Owner;
import com.springframewok.petclinic.model.PetType;
import com.springframewok.petclinic.model.Vet;
import com.springframewok.petclinic.services.OwnerService;
import com.springframewok.petclinic.services.PetTypeService;
import com.springframewok.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog1");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat1");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bob");
        owner1.setLastName("Jet");

        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Keke");
        vet1.setLastName("Let");

        vetService.save(vet1);
    }
}
