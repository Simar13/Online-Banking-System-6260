package Bean;

import java.util.Date;

public class MortgageHistory {
	
	private long mortgageId;
	

	private double outstanding;
	
	private double paidAmount;
	private double installment;
	
	
	private Date startDate;
	private Date endDate;
	private Date lastPayDate;
	
	
	public MortgageHistory(){
		super();
	}


	public MortgageHistory(long mortgageId, double outstanding,
			double paidAmount, double installment, Date startDate,
			Date endDate, Date lastPayDate) {
		super();
		this.mortgageId = mortgageId;
		this.outstanding = outstanding;
		this.paidAmount = paidAmount;
		this.installment = installment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastPayDate = lastPayDate;
	}


	public long getMortgageId() {
		return mortgageId;
	}


	public void setMortgageId(long mortgageId) {
		this.mortgageId = mortgageId;
	}


	public double getOutstanding() {
		return outstanding;
	}


	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
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

	
}	
	
	