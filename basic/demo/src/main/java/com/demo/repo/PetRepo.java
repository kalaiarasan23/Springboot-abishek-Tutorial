package com.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.demo.entities.Pet;

@Repository
public class PetRepo {
	List<Pet> petrepo;

	public PetRepo() {
		petrepo = new ArrayList<>();
	}

	public Optional<Pet> findById(int petId){
		return petrepo.stream()
				.filter(pet -> pet.getId()==petId)
				.findFirst();
	}
	
	public List<Pet> findAllPet() {
		return petrepo;
	}

	public void save(Pet pet) {
		petrepo.add(pet);
		System.out.println("pet successfully ");
		
	}
}
