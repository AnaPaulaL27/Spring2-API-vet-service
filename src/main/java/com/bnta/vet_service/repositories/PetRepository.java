package com.bnta.vet_service.repositories;

import com.bnta.vet_service.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

//to make the decision of where query lives, we want  a list of dogs, i.e. pets, hence query lives in pet repo
//return all pets with the type dog

        //using derived query format - operation you want to do (e.g., find, read, count or get), type of object you expect
        //back from the query + then property of object + whether it will be an and or and 'or'

        //we are trying to 'find' the dogs=pet, so Pet by its Type

        List<Pet> findPetByType(String type);

    }

