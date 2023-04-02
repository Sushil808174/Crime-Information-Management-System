package com.masai.Ui;

import java.util.Scanner;

import com.masaischool.consoleColor.ConsoleColors;

public class AdminUi {
	
	public static void displayAdminInterface() {
		System.out.println();
		System.out.println(ConsoleColors.BOXING+"0. Logout his account 		     ");
		System.out.println("1. Add Crime Details 		     ");
		System.out.println("2. Update Crime Details 	     ");
		System.out.println("3. Add Criminal Details 	     ");
		System.out.println("4. Update Criminal Details 	     ");
		System.out.println("5. Assign Criminal to Crime 	     ");
		System.out.println("6. Remove Criminal from Crime 	     ");
		System.out.println("7. Delete Crime using Crime Id 	     ");
		System.out.println("8. Delete Criminal using criminal Id "+ConsoleColors.RESET);
		System.out.println();
	}
	
	
	public static void Login(Scanner sc) {
		System.out.println(ConsoleColors.GREEN+"Please Enter your User Name "+ConsoleColors.RESET);
		String userName = sc.next();
		
		System.out.println(ConsoleColors.GREEN+"Please Enter your password "+ConsoleColors.RESET);
		String password = sc.next();
		
		if("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password)) {
			System.out.println(ConsoleColors.BLUE_ITALIC+ConsoleColors.WHITE_BACKGROUND+"Login Successfully "+ConsoleColors.RESET);
			
			int choice = 0;
			do {
				displayAdminInterface();
				System.out.println(ConsoleColors.GREEN+"Enter Your choice "+ConsoleColors.RESET);
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
					System.out.println(ConsoleColors.YELLOW+"Admin Logout "+ConsoleColors.RESET);
					break;
				default:
					System.out.println(ConsoleColors.RED+"Invalid Input "+ConsoleColors.RESET);
				}
				
				
				
			}while(choice!=0);
		}else {
			System.out.println(ConsoleColors.RED+"Username or Password is wrong "+ConsoleColors.RESET);
		}
	}

}
