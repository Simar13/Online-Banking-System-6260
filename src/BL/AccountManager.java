package BL;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Bean.BankAccount;
import Bean.CheckingAccount;
import Bean.SavingsAccount;
import Bean.Transaction;
import DAO.BankAccountDao;
import DAO.CheckingAccountDao;
import DAO.DaoFactory;
import DAO.SavingsAccountDao;
import DAO.TransactionDao;
import DAOImpl.BankAccountDaoImpl;
import DAOImpl.TransactionDaoImpl;
import Exception.OverDraftLimitExceededException;

public class AccountManager{
	BankAccountDao bankAccountDao;
	TransactionDao transDao;
	
	public AccountManager(){
		bankAccountDao=new BankAccountDaoImpl();
		transDao=new TransactionDaoImpl();
	}
	
	Connection conn;
	
	public BankAccount getBalance(String accountID)
	{
	
		BankAccount ba=new BankAccount();
		DaoFactory factory=new DaoFactory();
		BankAccountDao dao= factory.getbankaccountDAO();
		try {
			dao.openconnection();
			ba=dao.getBalancebyAccID(accountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ba;
	}
	
	public boolean checkcustomer(String accountId, int PIN) throws SQLException {

		BankAccountDao dao = DaoFactory.getbankaccountDAO();
		
		if (dao.checkcustomer(accountId, PIN)) {
			return true;
		} else {
			return false;
		}
				
	}
	
	
	public Timestamp time() {
	    
	        Calendar calendar = Calendar.getInstance();
	        Date now = calendar.getTime();
	    	Timestamp time=new Timestamp(now.getTime());
	        return time;
	    }
	public ArrayList<BankAccount> findaccountbyCustID(String nric)
	{
		
		DaoFactory factory=new DaoFactory();
		BankAccountDao dao=factory.getbankaccountDAO();
		
		ArrayList<BankAccount> list=new ArrayList<BankAccount>();
		try {
			list = dao.findaccountbyCustID(nric);
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getMaximumBalanceForCheckingAccount(String accountId) {
		
		return bankAccountDao.getMaximumBalanceForCheckingAccount(accountId);
	}

	public double getMaximumBalanceForSavingAccount(String accountId) {
		
		return bankAccountDao.getMaximumBalanceForSavingAccount(accountId);
	}

	
	public void insertTransaction(Transaction trans ,String nric) {
		
		transDao.insertTransaction(trans,nric);
	}

	public void deposit(String nric,String chequeno,String bank,String firstname,String lastname,
			String accountno,double amount , InputStream inputStream) {
		
		bankAccountDao.deposit( nric, chequeno, bank, firstname, lastname,
				 accountno, amount ,  inputStream);
	}

	public BankAccount findBankAcc(String accountId) {
		return bankAccountDao.findBankAcc(accountId);
	}
	
	
	
	}

