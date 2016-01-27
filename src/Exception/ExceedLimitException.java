package Exception;

@SuppressWarnings("serial")
public class ExceedLimitException extends TransactionAbortedException {

	public ExceedLimitException() {
		super();
		
	}

	public ExceedLimitException(String message) {
		super(message);

	}

}
