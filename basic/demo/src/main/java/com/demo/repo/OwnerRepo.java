package com.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.demo.entities.Owner;

@Repository
public class OwnerRepo {
	
	private List<Owner> ownerRepo ;
	
	public OwnerRepo() {
		ownerRepo = new ArrayList<>();
	}

	public void saveOwner(Owner owner) {
		ownerRepo.add(owner);
		System.out.println("successfully saved");
	}
	

	public Optional<Owner> findById(int ownerId) {
		
		return ownerRepo.stream()
				.filter(owner -> owner.getId() == ownerId)
				.findFirst();
	}
	
	public void updateOwner(Integer id,String petName) {
		ownerRepo.stream()
			.filter(owner -> owner.getId() == id)
			.findFirst()
			.ifPresent(owner -> owner.getPet().setName(petName));
		System.out.println("successfully updated pet name");
	}
	
	public void deleteOwner(Integer id) {
//		owner
		ownerRepo.removeIf(owner -> owner.getId()==id);
	}
	
	public List<Owner> findAll() {
		return ownerRepo;
	}

}
