package Exception;

import javax.servlet.ServletException;

@SuppressWarnings("serial")
public class TransactionAbortedException extends ServletException {

	public TransactionAbortedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionAbortedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
