package com.demo;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Owner;
import com.demo.entities.Pet;
import com.demo.service.OwnerService;
import com.demo.service.PetService;
import com.demo.util.InputUtil;



@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private PetService petService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					Owner owner = InputUtil.acceptOwnerDetailsToSave(scanner);
					Pet pet = InputUtil.acceptPetDetailsToSave(scanner);
					owner.setPet(pet);
					ownerService.saveOwner(owner);
					System.out.println("Saved owner successfully.");
					break;
				case 2:
					int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					owner = ownerService.findOwnerById(ownerId);
					System.out.println(String.format("Found owner with ownerId %s.", ownerId));
					System.out.println(owner);
					break;
				case 3:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
					ownerService.updatePetonOwner(ownerId, petName);
					System.out.println(
							String.format("Updated petName to %s for owner with ownerId %s.", petName, ownerId));
					break;
				case 4:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerService.deleteOwner(ownerId);
					System.out.println(String.format("Deleted owner with ownerId %s.", ownerId));
					break;
				case 5:
					List<Owner> ownerList = ownerService.findAll();
					System.out.println(String.format("There are %s owners.", ownerList.size()));
					ownerList.forEach(System.out::println);
					break;
				case 6:
					int petId = InputUtil.acceptPetIdToOperate(scanner);
					pet = petService.findPet(petId);
					System.out.println(String.format("Found pet with petId %s.", petId));
					System.out.println(pet);
					break;
				case 7:
//					double averageAge = petService.findAverageAgeOfPet();
//					System.out.println(String.format("Average age of pet is %s years.", averageAge));
//					break;
//				case 8:
					int pageNumber = InputUtil.acceptPageNumberToOperate(scanner);
					int pageSize = InputUtil.acceptPageSizeToOperate(scanner);
					System.out.println(pageNumber +" and "+pageSize);
					List<Object[]> detailsList = ownerService
							.findIdAndFirstNameAndLastNameAndPetNameOfPaginatedOwners(pageNumber - 1, pageSize);
					System.out.println(
							String.format("Showing %s records on page number %s.", detailsList.size(), pageNumber));				
					detailsList.forEach(details -> System.out
							.println(String.format("ownerId: %s, firstName: %s, lastName: %s, petName: %s", details[0],
									details[1], details[2], details[3])));
					break;
				default:
					System.out.println("Invalid option entered.");
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
	}

}
