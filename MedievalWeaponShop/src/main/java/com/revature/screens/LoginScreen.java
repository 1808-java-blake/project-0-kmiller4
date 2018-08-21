package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.util.AppState;

public class LoginScreen implements Screen {
	private AppState state = AppState.state;
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private Logger log = Logger.getRootLogger();
	public static int admin;

	@Override
	public Screen start() {
		ASCII.printASCII();
		log.debug("started login screen");
		System.out.println("Welcome to the weapon bank!");
		System.out.println("Enter Username or type Register to sign up: ");
		String username = scan.nextLine();
		log.trace("username = " + username);
		if ("register".equalsIgnoreCase(username)) {
			return new RegisterUserScreen();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		log.debug("received users credentials");
		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			state.setCurrentUser(currentUser);
			log.info("user successfully logged in");
			log.info("Welcome" + currentUser + "!");
			System.out.println("Are you an admin? 0 for no, 1 for yes");
			admin = scan.nextInt();
			return new HomeScreen();
		}

		System.out.println("unable to login");
		return this;
	}

}
