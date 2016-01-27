package Exception;

@SuppressWarnings("serial")
public class NotEnoughCashInBankException extends TransactionAbortedException {

	public NotEnoughCashInBankException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotEnoughCashInBankException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
