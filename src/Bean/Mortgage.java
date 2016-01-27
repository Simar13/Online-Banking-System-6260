package Bean;

import java.util.Date;

public class Mortgage {
	
	private long mortgageId;
	private String nric;
	private double downPayment;
	private double income;
	private double expenditure;
	private double price;
	
	private int duration;
	private double grossAmount;
	
	private double outstanding;
	private double principal;
	private double paidAmount;
	private double installment;
	private double interestRate;
	private double penalty;
	private Date startDate;
	private Date endDate;
	private Date lastPayDate;
	private String status;
	private String isPaid;
	private String defaulter;
	private String installType;
	
	public Mortgage(){
		super();
	}

	public Mortgage(long mortgageId, String nric, double downPayment,
			double income, double expenditure, double price, int duration,
			double grossAmount, double outstanding, double principal,
			double paidAmount, double installment, double interestRate,
			double penalty, Date startDate, Date endDate, Date lastPayDate,
			String status, String isPaid, String defaulter, String installType) {
		super();
		this.mortgageId = mortgageId;
		this.nric = nric;
		this.downPayment = downPayment;
		this.income = income;
		this.expenditure = expenditure;
		this.price = price;
		this.duration = duration;
		this.grossAmount = grossAmount;
		this.outstanding = outstanding;
		this.principal = principal;
		this.paidAmount = paidAmount;
		this.installment = installment;
		this.interestRate = interestRate;
		this.penalty = penalty;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastPayDate = lastPayDate;
		this.status = status;
		this.isPaid = isPaid;
		this.defaulter = defaulter;
		this.installType = installType;
	}

	public long getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(long mortgageId) {
		this.mortgageId = mortgageId;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getInstallment() {
		return installment;
	}

	public void setInstallment(double installment) {
		this.installment = installment;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(Date lastPayDate) {
		this.lastPayDate = lastPayDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getDefaulter() {
		return defaulter;
	}

	public void setDefaulter(String defaulter) {
		this.defaulter = defaulter;
	}

	public String getInstallType() {
		return installType;
	}

	public void setInstallType(String installType) {
		this.installType = installType;
	}


}	
	
	