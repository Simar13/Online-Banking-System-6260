package Bean;

public class Cheque {
	
	private String chequeNo;
	private String firstName;
	private String lastName;
	
	private String amount;
	private String accountNo;
	private String bank;
	
	
	
	public Cheque(){
		
	}

	

	public Cheque(String chequeNo, String firstName, String lastName,
			String amount, String accountNo, String bank) {
		super();
		this.chequeNo = chequeNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amount = amount;
		this.accountNo = accountNo;
		this.bank = bank;
	}



	public String getChequeNo() {
		return chequeNo;
	}



	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}

	
	
	
	
}	
	
	