package DAO;

import java.sql.SQLException;

import Bean.CheckingAccount;

public interface CheckingAccountDao {
	public void deleteCheckingAcc(String acc);
	
	public CheckingAccount findCheckingAccount(String acc);

	public void insertCheckingAcc(String accountId, double overDraftAmount);
	public CheckingAccount getoverDraftAmountbyAccID(String accountId) throws SQLException;
}
