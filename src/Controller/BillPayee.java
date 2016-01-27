package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AccountManager;
import BL.PreferenceManager;
import Bean.BankAccount;
import Bean.Customer;
import Bean.Transaction;
import DAOImpl.CustomerDaoImpl;
import Exception.BelowMinimumBalanceException;
import Exception.OverDraftLimitExceededException;
import Helper.DateTimeParser;

@WebServlet("/BillPayee")
public class BillPayee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public BillPayee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/billPay.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		
		String path = "";
//		String nric = (String) session.getAttribute("nric");
		String nric =(String) session.getAttribute("nric");
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		String Etransfer = request.getParameter("payeeAcc");
		AccountManager accountManager = new AccountManager();
		String AccountTrfrom = request.getParameter("AccNo");
		String [] Account= AccountTrfrom.split("---");
		String AccountId= Account[0];
		String AccountTrfrm= Account[1];
		Double amount = Double.valueOf(request.getParameter("Amountpayee"));

		System.out.println("*************99999999*************");
		
		System.out.println("From account:   "+AccountTrfrm);
	//	BankAccount accountTo = new BankAccount();
		BankAccount accountFrm = new BankAccount();

		ArrayList<BankAccount> aList = new ArrayList<BankAccount>();

		try {
		;
			accountFrm = customerDaoImpl.accountNoIsExist(nric ,AccountTrfrm );
		//	System.out.println("to acccount obj   "+accountTo);
			System.out.println("from  acccount obj :   "+accountFrm);
	//		aList.add(accountTo);
			aList.add(accountFrm);
			//
			if (aList == null || aList.size() == 0 ) {
				
					
				System.out.println(nric);
				
			
				request.setAttribute("error", "Account Number is wrong");
				path="JSP/Transfer.jsp";
				
			} else {
				
				System.out.println(AccountTrfrm);
				if ("C".equals(AccountTrfrm)) {
			
					System.out.println("Payee bill from chequing");
					if (customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId())-Double.valueOf(amount) >= 0) {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
					//	customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Bill pay",amount,
								Etransfer,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans,nric);
						path = "JSP/confirmationTransfer.jsp";
					} else {
						System.out.println("Your transfer amount exceed than bill payment amount limit ");
						
						request.setAttribute("error","Your bill payment amount exceed than minimum balance amount limit.");
						throw new BelowMinimumBalanceException();
					}
				}

				// TODO:
				if ("S".equals(AccountTrfrm)) {
					System.out.println("Paye bill from savings");
					double account = customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId());
					System.out.println("account balance :" +account);
					
					//Double.parseDouble(savingsAccount.getBalance().toString())
					
					if ((account - Double.valueOf(amount)) < 100) {
						System.out.println("insufficient balance");
						
						request.setAttribute("error","Bill payment amount exceed than minimum balance.");
						throw new BelowMinimumBalanceException();
						
					} else {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
				//		customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Bill Pay",amount,
								Etransfer,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans,nric);
						System.out.println("Bill payment done !!!!!!!");
						path = "JSP/confirmationTransfer.jsp";
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
