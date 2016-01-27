package BL;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Bean.Transaction;
import DAO.BankAccountDao;
import DAO.CustomerDao;
import DAO.DaoFactory;
import DAO.TransactionDao;

public class DepositManager {

	
	
	public boolean DepositAmountByAccountId(String nric,String chequeno,String bank,String firstname,String lastname,
			String accountno,String amount , InputStream inputStream) {
		try {
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date date = new Date();
			Date dateFormatted = dt.parse(dt.format(date));
			Timestamp currentTimeStamp = new Timestamp(dateFormatted.getTime());
			
			double depositAmount=Double.parseDouble(amount);
			CustomerDao customerDao=DaoFactory.getCustomerDao();
		//	boolean validate=customerDao.checkPIN(accountId, PIN);
					
			
				BankAccountDao bankDao = DaoFactory.getbankaccountDAO();
				bankDao.deposit(nric,chequeno,bank, firstname,lastname,
						accountno, depositAmount , inputStream);
				
				TransactionDao transactionDao=DaoFactory.getTransactionDao();
				Transaction transaction=new Transaction(12,"","Cheque Deposit",depositAmount,accountno, currentTimeStamp);
				transactionDao.insertTransaction(transaction,nric);
				return true;
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
