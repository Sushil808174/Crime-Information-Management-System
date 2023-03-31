package com.masai.Ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.CriminalDao;
import com.masai.dao.CriminalDaoImpl;
import com.masai.dto.CriminalDto;
import com.masai.dto.CriminalDtoImpl;
import com.masai.exception.SomethingWentWrongException;

public class CriminalUi {

	public static void addCriminalDetails(Scanner sc) {
		System.out.println("Enter the Criminal Name ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("Enter Date of Birth, Format should be like that (YYYY-MM-DD)");
		LocalDate  dob = LocalDate.parse(sc.next());
		
		System.out.println("Enter Gender ");
		String gender = sc.next();
		
		System.out.println("Enter identifying_mark ");
		sc.nextLine();
		String identifying_mark = sc.nextLine();
		
		System.out.println("Enter first arrested date ");
		LocalDate first_arrest_date = LocalDate.parse(sc.next());
		
		System.out.println("Enter the arrested_from_ps_area ");
		sc.nextLine();
		String arrested_from_ps_area = sc.nextLine();
		
		
		CriminalDto criminalDto = new CriminalDtoImpl(name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area);
		CriminalDao criminalDao = new CriminalDaoImpl();
		
		try {
			criminalDao.addCriminalDetails(criminalDto);
			System.out.println("Criminal data added successfully ");
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
	}

	public static void updateCriminalDetails(Scanner sc) {
		System.out.println("Enter the Criminal Id ");
		int criminal_id = sc.nextInt();
		
		System.out.println("Enter the Criminal Name ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("Enter Date of Birth, Format should be like that (YYYY-MM-DD)");
		LocalDate  dob = LocalDate.parse(sc.next());
		
		System.out.println("Enter Gender ");
		String gender = sc.next();
		
		System.out.println("Enter identifying_mark ");
		sc.nextLine();
		String identifying_mark = sc.nextLine();
		
		System.out.println("Enter first arrested date ");
		LocalDate first_arrest_date = LocalDate.parse(sc.next());
		
		System.out.println("Enter the arrested_from_ps_area ");
		sc.nextLine();
		String arrested_from_ps_area = sc.nextLine();
		
		
		CriminalDto criminalDto = new CriminalDtoImpl(criminal_id,name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area);
		CriminalDao criminalDao = new CriminalDaoImpl();
		
		try {
			criminalDao.updateCriminalDetails(criminalDto);
			System.out.println("Criminal data updated successfully ");
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
		
	}

	public static void deleteCriminal(Scanner sc) {
		
		
	}

}
