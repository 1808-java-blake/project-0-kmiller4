package com.revature.screens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserData;

public class TransactionHistory implements Screen{
	
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	public Screen start() {
		
		File file = new File("C:\\Users\\Kyle\\Documents\\Revature Training\\week1\\project-0-kmiller4\\MedievalWeaponShop\\src\\main\\resources\\users\\transactionHistory.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  while (sc.hasNextLine())
		      System.out.println(sc.nextLine());
		  	  System.out.println('\n');
		System.out.println("br should be done reading");
		
		return new HomeScreen();
		
//		User u = new User();
//		System.out.println("Enter new username");
//		u.setUsername(scan.nextLine());
//		UserData.name = u.getUsername();
//		
//		System.out.println("Enter password");
//		u.setPassword(scan.nextLine());
//		UserData.password = u.getPassword();
//		
//		try {
//			//u.setAge(Integer.valueOf(age));
//			ud.createUser(u);
//			
//		} catch (NumberFormatException e) {
//			System.out.println("Invalid number");
//		}

		
	}
}
