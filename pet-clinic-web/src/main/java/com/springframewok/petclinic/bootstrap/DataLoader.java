package com.springframewok.petclinic.bootstrap;


import com.springframewok.petclinic.model.*;
import com.springframewok.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
        PetType dog = PetType.builder().name("Dog").build();
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = PetType.builder().name("Cat").build();
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = Specialty.builder().description("Radiology").build();
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = Specialty.builder().description("Surgery").build();
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = Specialty.builder().description("Dentistry").build();
        Specialty savedDentistry = specialtyService.save(dentistry);

        Set<Pet> pets1 = new HashSet<>();
        Owner owner1 = Owner.builder().firstName("Bob").lastName("Jet").address("Tetrus").city("Miami").
                telephone("12125677").pets(pets1).build();

        Pet bobsPet1 = Pet.builder().petType(savedDogType).owner(owner1).birthDate(LocalDate.now()).
                name("Chili").build();
        pets1.add(bobsPet1);

        ownerService.save(owner1);

        Set<Pet> pets2 = new HashSet<>();
        Owner owner2 = Owner.builder().firstName("Jack").lastName("Smith").address("Kekus").city("Warsaw").
                telephone("789895968").pets(pets2).build();

        Pet jacksPet1 = Pet.builder().petType(savedCatType).owner(owner2).birthDate(LocalDate.now()).
                name("Meme").build();
        pets2.add(jacksPet1);

        ownerService.save(owner2);

        Visit catVisit = Visit.builder().pet(jacksPet1).date(LocalDate.now()).description("Nice kitten check").build();

        visitService.save(catVisit);

        Set<Specialty> vet1Specialties = new HashSet<>();
        vet1Specialties.add(savedRadiology);
        Vet vet1 = Vet.builder().firstName("Keke").lastName("Let").specialties(vet1Specialties).build();

        vetService.save(vet1);

        Set<Specialty> vet2Specialties = new HashSet<>();
        vet2Specialties.add(savedDentistry);
        vet2Specialties.add(savedSurgery);
        Vet vet2 = Vet.builder().firstName("Troy").lastName("Pler").specialties(vet2Specialties).build();

        vetService.save(vet2);
    }
}
