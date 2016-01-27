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

import BL.AdminManager;
import Bean.BankAccount;
import Bean.Transaction;


@WebServlet("/AdminSearchTransaction")
public class AdminSearchTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String folderPath="/JSP/";
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchTransaction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminSearchTransaction.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "JSP/AdminSearchTransaction.jsp";
		AdminManager mgr=new AdminManager();
		String accountId=(String)request.getParameter("accountId");
		
		
		
			
			if(accountId !=null && accountId!=""){
				System.out.println("Inside search transaction");
		//	BankAccount account=mgr.findAccountById(accountId);
			ArrayList<Transaction> transactions=  mgr.findTransactionByAccountId(accountId);
		//	request.setAttribute("accountId", accountId);
			request.setAttribute("transactions",transactions );
			
			
			System.out.println("Search transaction Done !!");
			}
			else
				request.setAttribute("error","Invalid Account Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}

	
	

}
