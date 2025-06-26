package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.DomesticPet;
import com.demo.entities.Owner;
import com.demo.entities.Pet;
import com.demo.entities.WildPet;
import com.demo.enumValue.Gender;
import com.demo.exception.OwnerDuplicateException;
import com.demo.exception.OwnerNotFoundException;
import com.demo.repo.OwnerRepo;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepo ownerRepo;

	private final String ownerAlreadyExist = "owner already exist";
	private final String ownerNotFound = "owner not found";

	public OwnerService(OwnerRepo ownerRepo
//			@Value("${owner.already.exists}") String ownerAlreadyExist, 
//			@Value("${owner.not.found}") String ownerNotFound
	) {
		this.ownerRepo = ownerRepo;
		saveInitValue();
//		this.ownerAlreadyExist = ownerAlreadyExist;
//		this.ownerNotFound = ownerNotFound;
	}

	public void saveOwner(Owner owner) throws OwnerDuplicateException {
		if (ownerRepo.findById(owner.getId()).isEmpty()) {
			ownerRepo.saveOwner(owner);
		} else {
			System.out.println();
			throw new OwnerDuplicateException(String.format(ownerAlreadyExist));
		}
	}

	public Owner findOwnerById(int id) throws OwnerNotFoundException {
		return ownerRepo.findById(id).orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound)));
	}

	public void updatePetonOwner(int id, String string) throws OwnerNotFoundException {
		if (ownerRepo.findById(id).isPresent()) {
			ownerRepo.updateOwner(id, string);
		} else {
			throw new OwnerNotFoundException(String.format(ownerNotFound));
		}
	}

	public void deleteOwner(int id) throws OwnerNotFoundException {

		if (ownerRepo.findById(id).isPresent()) {
			ownerRepo.deleteOwner(id);
		} else {
			throw new OwnerNotFoundException(String.format(ownerNotFound));
		}
	}

	public List<Owner> findAll() {
		return ownerRepo.findAll();
	}

	public List<Object[]> findIdAndFirstNameAndLastNameAndPetNameOfPaginatedOwners(int pageNumber, int pageSize) {
		List<Owner> ownerList = ownerRepo.findAll();

		return ownerList.stream() // get the steam of
				.skip((long) pageNumber * pageSize) // skip method return long, 0,3 => 1 to 3 then 1,3 => 4 to 6 then
													// 2,3 => 7 to 9 if 1,5 => 6 to 10
				.limit(pageSize) // limit it show only limit the page
									// map -> get id,name,petname as list of above result
				.map(owner -> new Object[] { owner.getId(), owner.getName(),owner.getCity(), owner.getPet().getName() })
				.toList(); 																						
		// convert into list
	}

	public void saveInitValue() {
		Owner owner1 = new Owner();
			owner1.setName("raja");
			owner1.setAge(30);
			owner1.setGender(Gender.valueOf("M"));
			owner1.setCity("Theni");
			owner1.setState("TN");
		Pet pet = new DomesticPet();
			pet.setName("janu");
			pet.setGender(Gender.valueOf("F"));
			((DomesticPet)pet).setDob("2.2.2010");
		
		owner1.setPet(pet);
		ownerRepo.saveOwner(owner1);

		Owner owner2 = new Owner();
			owner2.setName("raja");
			owner2.setAge(30);
			owner2.setGender(Gender.valueOf("M"));
			owner2.setCity("Theni");
			owner2.setState("TN");
		Pet pet2 = new WildPet();
			pet2.setName("yanna");
			pet2.setGender(Gender.valueOf("F"));
			((WildPet)pet2).setPlace("rajapalaiyam");
			owner2.setPet(pet2);
			
		ownerRepo.saveOwner(owner2);

		Owner owner3 = new Owner();
			owner3.setName("raja");
			owner3.setAge(30);
			owner3.setGender(Gender.valueOf("M"));
			owner3.setCity("Theni");
			owner3.setState("TN");
		Pet pet3 = new DomesticPet();
			pet3.setName("icala");
			pet3.setGender(Gender.valueOf("M"));
			owner3.setPet(pet3);
			((DomesticPet)pet3).setDob("2.2.2010");
		ownerRepo.saveOwner(owner3);

		Owner owner4 = new Owner();
			owner4.setName("mohan");
			owner4.setAge(24);
			owner4.setGender(Gender.valueOf("M"));
			owner4.setCity("madurai");
			owner4.setState("TN");
		Pet pet4 = new WildPet();
			pet4.setName("john");
			pet4.setGender(Gender.valueOf("F"));
			((WildPet)pet4).setPlace("madurai");
			owner4.setPet(pet4);
		ownerRepo.saveOwner(owner4);

		Owner owner5 = new Owner();
			owner5.setName("ammu");
			owner5.setAge(32);
			owner5.setGender(Gender.valueOf("M"));
			owner5.setCity("thirumal");
			owner5.setState("TN");
		Pet pet5 = new DomesticPet();
			pet5.setName("jakie");
			pet5.setGender(Gender.valueOf("M"));
			((DomesticPet)pet5).setDob("2.2.2010");
			owner5.setPet(pet5);
		ownerRepo.saveOwner(owner5);
	}
}
