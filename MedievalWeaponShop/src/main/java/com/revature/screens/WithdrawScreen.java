package com.revature.screens;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.revature.daos.UserData;

public class WithdrawScreen implements Screen {
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("You have: "  + UserData.numWeapons);
		System.out.println("How much would you like to withdraw?");
		int data = scan.nextInt();
		UserData.numWeapons -= data;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\Users\\Kyle\\Documents\\Revature Training\\week1\\project-0-kmiller4\\MedievalWeaponShop\\src\\main\\resources\\users\\transactionHistory.txt", true));
			System.out.println("file writer should exist");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.append('\n' + "withdrew " + data);
			System.out.println("data should have been written");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You now have: " + UserData.numWeapons + " weapons");
		return new HomeScreen();
	}
}
