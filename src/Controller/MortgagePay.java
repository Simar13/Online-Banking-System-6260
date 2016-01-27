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
import Bean.Mortgage;


@WebServlet("/MortgagePay")
public class MortgagePay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	session=request.getSession(true);
    	String path = "JSP/MortgagePay.jsp";
		AdminManager mgr=new AdminManager();

		String installment=(String)request.getParameter("installment");
		String nric = (String) session.getAttribute("nric");
			if(nric !=null && nric!=""){
				System.out.println("Inside search mortgage");
				Mortgage mortgage= mgr.getMortgage(nric);
				if(mortgage!=null){
					if(mortgage.getDefaulter().equalsIgnoreCase("N")){
						request.setAttribute("mortgage",mortgage );
					//	request.setAttribute("accountId", accountId);
						System.out.println("search mortgage Done !!");
					//	path = "JSP/LoanPay.jsp";
					}
					else
						request.setAttribute("error","Your Mortgage account has been ceased due to irregular payment of installment."
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
