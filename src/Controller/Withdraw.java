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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Withdraw() {
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
		System.out.println("*************99999999*************");
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
		String nric ="cst1";
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		String Etransfer = request.getParameter("payeeAcc");
		String company = request.getParameter("company");
		AccountManager accountManager = new AccountManager();
		String AccountTrfrom = request.getParameter("AccNo");
		String [] Account= AccountTrfrom.split("---");
		String AccountId= Account[0];
		String AccountTrfrm= Account[1];
		Double amount = Double.valueOf(request.getParameter("Amountpayee"));

		System.out.println("*************99999999*************");
		// TODO:
	
		
//		System.out.println("TO account:   "+AccountTrTo);
		// TODO: check.
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
				System.out.println("Account Not Exist**************************************");
				
				
				// ******throw execption or jump to error.jsp*************
				request.setAttribute("error", "Account Number is wrong");
				path="JSP/Transfer.jsp";
				
			} else {
				// TODO:
				System.out.println("**********find account**11111********");
				System.out.println(AccountTrfrm);
				if ("C".equals(AccountTrfrm)) {
			
					System.out.println("Payee bill from chequing");
					if (1000000	- Double.valueOf(amount)+customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId()) >= 0) {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
					//	customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Withdraw",amount,
								Etransfer,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans,nric);
						request.setAttribute("company",company);
						request.setAttribute("amount",amount);
						request.setAttribute("account",AccountTrfrom);
						path = "JSP/WithdrawResult.jsp";
					} else {
						System.out.println("Your transfer amount exceed than bill payment amount limit ");
						
						request.setAttribute("error","Your transfer amount exceed than bill payment amount limit.");
						throw new OverDraftLimitExceededException();
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
						
						request.setAttribute("error","Transfer amount exceed than minimum balance.");
						throw new BelowMinimumBalanceException();
						
					} else {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
				//		customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Withdraw",amount,
								Etransfer,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans,nric);
						request.setAttribute("company",company);
						request.setAttribute("amount",amount);
						request.setAttribute("account",AccountTrfrom);
						System.out.println("Bill payment done !!!!!!!");
						path = "JSP/WithdrawResult.jsp";
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
