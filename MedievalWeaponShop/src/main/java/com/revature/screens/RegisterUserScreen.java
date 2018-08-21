
package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daos.UserDao;

public class RegisterUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	//here's how to set the current user and retrieve it later
	private User currentUser;

	@Override
	public Screen start() {
		User u = new User();
		System.out.println("Enter new username");
		u.setUsername(scan.nextLine());
		//UserData.name = u.getUsername();
		
		System.out.println("Enter password");
		u.setPassword(scan.nextLine());
		//UserData.password = u.getPassword();
		
		//System.out.println("How many weapons do you have?");
		//can't use a part of a weapon
		//u.setNumWeapons(scan.nextInt());
		//UserData.numWeapons = scan.nextInt();
		System.out.println("Enter first name");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter last name");
		u.setLastName(scan.nextLine());
//		System.out.println("Enter age");
//		String age = scan.nextLine();
		
		try {
			//u.setAge(Integer.valueOf(age));
			ud.createUser(u);
			//create new account
			//currentUser.createAccount();
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}
		
		return new LoginScreen();
	}

}
