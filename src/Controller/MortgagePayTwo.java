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
import Bean.BankAccount;
import Bean.Mortgage;
import DAOImpl.CustomerDaoImpl;


@WebServlet("/MortgagePayTwo")
public class MortgagePayTwo extends HttpServlet {
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
		String mortgageid=(String)request.getParameter("mortgageid");
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
			if(mortgageid !=null && mortgageid!=""){
				System.out.println("Inside search Mortgage");
				try {
						if(customerDaoImpl.getBalanceByAccountID(accountFrm.getAccountId())-Double.valueOf(installment) >= 0)
							mgr.payMortgage(mortgageid,installment);
							
						else {
					
						request.setAttribute("error","Your installment amount exceed than minimum balance amount limit.");
						path = "JSP/MortgagePay.jsp";
							}
						}
						catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				
				  Mortgage mort = mgr.getMortgageDetailsForSearch(mortgageid);
				  if(mort.getOutstanding()<=0)
					  request.setAttribute("error","Congratulation !! You have paid the entire Mortgage .");
			}
			else
				request.setAttribute("error","Invalid Mortgage Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		
		
	}

}
