package com.demo.util;

import java.util.Arrays;
import java.util.Scanner;

import com.demo.entities.Owner;
import com.demo.entities.Pet;
import com.demo.enumValue.Gender;

public class InputUtil {
	
	private InputUtil() {
		
	}
	
	public static int acceptMenuOption(Scanner scanner) {
		System.out.println("Press 1 to add new owner.");
		System.out.println("Press 2 to fetch owner details.");
		System.out.println("Press 3 to updated pet details of owner.");
		System.out.println("Press 4 to delete owner details.");
		System.out.println("Press 5 to fetch all owners.");
		System.out.println("Press 6 to fetch pet details.");
//		System.out.println("Press 7 to find average age of pet.");
		System.out.println("Press 7 to find specific details using pagination.");
		int menuOption = scanner.nextInt();
		if (menuOption >= 1 && menuOption <= 7) {
			return menuOption;
		} else {
			System.out.println("Invalid option entered.");
			return acceptMenuOption(scanner);
		}
	}

	public static boolean wantToContinue(Scanner scanner) {
		System.out.println("Press Y to continue and N to exit.");
		char choice = scanner.next().toUpperCase().charAt(0);
		return 'Y' == choice;
	}

	public static Owner acceptOwnerDetailsToSave(Scanner scanner) {
//		System.out.println("Enter id of owner:");
//		int id = scanner.nextInt();
		
		System.out.println("Enter first name of owner:");
		String name = scanner.next();
		
//		System.out.println("Enter last name of owner:");
//		String lastName = scanner.next();
		
		System.out.println("Enter gender of owner:" + Arrays.asList(Gender.values()).toString());
		String gender = scanner.next().toUpperCase();
		
		System.out.println("Enter city of owner:");
		String city = scanner.next();
		
		System.out.println("Enter state of owner:");
		String state = scanner.next();
		
//		System.out.println("Enter mobile number of owner:");
//		String mobileNumber = scanner.next();
		
//		System.out.println("Enter email id of owner:");
//		String emailId = scanner.next();
		try {
			Owner Owner = new Owner();
//			Owner.setId(id);
//			Owner.setLastName(lastName);
			Owner.setName(name);
			
			Owner.setGender(Gender.valueOf(gender));
			Owner.setCity(city);
			Owner.setState(state);
			
//			Owner.setMobileNumber(mobileNumber);
//			Owner.setEmailId(emailId);
			return Owner;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return acceptOwnerDetailsToSave(scanner);
		}
	}

	public static Pet acceptPetDetailsToSave(Scanner scanner) {
//		System.out.println("Enter id of pet:");
//		int petId = scanner.nextInt();
		System.out.println("Enter name of pet:");
		String petName = scanner.next();
		
//		System.out.println("Press D for domestic pet and W for wild pet.");
//		char choice = scanner.next().toUpperCase().charAt(0);
		
//		String petPlaceOfBirth = null;
//		String petDateOfBirth = null;
//		if ('W' == choice) {
//			System.out.println("Enter place of birth of pet:");
//			petPlaceOfBirth = scanner.next();
//		} else if ('D' == choice) {
//			System.out.println("Enter date of birth of pet (dd-MM-yyyy):");
//			petDateOfBirth = scanner.next();
//		}
		System.out.println("Enter gender of pet:" + Arrays.asList(Gender.values()).toString());
		String petGender = scanner.next().toUpperCase();
//		System.out.println("Enter pet type:" + Arrays.asList(PetType.values()).toString());
//		String petType = scanner.next().toUpperCase();
		try {
			Pet pet = new Pet();
//			if ('D' == choice) {
//				petDTO = new DomesticPetDTO();
//				((DomesticPetDTO) petDTO).setBirthDate(convertStringToDate(petDateOfBirth));
//			} else if ('W' == choice) {
//				petDTO = new WildPetDTO();
//				((WildPetDTO) petDTO).setBirthPlace(petPlaceOfBirth);
//			} else {
//				throw new IllegalArgumentException("Unsupported pet choice: " + choice);
//			}
//			pet.setId(petId);
			pet.setName(petName);
			pet.setGender(Gender.valueOf(petGender));
//			petDTO.setType(PetType.valueOf(petType));
			return pet;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return acceptPetDetailsToSave(scanner);
		}
	}

	public static String acceptPetDetailsToUpdate(Scanner scanner) {
		System.out.println("Enter updated name of pet:");
		return scanner.next();
	}

	public static int acceptOwnerIdToOperate(Scanner scanner) {
		System.out.println("Enter id of owner:");
		return scanner.nextInt();
	}

	public static int acceptPetIdToOperate(Scanner scanner) {
		System.out.println("Enter id of pet:");
		return scanner.nextInt();
	}
	
	public static int acceptPageSizeToOperate(Scanner scanner) {
		System.out.println("Enter page size:");
		int pageSize = scanner.nextInt();
		if (pageSize > 0) {
			return pageSize;
		} else {
			System.out.println("Page size must be greater than 0.");
			return acceptPageSizeToOperate(scanner);
		}
	}

	public static int acceptPageNumberToOperate(Scanner scanner) {
		System.out.println("Enter page number:");
		int pageNumber = scanner.nextInt();
		if (pageNumber > 0) {
			return pageNumber;
		} else {
			System.out.println("Page number must be greater than 0.");
			return acceptPageNumberToOperate(scanner);
		}
	}

//	private static LocalDate convertStringToDate(String stringDate) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		return LocalDate.parse(stringDate, format);
//	}
	
}
