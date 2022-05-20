package com.bnta.vet_service;

import com.bnta.vet_service.models.Pet;
import com.bnta.vet_service.repositories.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class VetServiceApplicationTests {

	@Autowired
	PetRepository petRepository;

	@Test
	void contextLoads() {
	}


	//running test for derived query to make sure it works
	@Test
	public void canFindDogsInPets(){
		//if I were expecting a list of pets
		//going to call it found
		//then if I accessed petRepository + run method findPetByType
		//pass in dog
		//assert that only expecting
		List<Pet> found = petRepository.findPetByType("dog");
		assertThat(found.size()).isEqualTo(2);
	}

}