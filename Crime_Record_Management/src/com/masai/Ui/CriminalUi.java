package com.masai.Ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.CriminalDao;
import com.masai.dao.CriminalDaoImpl;
import com.masai.dto.CriminalDto;
import com.masai.dto.CriminalDtoImpl;
import com.masai.exception.SomethingWentWrongException;
import com.masaischool.consoleColor.ConsoleColors;

public class CriminalUi {

	public static void addCriminalDetails(Scanner sc) {
		System.out.print(ConsoleColors.GREEN+"Enter the Criminal Name ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Enter Date of Birth, Format should be like that (YYYY-MM-DD) ");
		LocalDate  dob = LocalDate.parse(sc.next());
		
		System.out.print("Enter Gender ");
		String gender = sc.next();
		
		System.out.print("Enter identifying_mark ");
		sc.nextLine();
		String identifying_mark = sc.nextLine();
		
		System.out.print("Enter first arrested date ");
		LocalDate first_arrest_date = LocalDate.parse(sc.next());
		
		System.out.print("Enter the arrested_from_ps_area "+ConsoleColors.RESET);
		sc.nextLine();
		String arrested_from_ps_area = sc.nextLine();
		
		
		CriminalDto criminalDto = new CriminalDtoImpl(name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area);
		CriminalDao criminalDao = new CriminalDaoImpl();
		
		try {
			criminalDao.addCriminalDetails(criminalDto);
			System.out.println(ConsoleColors.LIGHT_BLUE+"Criminal data added successfully "+ConsoleColors.RESET);
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
	}

	public static void updateCriminalDetails(Scanner sc) {
		System.out.print(ConsoleColors.GREEN+"Enter the Criminal Id ");
		int criminal_id = sc.nextInt();
		
		System.out.print("Enter the Criminal Name ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Enter Date of Birth, Format should be like that (YYYY-MM-DD) ");
		LocalDate  dob = LocalDate.parse(sc.next());
		
		System.out.print("Enter Gender ");
		String gender = sc.next();
		
		System.out.print("Enter identifying_mark ");
		sc.nextLine();
		String identifying_mark = sc.nextLine();
		
		System.out.print("Enter first arrested date ");
		LocalDate first_arrest_date = LocalDate.parse(sc.next());
		
		System.out.print("Enter the arrested_from_ps_area "+ConsoleColors.RESET);
		sc.nextLine();
		String arrested_from_ps_area = sc.nextLine();
		
		
		CriminalDto criminalDto = new CriminalDtoImpl(criminal_id,name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area);
		CriminalDao criminalDao = new CriminalDaoImpl();
		
		try {
			criminalDao.updateCriminalDetails(criminalDto);
			System.out.println(ConsoleColors.LIGHT_BLUE+"Criminal data updated successfully "+ConsoleColors.RESET);
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
		
	}

	public static void deleteCriminal(Scanner sc) {
		System.out.print(ConsoleColors.GREEN+"Please Enter Criminal Id "+ConsoleColors.RESET);
		int criminalid = sc.nextInt();
		
		CriminalDao criminalDao = new CriminalDaoImpl();
		try {
			criminalDao.deleteCriminal(criminalid);
			System.out.println(ConsoleColors.LIGHT_BLUE+"Data deleted successfully "+ConsoleColors.RESET);
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
		
	}

}
