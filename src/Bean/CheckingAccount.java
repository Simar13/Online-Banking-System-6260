package Bean;


public class CheckingAccount extends BankAccount {
	
	String checkingId;
	public String getCheckingId() {
		return checkingId;
	}
	public void setCheckingId(String checkingid) {
		this.checkingId = checkingid;
	}
	protected double overDraftAmount;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getOverDraftAmount() {
		return overDraftAmount;
	}
	public void setOverDraftAmount(double overDraftAmount) {
		this.overDraftAmount = overDraftAmount;
	}
	public CheckingAccount(String accountId, double overDraftAmount) {
		super(accountId);
		this.overDraftAmount = overDraftAmount;
	}

	public CheckingAccount() {
		super();
	}
	public CheckingAccount(String accountId) {
		super();
	
	}


}
