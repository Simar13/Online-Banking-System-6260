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

import BL.TransactionManager;
import Bean.Transaction;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ArrayList<Transaction> fullTransList=null;
    ArrayList<Transaction> transList=null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Account_details.jsp");
		dispatcher.forward(request, response);	
	
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession(true);
		
		TransactionManager mgr=new TransactionManager();
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		//String accountId=(String) session.getAttribute("accountId");
		String accountId=request.getParameter("accountdetails");
		String [] AccountTo= accountId.split("---");
		String AccountId= AccountTo[0];
		String AccountType= AccountTo[1];
		String errorMsg="Please enter the date..";
		if(month!=null && month!="" && year!=null && year!=""){
			transList = mgr.getTransaction(month,year,AccountId);
			request.setAttribute("FullTransList", transList);
			System.out.println(" Transaction done !!! "+transList);
		}
		else{			
			
			String accId=request.getParameter("AccID");
			fullTransList=mgr.getAllTransactions(accId);
			request.setAttribute("FullTransList", fullTransList);
			request.setAttribute("error", errorMsg);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Account_details.jsp");
		dispatcher.forward(request, response);	
	
	}
	
	
	
}
