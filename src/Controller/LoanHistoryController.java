  package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.PreferenceManager;
import Bean.LoanHistory;


@WebServlet("/LoanHistoryController")
public class LoanHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path = "JSP/LoanHistory.jsp";
		PreferenceManager mgr=new PreferenceManager();

		

		String nric = (String) session.getAttribute("nric");
			if(nric !=null && nric!=""){
				System.out.println("Inside search loan history");
				ArrayList<LoanHistory> loanHistory= mgr.getLoanHistory(nric);
				if(loanHistory!=null){
					
						request.setAttribute("loanHistory",loanHistory );
					//	request.setAttribute("accountId", accountId);
						System.out.println("search loan history Done !!");
					//	path = "JSP/AdminLoanDetails1.jsp";
				}
				else
				request.setAttribute("error","There is no custmer with provided customer ID !");
			
			}
			else
				request.setAttribute("error","Invalid loan Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}	

}
