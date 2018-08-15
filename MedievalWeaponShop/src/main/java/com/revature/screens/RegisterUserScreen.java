package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserData;

public class RegisterUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() {
		User u = new User();
		System.out.println("Enter new username");
		u.setUsername(scan.nextLine());
		UserData.name = u.getUsername();
		
		System.out.println("Enter password");
		u.setPassword(scan.nextLine());
		UserData.password = u.getPassword();
		
		System.out.println("How many weapons do you have?");
		UserData.numWeapons = scan.nextInt();
//		u.setFirstName(scan.nextLine());
//		System.out.println("Enter last name");
//		u.setLastName(scan.nextLine());
//		System.out.println("Enter age");
//		String age = scan.nextLine();
		
		try {
			//u.setAge(Integer.valueOf(age));
			ud.createUser(u);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}
		
		return new LoginScreen();
	}

}
