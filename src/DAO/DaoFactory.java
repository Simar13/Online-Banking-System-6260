

package DAO;

import DAOImpl.BankAccountDaoImpl;
import DAOImpl.CheckingAccountDaoImpl;
import DAOImpl.CustomerDaoImpl;
import DAOImpl.SavingsAccountDaoImpl;
import DAOImpl.TransactionDaoImpl;

public class DaoFactory {
	public static TransactionDao getTransactionDao(){
		return new TransactionDaoImpl();
	}

	
	public static CustomerDao getCustomerDao(){
		return new CustomerDaoImpl();
	}

	public static BankAccountDao getbankaccountDAO()
	{
		return new BankAccountDaoImpl();
	}
	public static CustomerDao getCustomerDaoObject(){
		return new CustomerDaoImpl();
	}
	
	public static SavingsAccountDao getsavingaccount()
	{
		return new SavingsAccountDaoImpl();
	}
	
	public static CheckingAccountDao getcheckingaccount()
	{
		return new CheckingAccountDaoImpl();
	}


}
