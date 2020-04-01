package com.springframewok.petclinic.services.jpa;

import com.springframewok.petclinic.model.Owner;
import com.springframewok.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    final String lastName = "smith";
    Owner returnedOwner;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService service;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(service.findByLastName(any())).thenReturn(returnedOwner);

        Owner smith = service.findByLastName(lastName);

        assertEquals(lastName, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        List<Owner> ownerSet = new ArrayList<>();
        ownerSet.add( Owner.builder().id(1L).build());
        ownerSet.add( Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);


        Set<Owner> owners = service.findAll();

        assertAll(
                () -> assertNotNull(owners),
                () -> assertEquals(2, owners.size())
        );
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));

        Owner owner = service.findById(1L);

        assertEquals(owner.getLastName(), lastName);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnedOwner);

        //deafult "times" is 1
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}