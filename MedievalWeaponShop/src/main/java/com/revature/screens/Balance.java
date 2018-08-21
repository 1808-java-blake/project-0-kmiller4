package com.revature.screens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.util.AppState;
import com.revature.util.ConnectionUtil;

//stored locally
public class Balance implements Screen{
	
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private AppState state = AppState.state;
	private Logger log = Logger.getRootLogger();
	private AccountDao ac = AccountDao.currentAccountDao;
	private ConnectionUtil cu = ConnectionUtil.cu;
	private int currentWeapons;
	private ResultSet rs;
	public Screen start() {
		User currentUser = state.getCurrentUser();
		if(currentUser == null) {
			return new LoginScreen();
		}
		//if user is an admin
		if(LoginScreen.admin == 1) {
			System.out.println("Enter userid to lookup:");
			int userid = scan.nextInt();
			try (Connection conn = cu.getConnection()) {
				PreparedStatement ps = conn.prepareStatement(
						"SELECT balance FROM accounts WHERE userid =  ?");
				ps.setInt(1, userid);
				rs = ps.executeQuery();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
				for(StackTraceElement ste: e.getStackTrace()) {
					log.error(ste);
				}
			}
			try {
				rs.next();
				System.out.println(rs.getInt(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//if user is not an admin
		else {
			try (Connection conn = cu.getConnection()) {
				PreparedStatement ps = conn.prepareStatement(
						"SELECT balance FROM accounts WHERE userid =  ?");
				ps.setInt(1, currentUser.getId());
				rs = ps.executeQuery();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
				for(StackTraceElement ste: e.getStackTrace()) {
					log.error(ste);
				}
			}
			try {
				rs.next();
				System.out.println(rs.getInt(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*File file = new File("C:\\Users\\Kyle\\Documents\\Revature Training\\week1\\project-0-kmiller4\\MedievalWeaponShop\\src\\main\\resources\\users\\transactionHistory.txt");
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
		
		*/
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
