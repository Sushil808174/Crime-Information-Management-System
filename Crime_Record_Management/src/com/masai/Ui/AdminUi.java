package com.masai.Ui;

import java.util.Scanner;

public class AdminUi {
	
	public static void displayAdminInterface() {
		System.out.println("0. Logout his account ");
		System.out.println("1. Add Crime Details ");
		System.out.println("2. Update Crime Details ");
		System.out.println("3. Add Criminal Details ");
		System.out.println("4. Update Criminal Details ");
		System.out.println("5. Assign Criminal to Crime ");
		System.out.println("6. Remove Criminal from Crime ");
		System.out.println("7. Delete Crime using Crime Id ");
		System.out.println("8. Delete Criminal using criminal Id ");
		
	}
	
	
	public static void Login(Scanner sc) {
		System.out.println("Please Enter your User Name ");
		String userName = sc.next();
		
		System.out.println("Please Enter your password ");
		String password = sc.next();
		
		if("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password)) {
			System.out.println("Login Successfully ");
			
			int choice = 0;
			do {
				displayAdminInterface();
				System.out.println("Enter Your choice ");
				choice = sc.nextInt();
				
				switch (choice) {
				case 1: 
					CrimeUi.addCrimeDetails(sc);
					break;
				case 2: 
					CrimeUi.updateCrimeDetails(sc);
					break;	
				case 3: 
					CriminalUi.addCriminalDetails(sc);
					break;
				case 4:
					CriminalUi.updateCriminalDetails(sc);
					break;
				case 5:
					Crime_CriminalUi.assignCriminalToCrime(sc);
					break;
				case 6:
					Crime_CriminalUi.removeCriminalFromCrime(sc);
					break;
				case 7:
					CrimeUi.deleteCrime(sc);
					break;
				case 8:
					CriminalUi.deleteCriminal(sc);
					break;
				case 0:
					System.out.println("Admin Logout ");
					break;
				default:
					System.out.println("Invalid Input ");
				}
				
				
				
			}while(choice!=0);
		}else {
			System.out.println("Username or Password is wrong ");
		}
	}

}
