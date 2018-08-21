package com.revature.screens;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.util.AppState;
import com.revature.util.ConnectionUtil;

public class WithdrawScreen implements Screen {
	private AppState state = AppState.state;
	private Logger log = Logger.getRootLogger();
	private Scanner scan = new Scanner(System.in);
	private AccountDao ac = AccountDao.currentAccountDao;
	private ConnectionUtil cu = ConnectionUtil.cu;
	private int currentWeapons;
	private ResultSet rs;

	@Override
	public Screen start() {
		User currentUser = state.getCurrentUser();
		if(currentUser == null) {
			return new LoginScreen();
		}
		try {
			//Account a = new Account();
			System.out.println("How many weapons do you want to withdraw?");
			String subtractedBalance = scan.nextLine();
			//increment balance by using prepared statements
			//currentWeapons = currentUser.getNumWeapons();
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
				currentWeapons = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentWeapons -= Integer.parseInt(subtractedBalance);
			currentUser.setNumWeapons(currentWeapons);
			try (Connection conn = cu.getConnection()) {
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE accounts SET balance = ?  WHERE userid =  ?");
				ps.setInt(1, currentWeapons);
				ps.setInt(2, currentUser.getId());
				int recordsCreated = ps.executeUpdate();
				log.trace(recordsCreated + " weapons withdrawn");
			}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					//log.error(e.getMessage());
					System.out.println(e.getMessage());
					for(StackTraceElement ste: e.getStackTrace()) {
						log.error(ste);
					}
					log.warn("failed to add weapons");
				}
			
			
			//a.setBalance(Integer.valueOf(balance));
			//a.setUserId(currentUser.getId());
			//int accountId = ac.createAccount(a);
			//if(accountId == 0) {
				//log.error("failed to create account");
				//return new LoginScreen();
			//}
			//a.setAccountId(accountId);
			//log.info("created account" + a);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}

		return new HomeScreen();
	}

}

