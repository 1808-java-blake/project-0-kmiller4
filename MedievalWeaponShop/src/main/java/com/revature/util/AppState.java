package com.revature.util;

import com.revature.beans.Account;
import com.revature.beans.User;

public class AppState {
	public static final AppState state = new AppState();
	private User currentUser;
	private Account currentAccount;

	private AppState() {

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

}