//unused in this project

package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoJdbc implements AccountDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.cu;

	@Override
	public int createAccount(Account a) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO accounts (accountId, balance, user_id) VALUES (?,?,?)",
					new String[] {"accountId"});
			ps.setInt(3, a.getUserId());
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				log.trace("generated account id is" + rs.getInt("accountId"));
				return rs.getInt("accountId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}
		return 0;
	}

	@Override
	public List<Account> findByUserId(int userId) {
		try (Connection conn = cu.getConnection()) {
			List<Account> accounts = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(
			"SELECT * FROM accounts WHERE user_id=?"
			);
			ps.setInt(3, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account a = new Account();
				a.setUserId(rs.getInt("user_id"));
				accounts.add(a);
			}		
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}