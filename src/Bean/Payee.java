package Bean;

public class Payee {
	
	private String name;
	private String accountNo;
	
	public Payee(){
		
	}
	public Payee(String name, String accountNo) {
		super();
		this.name = name;
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	@Override
	public String toString() {
		return "Payee [name=" + name + ", accountNo=" + accountNo + "]";
	}
	
	
	
	
	
}	
	
	