package com.revature.screens;

import java.util.Scanner;

import com.revature.daos.UserData;

public class HomeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	public Screen start() {
		System.out.println("Please chose from following options:");
		System.out.println("Enter 1 to store weapons");
		System.out.println("Enter 2 to withdraw");
		System.out.println("Enter 3 to view my weapons");
		System.out.println("Enter 4 to view transaction history");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			System.out.println("selected 1");
			return new StoreWeaponsScreen();
		case "2":
			System.out.println("selected 2");
			return new WithdrawScreen();
		case "3":
			System.out.println("selected 3");
			System.out.println("You currently have: " + UserData.numWeapons);
			break;
		case "4":
			System.out.println("selected 4");
			return new TransactionHistory();
		default:
			break;
		}

		return this;
	}

}
