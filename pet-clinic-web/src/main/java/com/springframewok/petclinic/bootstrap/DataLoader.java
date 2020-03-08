package com.springframewok.petclinic.bootstrap;


import com.springframewok.petclinic.model.Owner;
import com.springframewok.petclinic.model.Vet;
import com.springframewok.petclinic.services.OwnerService;
import com.springframewok.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 =  new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Bob");
        owner1.setLastNmae("Jet");

        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Keke");
        vet1.setLastNmae("Let");

        vetService.save(vet1);
    }
}
