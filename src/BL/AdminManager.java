package BL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Bean.BankAccount;
import Bean.BankBranch;
import Bean.Customer;
import Bean.Loan;
import Bean.Mortgage;
import Bean.Transaction;
import DAO.BankAccountDao;
import DAO.BankAccountDetailDao;
import DAO.CheckingAccountDao;
import DAO.CustomerDao;
import DAO.SavingsAccountDao;
import DAO.TransactionDao;
import DAOImpl.BankAccountDaoImpl;
import DAOImpl.BankAccountDetailDaoImpl;
import DAOImpl.CheckingAccountDaoImpl;
import DAOImpl.CustomerDaoImpl;
import DAOImpl.SavingsAccountDaoImpl;
import DAOImpl.TransactionDaoImpl;

public class AdminManager {
	private BankAccountDao bankAccDAO;
	private BankAccountDetailDao bankAccDetailDAO;

	private CustomerDao customerDAO;
	private CheckingAccountDao checkAcc;
	private SavingsAccountDao saveAcc;
	private TransactionDao transDao;
//	Client1 a = new Client1();

	public AdminManager() {
		this.customerDAO = new CustomerDaoImpl();
	
		this.bankAccDAO=new BankAccountDaoImpl();
		this.checkAcc=new CheckingAccountDaoImpl();
		this.saveAcc=new SavingsAccountDaoImpl();
		this.bankAccDetailDAO=new BankAccountDetailDaoImpl();
		this.transDao=new TransactionDaoImpl();
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers=new ArrayList<Customer>();
		customers=customerDAO.getCustomers();
		
		return customers;
	}
	
	public void insertCustomer(Customer c) {
    		customerDAO.insertCustomer(c);
    }
	
	public void updateCustomer(Customer c) {
		customerDAO.updateCustomer(c);
	}
	public void deactivateCustomerByNric(String nric ,String status){
		customerDAO.deactivateCustomerByNric(nric,status);
	}
	
	
	public ArrayList<BankAccount> getBankAccByCustomer(String nric){
		return bankAccDAO.findByCustomer(nric);
	}
	
	public void insertBankAccount(BankAccount acc){
		bankAccDAO.insertBankAcc(acc);
	}
	
	public void updateBankAccount(BankAccount acc){
		bankAccDAO.updateBankAcc(acc);
	}
	
	public Customer findCustomer(String nric){
		return customerDAO.findCustomer(nric);
	}

	public void deleteRelatedAcc(String acc) {
		checkAcc.deleteCheckingAcc(acc);
		saveAcc.deleteSavingAcc(acc);
	}

	public void insertCheckingAcc(String accountId, double overDraftAmount) {
		checkAcc.insertCheckingAcc(accountId, overDraftAmount);
	}

	public void insertSavingAcc(String accountId, double minimumBalance) {
		saveAcc.insertSavingAcc(accountId, minimumBalance);
	}

	public void insertBankAccountDetail(String nric, String accountId) {
		bankAccDetailDAO.insertAccDetail(nric,accountId);
	}

	public void deleteBankAccountDetail(String nric, String accountId) {
		bankAccDetailDAO.deleteAccDetail(nric,accountId);
	}

	public BankAccount findAccountById(String accountId) {
		return bankAccDAO.findBankAcc(accountId);
	}

	
	public ArrayList<Transaction> findTransactionByAccountId(String accountId) {
		return transDao.findTransactionByAccountId(accountId);
	}

	public Customer findCustomers(String keyword) {
		return customerDAO.findCustomerByNRIC(keyword);
	}

	public Customer findCustomerByAccountId(String accountId) {
		return customerDAO.findCustomersByAccountId(accountId);
	}
	public ArrayList<Loan> getAllLoanRequests() {
		return customerDAO.getAllLoanRequests();
	}
	public ArrayList<Mortgage> getAllMortgageRequests() {
		return customerDAO.getAllMortgageRequests();
	}
	public boolean isEligibile(double downToPrice, double DepthRatio){
		if ( DepthRatio >= 50 && downToPrice<5){
			return false;
		}
		else 
			return true;
	}
	
	public double calculateDepthRaito(double expenditure, double income){
		
		double DR = 0;
		
		DR = (expenditure/income) * 100;
		return DR;
	}
	public double calculateMortgageRatioToDown(double price, double downpayment){
		double ratio = 0;
		ratio = (downpayment / price ) * 100;
		return ratio; 
	}
	
	public  Date calculateLastDate(Date date, int days)
	{
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, days); 
	    return calendar.getTime();
	}
	public double calculateGrossAmount(double principal , double interestRate, int duration){
		
		double grossAmount;
		double interest = (duration)*((principal*interestRate)/100);
		grossAmount = principal + interest; 
		return grossAmount;
	}
	public double calculateMonthlyInstallment(double gross,int duration){
		double installment;
		int months = (duration)*12;
		installment= gross/months;
		return installment;
		
	}
	public double calculateBiweeklyInstallment(double gross,int duration){
		double installment;
		int months = (duration)*24;
		installment= gross/months;
		return installment;
		
	}
	public double calculatePenalty(double installment){
		double penalty = (installment*5)/100;
		return penalty;
	}
	public double calculateOutstandingAmount(double gross,double paidAmount){
		 double outstanding ;
		 outstanding = gross-paidAmount;
		 return outstanding;
	}
	public double calculatePaidAmount(double paid ,double installment){
		 
		 paid = paid +installment;
		 return paid;
	}
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
	public Loan createLoan(String nric){
		double installment;
		Loan loan= customerDAO.getLoanDetails(nric);
		double grossAmount = round(calculateGrossAmount(loan.getPrincipal(),loan.getInterestRate(),loan.getDuration()),2);
		if(loan.getInstallType().equalsIgnoreCase("M")){
		installment= round(calculateMonthlyInstallment( grossAmount, loan.getDuration()),2);
		}else{
			installment= round(calculateBiweeklyInstallment( grossAmount, loan.getDuration()),2);
		}
		double penalty = round(calculatePenalty( installment),2);
		double outstanding = grossAmount;
		double paidAmount = 0;
		Date startDate = new Date();
		Date endDate = calculateLastDate(startDate,30);
	//	Loan loan = new Loan();
		loan.setGrossAmount(grossAmount);
		loan.setInstallment(installment);
		loan.setOutstanding(outstanding);
		loan.setPaidAmount(paidAmount);
		loan.setPenalty(penalty);
		loan.setPrincipal(loan.getPrincipal());
		loan.setDuration(loan.getDuration());
		loan.setInterestRate(loan.getInterestRate());
		loan.setStartDate(startDate);
		loan.setEndDate(endDate);
	//	loan.setPaidAmount(0);
		customerDAO.updateLoan(loan,nric);
		return loan;
		
	}
	public Mortgage createMortgage(String nric){
		double installment;
		Mortgage loan= customerDAO.getMortgageDetails(nric);
		double grossAmount = round(calculateGrossAmount(loan.getPrincipal(),loan.getInterestRate(),loan.getDuration()),2);
		if(loan.getInstallType().equalsIgnoreCase("M")){
			installment= round(calculateMonthlyInstallment( grossAmount, loan.getDuration()),2);
			}else{
				installment= round(calculateBiweeklyInstallment( grossAmount, loan.getDuration()),2);
			}
		double penalty = round(calculatePenalty( installment),2);
		double outstanding = grossAmount;
		double paidAmount = 0;
		Date startDate = new Date();
		Date endDate = calculateLastDate(startDate,30);
	//	Loan loan = new Loan();
		loan.setGrossAmount(grossAmount);
		loan.setInstallment(installment);
		loan.setOutstanding(outstanding);
		loan.setPaidAmount(paidAmount);
		loan.setPenalty(penalty);
		loan.setPrincipal(loan.getPrincipal());
		loan.setDuration(loan.getDuration());
		loan.setInterestRate(loan.getInterestRate());
		loan.setStartDate(startDate);
		loan.setEndDate(endDate);
	//	loan.setPaidAmount(0);
		customerDAO.updateMortgage(loan,nric);
		return loan;
		
	}
	public double updatePaidamt(double paid,double emi){
		return (paid+emi);		
	}
	public double updateOutstanding(double paid,double gross){
		return (gross-paid);		
	}
	public int applyPenalty(Date endDate){
		Date newDate = new Date();
		return newDate.compareTo(endDate);
	}
	public int applyCease(Date endDate){
		Date newDate = new Date();
		Date newEndDate=calculateLastDate(endDate,30);
		return newEndDate.compareTo(newDate);
	}
	public Loan getLoanDetailsForSearch(String loanid){
		return customerDAO.getLoanDetailsForSearch(loanid);
	}
	public Mortgage getMortgageDetailsForSearch(String mortgageid){
		return customerDAO.getMortgageDetailsForSearch(mortgageid);
	}
	public Loan getLoan(String nric){
		return customerDAO.getLoan(nric);
	}
	public Mortgage getMortgage(String nric){
		return customerDAO.getMortgage(nric);
	}
	public void payLoan(String loanid, String emi){
		
		double installment = Double.parseDouble(emi);
		
		Loan loan= customerDAO.getLoanDetailsForSearch(loanid);
		double paidAmount = updatePaidamt(loan.getPaidAmount(),installment);
		double outstanding =  updateOutstanding( paidAmount ,loan.getGrossAmount());
		Date startDate = loan.getEndDate();
		Date endDate = calculateLastDate(startDate,30);
		Date lastPayDate = new Date();
		int penalty = applyPenalty(loan.getEndDate());
		if(penalty == 1){
			
			double newInstallment = (installment+ loan.getPenalty()); 
			loan.setInstallment(newInstallment);
		}
		int cease = applyCease(endDate);
		if(cease == -1){
			loan.setDefaulter("Y");
		}
		else
			loan.setDefaulter("N");
//		loan.setInstallment(installment);
		loan.setLastPayDate(lastPayDate);
		loan.setPaidAmount(paidAmount);
		loan.setEndDate(endDate);
		loan.setStartDate(startDate);
		loan.setOutstanding(outstanding);
		 customerDAO.payLoan(loan, loanid);
	}
	public void payMortgage(String mortgageid, String emi){
		
		double installment = Double.parseDouble(emi);
		
		Mortgage loan= customerDAO.getMortgageDetailsForSearch(mortgageid);
		double paidAmount = updatePaidamt(loan.getPaidAmount(),installment);
		double outstanding =  updateOutstanding( paidAmount ,loan.getGrossAmount());
		Date startDate = loan.getEndDate();
		Date endDate = calculateLastDate(startDate,30);
		Date lastPayDate = new Date();
		int penalty = applyPenalty(loan.getEndDate());
		if(penalty == 1){
			
			double newInstallment = (installment+ loan.getPenalty()); 
			loan.setInstallment(newInstallment);
		}
		int cease = applyCease(endDate);
		if(cease == -1){
			loan.setDefaulter("Y");
		}
		else
			loan.setDefaulter("N");
//		loan.setInstallment(installment);
		loan.setLastPayDate(lastPayDate);
		loan.setPaidAmount(paidAmount);
		loan.setEndDate(endDate);
		loan.setStartDate(startDate);
		loan.setOutstanding(outstanding);
		 customerDAO.payMortgage(loan, mortgageid);
	}
	
}
