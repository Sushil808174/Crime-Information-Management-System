package com.masai.Ui;

import java.util.Scanner;

import com.masai.dao.Crime_CriminalDao;
import com.masai.dao.Crime_CriminalDaoImpl;
import com.masai.dto.Crime_CriminalDto;
import com.masai.dto.Crime_CriminalDtoImpl;
import com.masai.exception.SomethingWentWrongException;

public class Crime_CriminalUi {

	public static void assignCriminalToCrime(Scanner sc) {
		System.out.print("Please Enter the crime Id ");
		int crimeid = sc.nextInt();
		System.out.print("Please Enter the criminal Id ");
		int criminalid = sc.nextInt();
		
		Crime_CriminalDto crime_criminalDto = new Crime_CriminalDtoImpl(null, null, crimeid, criminalid);
		Crime_CriminalDao crime_criminalDao = new Crime_CriminalDaoImpl();
		
		try {
			crime_criminalDao.assignCriminal(crime_criminalDto);
			
			System.out.println("Assign criminal to crime successfully");
			
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removeCriminalFromCrime(Scanner sc) {
		System.out.print("Please Enter the crime Id ");
		int crimeid = sc.nextInt();
		System.out.print("Please Enter the criminal Id ");
		int criminalid = sc.nextInt();
		
		Crime_CriminalDao crime_criminalDao = new Crime_CriminalDaoImpl();
		
		try {
			crime_criminalDao.removeCriminal(crimeid,criminalid);
			
			System.out.println("Remove criminal from crime successfully");
			
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
