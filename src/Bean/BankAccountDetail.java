package Bean;

public class BankAccountDetail {
	
	protected String accountId;
	protected String nric;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountID) {
		this.accountId = accountID;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public BankAccountDetail(String accountID, String nric) {
		super();
		this.accountId = accountID;
		this.nric = nric;
	}

	public BankAccountDetail()
	{
		super();
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
		BankAccountDetail other = (BankAccountDetail) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}
}
