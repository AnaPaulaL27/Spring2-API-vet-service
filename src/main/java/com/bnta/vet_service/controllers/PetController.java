package com.bnta.vet_service.controllers;


import com.bnta.vet_service.repositories.PetRepository;
import com.bnta.vet_service.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("pets") //localhost:8080/pets
public class PetController {

    @Autowired
    PetRepository petRepository;


    @GetMapping
    public ResponseEntity<List<Pet>>getAllPetsAndFilters(

            @RequestParam(required = false, name = "type" ) String type
    ){

        if(type !=null) {

            return new ResponseEntity<>(petRepository.findPetByType(type),HttpStatus.OK);
        }

        return new ResponseEntity<>(petRepository.findAll(), HttpStatus.OK );
    }


// SHOW

    @GetMapping(value = "/{id}") //the route we are looking for a response on is localhost:8080/pets/1  -- e.g. pet with id=1,
    //{} indicates it's a param

    public ResponseEntity<Optional<Pet>> getPet(@PathVariable Long id){

        return new ResponseEntity<>(petRepository.findById(id),HttpStatus.OK );
    }

    //POST
    @PostMapping

    public ResponseEntity<Pet> createPet(@RequestBody Pet newPet){

        //now save pet into database, use repository
        petRepository.save(newPet);

        //return a response entity-, the new pet + HttpStatus.Created.
        return  new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }
}
