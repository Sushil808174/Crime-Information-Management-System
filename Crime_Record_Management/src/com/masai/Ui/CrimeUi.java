package com.masai.Ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dto.CrimeDto;
import com.masai.dto.CrimeDtoImpl;

public class CrimeUi {

	public static void addCrimeDetails(Scanner sc) {
		System.out.println("Enter the crime type like -> Robbery, Theft, Homicide ");
		String type = sc.next();
		
		System.out.println("Write some Description ");
		String desctiption = sc.next();
		
		System.out.println("Police station area ");
		String ps_area = sc.next();
		
		System.out.println("Enter Date ");
		LocalDate  date = LocalDate.parse(sc.next());
		
		System.out.println("Enter the victim name ");
		String victim_name = sc.next();
		
		CrimeDto crimeDto = new CrimeDtoImpl(type, desctiption, ps_area, date, victim_name);
		
		
	}

	public static void updateCrimeDetails(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void deleteCrime(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

}
