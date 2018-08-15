package com.revature.launcher;

import org.apache.log4j.Logger;

import com.revature.screens.LoginScreen;
import com.revature.screens.Screen;

public class Launcher {
	private static Logger log = Logger.getRootLogger();
	public static void main(String[] args) throws InterruptedException {
//		users can sign up(already done)
//		users can login(already done)
//		users can deposit money - check
//		users can withdraw money - check
//		users can view balance - check
//		users can view their transaction history - in progress
//		admins can view any users accounts/transaction history - make admin account exist beforehand
		
//		do with Serialization by Wednesday
//
//	stretch goals
//		wire money from one account to another
//		multiple bank accounts for one user
//		shared accounts, multiple users can access same account
//	try and make it entertaining and interesting afterwards, put a story to it
		
		log.trace("trace log");
		log.debug("debug log");
		log.info("info log");
		log.warn("warn log");
		log.error("error log");
		log.fatal("fatal log");
		//Thread.sleep(5000);
		Screen s = new LoginScreen();
		while(true) {
			s = s.start();
		}
	}
}
