package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Pet;
import com.demo.exception.PetNotFoundExpection;
import com.demo.repo.PetRepo;

@Service
public class PetService {
	
	private PetRepo petRepo;
	
	private String petNotFound="pet not found";

	public PetService(PetRepo petRepo
//			,@Value("${pet.not.found}") String petNotFound
			) {
		this.petRepo = petRepo;
//		this.petNotFound = petNotFound;
	}
	
	public void addPet(Pet pet) {
		petRepo.save(pet);
		
	}
	
	public Pet findPet(int id) throws PetNotFoundExpection{
		return petRepo.findById(id)
				.orElseThrow(() -> new PetNotFoundExpection(String.format(petNotFound)));
		}
	
	public List<Pet> findAllPet(){
		return petRepo.findAllPet();
	}
}
