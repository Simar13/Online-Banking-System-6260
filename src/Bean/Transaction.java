package Bean;

import java.sql.Timestamp;

public class Transaction {

	protected int transactionId;
	protected String accountId;
	protected String transactionType;
	protected double transactionAmount;
	protected String depositToAccount;
	protected Timestamp transactionTime;
	
	public Transaction(int transactionId, String accountId,
			String transactionType, double transactionAmount,
			String depositToAccount, Timestamp transactionTime) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.depositToAccount = depositToAccount;
		this.transactionTime = transactionTime;
	}
	
	
	public Transaction() {
		super();
	}


	public Transaction(String accountId, String transactionType,
			double transactionAmount, Timestamp transactionTime) {
		super();
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionTime = transactionTime;
	}


	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDepositToAccount() {
		return depositToAccount;
	}
	public void setDepositToAccount(String depositToAccount) {
		this.depositToAccount = depositToAccount;
	}
	public Timestamp getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountId="
				+ accountId + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount
				+ ", depositToAccount=" + depositToAccount
				+ ", transactionTime=" + transactionTime + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime
				* result
				+ ((depositToAccount == null) ? 0 : depositToAccount.hashCode());
		long temp;
		temp = Double.doubleToLongBits(transactionAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transactionId;
		result = prime * result
				+ ((transactionTime == null) ? 0 : transactionTime.hashCode());
		result = prime * result
				+ ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (depositToAccount == null) {
			if (other.depositToAccount != null)
				return false;
		} else if (!depositToAccount.equals(other.depositToAccount))
			return false;
		if (Double.doubleToLongBits(transactionAmount) != Double
				.doubleToLongBits(other.transactionAmount))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionTime == null) {
			if (other.transactionTime != null)
				return false;
		} else if (!transactionTime.equals(other.transactionTime))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
}
