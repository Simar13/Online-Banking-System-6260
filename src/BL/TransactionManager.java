package BL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Bean.Transaction;
import DAO.DaoFactory;
import DAO.TransactionDao;

public class TransactionManager {

	
	public ArrayList<Transaction> getTransaction(String month,String year, String accountId){
	
		TransactionDao dao=DaoFactory.getTransactionDao();
		ArrayList<Transaction> transList=dao.getTransactionByDate(month, year, accountId);
		return transList;
	}
	


	private static Date getDate(String from, String clock) {		
		Date date = null;		
		String dateStr = "";
	    Pattern p = Pattern.compile("(\\S*)(\\s*)(\\d*)(\\S*)(,)(\\s*)(\\d*)");
	    Matcher m = p.matcher(from);
	    if (m.find()) {
	    	
	    	dateStr = m.group(1)+" "+m.group(3)+", "+m.group(7);

	    }		
		try {
			
			System.out.println(dateStr+" "+clock);
			date=new SimpleDateFormat("MMM d, yyyy k:m:s.S").parse(dateStr+" "+clock);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return date;
	}

	public ArrayList<Transaction> getAllTransactions(String accId) {
		TransactionDao dao=DaoFactory.getTransactionDao();
		ArrayList<Transaction> transList=dao.getAllTransactions(accId);
		return transList;
		
	}

}
