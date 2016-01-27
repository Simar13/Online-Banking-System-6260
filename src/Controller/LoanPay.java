package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AdminManager;
import BL.PreferenceManager;
import Bean.Loan;


@WebServlet("/LoanPay")
public class LoanPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	session=request.getSession(true);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	String path = "JSP/LoanPay.jsp";
		AdminManager mgr=new AdminManager();

		String nric = (String) session.getAttribute("nric");
	//	String nric=(String)request.getParameter("nric");
		//	String accountId="123";
			if(nric !=null && nric!=""){
				System.out.println("Inside search loan");
				Loan loan= mgr.getLoan(nric);
				if(loan!=null){
					if(loan.getDefaulter().equalsIgnoreCase("N")){
						request.setAttribute("loan",loan );
					//	request.setAttribute("accountId", accountId);
						System.out.println("search loan Done !!");
					//	path = "JSP/LoanPay.jsp";
					}
					else
						request.setAttribute("error","Your loan account has been ceased due to irregular payment of installment."
								+ "Please contact you local branch.");
				}
				else
				request.setAttribute("error","There is some technical issue , please visit later :(");
			
			}
			else
				request.setAttribute("error","Invalid loan Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}	
    	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
