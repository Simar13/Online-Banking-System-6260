package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AdminManager;
import BL.PreferenceManager;
import Bean.BankAccount;
import Bean.Loan;
import DAOImpl.CustomerDaoImpl;
import Exception.BelowMinimumBalanceException;


@WebServlet("/LoanPayTwo")
public class LoanPayTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = "JSP/confirmationTransfer.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
    	
	}	
    	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String nric = (String) session.getAttribute("nric");
		String path = "JSP/confirmationTransfer.jsp";
		String loanid=(String)request.getParameter("loanid");
		String installment=(String)request.getParameter("installment");
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		BankAccount accountFrm = new BankAccount();
		try {
			accountFrm = customerDaoImpl.accountNoIsExist(nric ,"C");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminManager mgr=new AdminManager();
		//	String accountId="123";
			if(loanid !=null && loanid!=""){
				System.out.println("Inside search loan");
				try {
					if(customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId())-Double.valueOf(installment) >= 0)
					  mgr.payLoan(loanid,installment);
							
				else {
					
						request.setAttribute("error","Your installment amount exceed than minimum balance amount limit.");
						path = "JSP/LoanPay.jsp";
					}
				}
				catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				  Loan loan = mgr.getLoanDetailsForSearch(loanid);
				  if(loan.getOutstanding()<=0)
					  request.setAttribute("error","Congratulation !! You have paid the entire Loan .");
			}
			else
				request.setAttribute("error","Invalid loan Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		
		
	}

}
