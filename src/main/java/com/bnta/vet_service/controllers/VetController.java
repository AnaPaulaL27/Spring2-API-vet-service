package com.bnta.vet_service.controllers;

import com.bnta.vet_service.models.Vet;
import com.bnta.vet_service.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

    @RequestMapping("vets")

    public class VetController {

        @Autowired
        VetRepository vetRepository;

        //first route: INDEX
        //GET /vets
       @GetMapping
        public List<Vet> getAllVets() {
           return vetRepository.findAll();
       }

       //SHOW

        @GetMapping(value = "/{id}") // we are looking for a response on is localhost:8080/vets/1  -- e.g. vet with id=1,

        public ResponseEntity<Optional<Vet>> getVet(@PathVariable Long id){
           return new ResponseEntity<>(vetRepository.findById(id),HttpStatus.OK);
    }

    //POST
    @PostMapping //route is going to be on vets i.e.,: localhost:8080/vets just like the first one we did,

    public ResponseEntity<Vet> createVet(@RequestBody Vet newVet){

           vetRepository.save(newVet);

           return  new ResponseEntity<>(newVet, HttpStatus.CREATED);
    }
}
