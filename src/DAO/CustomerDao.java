package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Bean.BankAccountDetail;
import Bean.Customer;
import Bean.Loan;
import Bean.LoanHistory;
import Bean.Mortgage;
import Bean.MortgageHistory;
import Bean.Payee;
import Bean.Recipient;

public interface CustomerDao {
	public ArrayList<Customer> getCustomers();
	
	public void insertCustomer(Customer c);
	
	public void updateCustomer(Customer c);
	public void updateCustomerByNric(String nric ,String Address,String Email,String Phone);
	public void deactivateCustomerByNric(String nric ,String status);
	public Customer getCustomersByIdPwd(String userId, String pwd)
			throws SQLException;
	public Customer getCustomersByUserId(String userId)
			throws SQLException;
	
	public ArrayList<BankAccountDetail> getAccountDetailByCustomerID(String nric) 
			throws SQLException;
	
	public ArrayList<String> getAccountIDByNric(String nric)
	         throws SQLException;

	
	public Customer findCustomer(String nric);
	public void AddRecipient(String nric ,Recipient recp);
	public void AddPayee(String nric ,Payee payee);
	

	public Customer findCustomerByNRIC(String keyword);

	public Customer findCustomersByAccountId(String accountId);

	public String getCustomerAccountIdByUserID(String userId, String pin);
	
	public boolean checkPIN(String accountId, String PIN);
	public void changeMortgageStatus(String nric, String action);
	public void updateAddress(String nric, String address);
	public void updatePassword(String accountId, String pwd);
	public void requestLoan(String nric,String duration, String amount, String rate,String insType);
	public void requestMortgage(String nric,String duration, String amount, String rate,String income
			,String expenditure, String price, String down,String insType);
	public void changeLoanStatus(String nric, String action);
	public ArrayList<Loan> getAllLoanRequests() ;
	public ArrayList<Mortgage> getAllMortgageRequests() ;
	public Loan getLoanDetails(String nric);
	public Mortgage getMortgageDetails(String nric);
	public void updateLoan(Loan loan,String nric);
	public void updateMortgage(Mortgage loan,String nric);
	public Loan getLoanDetailsForSearch(String loanid);
	public Mortgage getMortgageDetailsForSearch(String mortgageid);
	public Loan getLoan(String nric);
	public Mortgage getMortgage(String nric);
	public void payLoan(Loan loan ,String loanid);
	public void payMortgage(Mortgage loan ,String mortgageid);
	public ArrayList<LoanHistory> getLoanHistory(String nric);
	public ArrayList<MortgageHistory> getMortgageHistory(String nric);
}
