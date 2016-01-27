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
import Bean.BankAccount;
import Bean.CheckingAccount;
import Bean.SavingsAccount;
import Bean.Transaction;
import DAOImpl.CustomerDaoImpl;
import Exception.BelowMinimumBalanceException;
import Exception.OverDraftLimitExceededException;
import Helper.DateTimeParser;

@WebServlet("/transferInfoController")
public class TransferInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public TransferInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path="JSP/Transfer.jsp";
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
		session=request.getSession(true);
		
		String path = "";
		AccountManager accountManager = new AccountManager();
		String AccountTraTo = request.getParameter("AccountTrTo");
		String [] AccountTo= AccountTraTo.split("---");
		String AccountIdTo= AccountTo[0];
		String AccountTrTo= AccountTo[1];

		String AccountTrfrom = request.getParameter("AccountTrfrm");
		String [] Account= AccountTrfrom.split("---");
		String AccountId= Account[0];
		String AccountTrfrm= Account[1];
	
		Double amount = Double.valueOf(request.getParameter("Ammount1"));

		
		// TODO:
		String nric = (String) session.getAttribute("nric");
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		System.out.println("TO account:   "+AccountTrTo);
		// TODO: check.
		System.out.println("From account:   "+AccountTrfrm);
		BankAccount accountTo = new BankAccount();
		BankAccount accountFrm = new BankAccount();

		ArrayList<BankAccount> aList = new ArrayList<BankAccount>();

		try {
			//
			accountTo = customerDaoImpl.accountNoIsExist(nric ,AccountTrTo );
			accountFrm = customerDaoImpl.accountNoIsExist(nric ,AccountTrfrm );
			System.out.println("to acccount obj   "+accountTo);
			System.out.println("from  acccount obj :   "+accountFrm);
			aList.add(accountTo);
			aList.add(accountFrm);
			//
			if (aList == null || aList.size() == 0 || aList.size() == 1) {
				
				request.setAttribute("error", "Both Account Numbers are wrong");
				
				System.out.println(nric);
				System.out.println("Account Not Exist**************************************");
				
				if (accountTo == null && accountFrm != null)
					request.setAttribute("error", "Account to which money is to be transferred is invalid");
				if (accountFrm == null && accountTo !=null)
					request.setAttribute("error", "Account from which money is to be transferred is invalid");
				
				
				request.setAttribute("error", "Account Number is wrong");
				path="JSP/Transfer.jsp";
				
			} else {
				// TODO:
				System.out.println("**********find account**11111********");
				System.out.println(AccountTrfrm);
				if ("C".equals(AccountTrfrm)) {
	

		 		System.out.println("Transfer from chequing");
					if (customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId())-Double.valueOf(amount) >= 0) {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
						customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Account Transfer",amount,
								AccountIdTo,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans ,nric);
						path = "JSP/confirmationTransfer.jsp";
					} else {
						System.out.println("Account balance is not enough  ");
						
						request.setAttribute("error","Your transfer amount exceed than Over draft amount limit.");
						throw new BelowMinimumBalanceException();
					}
				}

				// TODO:
				if ("S".equals(AccountTrfrm)) {
					System.out.println("Transfer from savings");
			//		sAList = customerDaoImpl.getSavingAccount(accountFrm.getAccountId());
				//	SavingsAccount savingsAccount = sAList.get(0);
					double account = customerDaoImpl
							.getBalanceByAccountID(accountFrm.getAccountId());
					System.out.println("account balance :" +account);
					
					//Double.parseDouble(savingsAccount.getBalance().toString())
					
					if ((account - Double.valueOf(amount)) < 100) {
						System.out.println("insufficient balance");
						
						request.setAttribute("error","Transfer amount exceed than minimum balance.");
						throw new BelowMinimumBalanceException();
						
					} else {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
						customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Account Transfer",amount,
								AccountIdTo,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans ,nric);
						System.out.println("Saving of transfer done !!!!!!!");
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
