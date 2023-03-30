package com.masai.Ui;

import java.util.Scanner;

public class MainUi {
	public static void disPlayMenu() {
		System.out.println("+--------------------+\n"
				         + "| 0. Exit	     |\n"
				         + "| 1. Admid login     |\n"
				         + "| 2. Public          |\n"
				         + "+--------------------+");
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			disPlayMenu();
			System.out.println("Enter Your Choice ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				AdminUi.Login(sc);
				break;
			case 2:
//				PublicUi.PublicUse();
				break;
			case 0:
				System.out.println("Thanks for using our Application ");
				break;
			default:
				System.out.println("Invalid Input you have given ");
			}
			
			
		}while(choice!=0);
		sc.close();
	}
}
