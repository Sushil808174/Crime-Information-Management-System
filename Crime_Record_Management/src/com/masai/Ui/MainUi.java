package com.masai.Ui;

import java.util.Scanner;

import com.masaischool.consoleColor.ConsoleColors;

public class MainUi {
	public static void disPlayMenu() {
		System.out.println(ConsoleColors.ROSY_PINK+"Welcome in our Application "+ConsoleColors.RESET);
		System.out.println(ConsoleColors.YELLOW+"+--------------------+\n"
				         + "| 0. Exit	     |\n"
				         + "| 1. Admid login     |\n"
				         + "| 2. Public          |\n"
				         + "+--------------------+"+ConsoleColors.RESET);
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			disPlayMenu();
			System.out.print(ConsoleColors.GREEN+"Enter Your Choice "+ConsoleColors.RESET);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				AdminUi.Login(sc);
				break;
			case 2:
				PublicUi.PublicUse(sc);
				break;
			case 0:
				System.out.println();
				System.out.println(ConsoleColors.WHITE_BACKGROUND+ConsoleColors.BLUE_BOLD+ConsoleColors.BLUE_ITALIC+"Thanks for using our Application "+ConsoleColors.RESET);
				System.out.println();
				break;
			default:
				System.out.println(ConsoleColors.RED+"Invalid Input you have given "+ConsoleColors.RESET);
			}
			
			
		}while(choice!=0);
		sc.close();
	}
}
