package Bean;

public class SavingsAccount extends BankAccount {
	protected double minimumbalance;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public double getMinimumBalance() {
		return minimumbalance;
	}
	public void setMinimumbalance(double minimumbalance) {
		this.minimumbalance = minimumbalance;
	}
	public SavingsAccount(String accountId, double balance) {
		super(accountId);
		this.minimumbalance = balance;
	}
	public SavingsAccount() {
		super();
	}
	public SavingsAccount(String accountId) {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	
	


}
