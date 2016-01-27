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
import Bean.Loan;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminSearchLoan")
public class AdminSearchLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchLoan() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminLoanDetails.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "JSP/AdminLoanDetails.jsp";
		AdminManager mgr=new AdminManager();

		
		String loanid=(String)request.getParameter("loanid");
		//	String accountId="123";
			if(loanid !=null && loanid!=""){
				System.out.println("Inside search loan");
				Loan loan= mgr.getLoanDetailsForSearch(loanid);
				if(loan!=null){
					
						request.setAttribute("loan",loan );
					//	request.setAttribute("accountId", accountId);
						System.out.println("search loan Done !!");
						path = "JSP/AdminLoanDetails1.jsp";
				}
				else
				request.setAttribute("error","There is no custmer with provided customer ID !");
			
			}
			else
				request.setAttribute("error","Invalid loan Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}	

}
