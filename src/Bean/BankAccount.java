package Bean;


public class BankAccount {

	protected String accountId;
	protected int PIN;
	protected String BBID;
	protected String accountType;
	protected double balance;
	
	public BankAccount(){
		
	}
	
	public BankAccount(String accountId, int pIN, String bBID,
			String accountType, double balance) {
		super();
		this.accountId = accountId;
		PIN = pIN;
		BBID = bBID;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountID() {
		return accountId;
	}
	public void setAccountID(String accountId) {
		this.accountId = accountId;
	}
	public int getPIN() {
		return PIN;
	}
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	public String getBBID() {
		return BBID;
	}
	public void setBBID(String bBID) {
		BBID = bBID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", PIN=" + PIN
				+ ", BBID=" + BBID + ", accountType=" + accountType
				+ ", balance=" + balance + "]";
	}

	public BankAccount(String accountId) {
		super();
		this.accountId = accountId;
	}

	public BankAccount(String accountId, int pIN, double balance) {
		super();
		this.accountId = accountId;
		PIN = pIN;
		this.balance = balance;
	}

	public BankAccount(String accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public BankAccount(double balance) {
		super();
		this.balance= balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
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
		BankAccount other = (BankAccount) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}
}
	


