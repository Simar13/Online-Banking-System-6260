package BL;

import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Customer;
import Bean.LoanHistory;
import Bean.MortgageHistory;
import Bean.Payee;
import Bean.Recipient;
import DAO.BankAccountDao;
import DAO.CustomerDao;
import DAOImpl.BankAccountDaoImpl;
import DAOImpl.CustomerDaoImpl;

public class PreferenceManager {
	private BankAccountDao bankAccDAO;
	private CustomerDao customerDAO;

	public PreferenceManager() {
		this.bankAccDAO = new BankAccountDaoImpl();
		this.customerDAO=new CustomerDaoImpl();
	}

	public boolean checkPIN(int oldPIN, String accountId) {
		
		if(bankAccDAO.findBankAcc(accountId).getPIN()==oldPIN){return true;}
		
		return false;
	}
	public boolean checkPassword(String oldpwd, String nric) {
		
		String pwd = customerDAO.findCustomer(nric).getPassword();
		if(oldpwd.equals(pwd)){return true;}
		
		return false;
	}

	public void updatePIN(String accountId, int newPIN) {
		
		bankAccDAO.updatePIN(accountId,newPIN);
		
	}
	public void updatePassword(String accountId, String pwd) {
		
		customerDAO.updatePassword(accountId,pwd);
		
	}
	public Customer findCustomer(String nric) {
		
		return customerDAO.findCustomer(nric);
		
	}
	public Customer getCustomersByUserId(String userId) throws SQLException {
		
		return customerDAO.getCustomersByUserId(userId);
		
	}

	public void updateAddress(String nric, String address) {
		
		customerDAO.updateAddress(nric,address);
		
	}
	public void AddRecipient(String nric, Recipient recp) {
		
		customerDAO.AddRecipient(nric, recp);
		
	}
	public void AddPayee(String nric, Payee pay) {
		
		customerDAO.AddPayee(nric, pay);
		
	}
	public void updateCustomerByNric(String nric, String Address, String Email, String Phone) {
		
		customerDAO.updateCustomerByNric(nric,Address,Email,Phone);
		
	}
	public void requestMortgage(String nric,String duration, String amount, String rate,String income
			,String expenditure, String price, String down,String insType) {
		
		customerDAO.requestMortgage(nric,duration,amount,rate,income,expenditure,price,down,insType);
		
	}
	public void requestLoan(String nric,String duration, String amount, String rate,String insType) {
		
		customerDAO.requestLoan(nric,duration,amount,rate,insType);
		
	}
	public void changeLoanStatus(String nric, String action) {
		
		customerDAO.changeLoanStatus(nric,action);
		
	}
	public void changeMortgageStatus(String nric, String action) {
		
		customerDAO.changeMortgageStatus(nric,action);
		
	}
	public ArrayList<LoanHistory> getLoanHistory(String nric) {
		
		return customerDAO.getLoanHistory(nric);
		
	}
	public ArrayList<MortgageHistory> getMortgageHistory(String nric) {
		
		return customerDAO.getMortgageHistory(nric);
		
	}
	
}
