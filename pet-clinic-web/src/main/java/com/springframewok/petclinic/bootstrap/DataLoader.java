package com.springframewok.petclinic.bootstrap;


import com.springframewok.petclinic.model.*;
import com.springframewok.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bob");
        owner1.setLastName("Jet");
        owner1.setAddress("Lelus");
        owner1.setCity("Miami");
        owner1.setTelephone("12125677");

        Pet bobsPet = new Pet();
        bobsPet.setPetType(savedDogType);
        bobsPet.setOwner(owner1);
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setName("Chili");
        owner1.getPets().add(bobsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jhon");
        owner2.setLastName("cena");
        owner2.setAddress("Brooklyn");
        owner2.setCity("New York");
        owner2.setTelephone("45678900");

        Pet jhonsPet = new Pet();
        jhonsPet.setPetType(savedCatType);
        jhonsPet.setOwner(owner2);
        jhonsPet.setBirthDate(LocalDate.now());
        jhonsPet.setName("Mili");
        owner2.getPets().add(jhonsPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(jhonsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Nice kiitten check");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Keke");
        vet1.setLastName("Let");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Troy");
        vet2.setLastName("Pler");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
    }
}
