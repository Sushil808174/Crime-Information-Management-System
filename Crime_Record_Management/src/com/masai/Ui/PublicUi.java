package com.masai.Ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.dao.ForPublicDao;
import com.masai.dao.ForPublicDaoImpl;
import com.masai.dto.CrimeDto;
import com.masai.dto.CriminalDto;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masaischool.consoleColor.ConsoleColors;

public class PublicUi {
	
	public static void displayPublicUse() {
		System.out.println();
		System.out.println(ConsoleColors.BOXING+"0. Exit 							");
		System.out.println("1. Total Crime for each police station area for a date range.   ");
		System.out.println("2. Total crime for each crime type for a date range. 		");
		System.out.println("3. Search Criminal by Name. 					");
		System.out.println("4. Search crime by description. 				"+ConsoleColors.RESET);
		System.out.println();
	}
	
	public static void PublicUse(Scanner sc) {
		int choice = 0;
		do {
			displayPublicUse();
			System.out.print(ConsoleColors.GREEN+"Enter Your Choice "+ConsoleColors.RESET);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				crimeForEachPoliceStaForDateRange(sc);
				break;
			case 2:
				crimeForEachCrimeTypeForDateRange(sc);
				break;
			case 3:
				searchCriminalByName(sc);
				break;
			case 4:
				searchCrimeByDescription(sc);
				break;
			case 0:
				System.out.println("Thank You ");
				break;
			default:
				throw new IllegalArgumentException(ConsoleColors.RED+"Invalid choice you have entered. "+ConsoleColors.RESET);
			}
			
		}while(choice!=0);
		
		
	}

	private static void searchCrimeByDescription(Scanner sc) {
		
		System.out.print(ConsoleColors.GREEN+"Enter Your Description "+ConsoleColors.RESET);
		sc.nextLine();
		String des = sc.nextLine();
		
		ForPublicDao forPublic = new ForPublicDaoImpl();
		
		try {
			List<CrimeDto> crimeDes = forPublic.searchCrimeByDescription(des);
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			crimeDes.forEach(System.out::print);
			System.out.println(ConsoleColors.RESET);
			
		} catch (SomethingWentWrongException |NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void searchCriminalByName(Scanner sc) {
		System.out.print(ConsoleColors.GREEN+"Enter criminal name that you want to search "+ConsoleColors.RESET);
		sc.nextLine();
		String name = sc.nextLine();
		
		ForPublicDao publicDao = new ForPublicDaoImpl();
		try {
			List<CriminalDto> criminal = publicDao.searchCriminalByName(name);
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			criminal.forEach(System.out::print);
			System.out.println(ConsoleColors.RESET);
			
		} catch (SomethingWentWrongException |NoRecordFoundException e) {
			System.out.println(e.getMessage());
		} 
		
	}

	private static void crimeForEachCrimeTypeForDateRange(Scanner sc) {
		System.out.print(ConsoleColors.GREEN+"Enter starting date "+ConsoleColors.RESET);
		LocalDate stDate = LocalDate.parse(sc.next());
		
		System.out.print(ConsoleColors.GREEN+"Enter ending date "+ConsoleColors.RESET);
		LocalDate enDate = LocalDate.parse(sc.next());
		
		ForPublicDao publicDao = new ForPublicDaoImpl();
		
		try {
			Map<String,Integer> map = publicDao.crimeForEachCrimeTypeForDateRange(stDate, enDate);
			System.out.println();
			for(Map.Entry<String, Integer> em:map.entrySet()) {
				System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND+em.getKey()+" -> "+em.getValue()+ConsoleColors.RESET);
			}
			System.out.println();
		} catch (SomethingWentWrongException |NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void crimeForEachPoliceStaForDateRange(Scanner sc) {
		System.out.print(ConsoleColors.GREEN+"Enter starting date ");
		LocalDate stDate = LocalDate.parse(sc.next());
		
		System.out.print(ConsoleColors.GREEN+"Enter ending date "+ConsoleColors.RESET);
		LocalDate enDate = LocalDate.parse(sc.next());
		
		ForPublicDao publicDao = new ForPublicDaoImpl();
		
		try {
			Map<String,Integer> map = publicDao.crimeForEachPoliceStaForDateRange(stDate, enDate);
			System.out.println();
			for(Map.Entry<String, Integer> em:map.entrySet()) {
				System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND+em.getKey()+" -> "+em.getValue()+ConsoleColors.RESET);
			}
			System.out.println();
		} catch (SomethingWentWrongException |NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
