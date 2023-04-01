package com.masai.Ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.CrimeDao;
import com.masai.dao.CrimeDaoImpl;
import com.masai.dto.CrimeDto;
import com.masai.dto.CrimeDtoImpl;
import com.masai.exception.SomethingWentWrongException;

public class CrimeUi {

	public static void addCrimeDetails(Scanner sc) {
		System.out.println("Enter the crime type like -> Robbery, Theft, Homicide ");
		String type = sc.next();
		
		System.out.println("Write some Description ");
		sc.nextLine();
		String desctiption = sc.nextLine();
		
		System.out.println("Police station area with district");
//		sc.nextLine();
		String ps_area = sc.nextLine();
		
		System.out.println("Enter Date ");
		LocalDate  date = LocalDate.parse(sc.next());
		
		System.out.println("Enter the victim name ");
		sc.nextLine();
		String victim_name = sc.nextLine();
		
		CrimeDto crimeDto = new CrimeDtoImpl(type, desctiption, ps_area, date, victim_name);
		CrimeDao crimeDao = new CrimeDaoImpl();
		
		try {
			crimeDao.addCrimedetails(crimeDto);
			System.out.println("Data added successfully ");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void updateCrimeDetails(Scanner sc) {
		System.out.print("Enter the Crime ID ");
		int crimeID = sc.nextInt();
		System.out.print("Enter the crime type like -> Robbery, Theft, Homicide ");
		String type = sc.next();
		
		System.out.print("Write some Description ");
		sc.nextLine();
		String desctiption = sc.nextLine();
		
		System.out.print("Police station area with district ");
//		sc.nextLine();
		String ps_area = sc.nextLine();
		
		System.out.print("Enter Date ");
		LocalDate  date = LocalDate.parse(sc.next());
		
		System.out.print("Enter the victim name ");
		sc.nextLine();
		String victim_name = sc.nextLine();
		
		CrimeDto crimeDto = new CrimeDtoImpl(crimeID,type, desctiption, ps_area, date, victim_name);
		CrimeDao crimeDao = new CrimeDaoImpl();
		
		try {
			crimeDao.updateCrimeDetails(crimeDto);
			System.out.println();
			System.out.println("Data updated successfully ");
			System.out.println();
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void deleteCrime(Scanner sc) {
		System.out.print("Enter Crime Id");
		int crimeId = sc.nextInt();
		
        CrimeDao crimeDao = new CrimeDaoImpl();
		
		try {
			crimeDao.deleteCrime(crimeId);
			System.out.println("Data deleted successfully ");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
