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
import Bean.BankAccount;
import Bean.Customer;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminSearchAccount")
public class AdminSearchAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String folderPath="/JSP/";
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchAccount() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminSearchAccount.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "JSP/AdminSearchAccount.jsp";
		AdminManager mgr=new AdminManager();

		
			String accountId=(String)request.getParameter("accountId");
		//	String accountId="123";
			if(accountId !=null && accountId!=""){
				System.out.println("Inside search account");
			BankAccount account=mgr.findAccountById(accountId);
			Customer customers=  mgr.findCustomerByAccountId(accountId);
			request.setAttribute("account", account);
	
			request.setAttribute("customers",customers );
			request.setAttribute("accountId", accountId);
			System.out.println("Search Account Done !!");
			}
			else
				request.setAttribute("error","Invalid Account Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}

	
	

}
