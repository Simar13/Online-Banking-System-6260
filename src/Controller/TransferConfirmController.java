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
import Bean.Transaction;
import DAOImpl.CustomerDaoImpl;
import Exception.BelowMinimumBalanceException;
import Exception.OverDraftLimitExceededException;
import Helper.DateTimeParser;

@WebServlet("/transferConfirmController")
public class TransferConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public TransferConfirmController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path="JSP/TransferE.jsp";
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
		String nric = (String) session.getAttribute("nric");
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		
		String Etransfer = request.getParameter("Etransfer");
		
		String AccountTrfrom = request.getParameter("AccountTr");
		String [] Account= AccountTrfrom.split("---");
		String AccountId= Account[0];
		String AccountTrfrm= Account[1];
		String answer = request.getParameter("t2");
		String question = request.getParameter("Etext");
	
		Double amount = Double.valueOf(request.getParameter("Ammount1"));

		AccountManager accountManager = new AccountManager();
		
		System.out.println("Account ype and ID:   "+AccountTrfrm+AccountId );
	//	BankAccount accountTo = new BankAccount();
		BankAccount accountFrm = new BankAccount();
		
		ArrayList<BankAccount> aList = new ArrayList<BankAccount>();

		try {
		
			accountFrm = customerDaoImpl.accountNoIsExist(nric ,AccountTrfrm );
		
			System.out.println("from  acccount obj :   "+accountFrm);

			aList.add(accountFrm);
			//
			if (aList == null || aList.size() == 0 ) {
				
				System.out.println(nric);
			
				
				
				// ******throw execption or jump to error.jsp*************
				request.setAttribute("error", "Account Number is wrong");
				path="JSP/TransferE.jsp";
				
			} else {
				// TODO:
			
				System.out.println(AccountTrfrm);
				if ("C".equals(AccountTrfrm)) {
		
					System.out.println("Transfer from chequing");
					if (customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId())-Double.valueOf(amount) >= 0) {
						customerDaoImpl.subAmount(Double.valueOf(amount),accountFrm.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Account E-Transfer",amount,
								Etransfer,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans ,nric);
					//	customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						path = "JSP/confirmationTransfer.jsp";
					} else {
												
						request.setAttribute("error","Your transfer amount exceed than minimum balance amount limit.");
						throw new BelowMinimumBalanceException();
					}
				}

				// TODO:
				if ("S".equals(AccountTrfrm)) {
					System.out.println("Transfer from savings");
		
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
				//		customerDaoImpl.addAmount((Double.valueOf(amount)),accountTo.getAccountId());
						Transaction trans=new Transaction(100,AccountId,"Account  E-Transfer",amount,
								Etransfer,DateTimeParser.currentTimeStamp());
						accountManager.insertTransaction(trans,nric);
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
