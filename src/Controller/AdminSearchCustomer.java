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


@WebServlet("/AdminSearchCustomer")
public class AdminSearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String folderPath="/JSP/";
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchCustomer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminSearchCustomer.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path = "JSP/AdminSearchCustomer.jsp";
		AdminManager mgr=new AdminManager();

		
		String nric=(String)request.getParameter("nric");
		//	String accountId="123";
			if(nric !=null && nric!=""){
				System.out.println("Inside search customers");
			
			Customer customers= mgr.findCustomers(nric);

			request.setAttribute("customers",customers );
		//	request.setAttribute("accountId", accountId);
			System.out.println("Search Customers Done !!");
			}
			else
				request.setAttribute("error","Invalid Customer Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}

	
	

}
