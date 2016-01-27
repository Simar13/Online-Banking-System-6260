package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BL.AdminManager;
import BL.PreferenceManager;

@WebServlet("/AdminLoanAction")
public class AdminLoanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	String path = "/JSP/AdminLoanRequest.jsp";
		String action = request.getParameter("action");
		PreferenceManager mgr=new PreferenceManager();
		AdminManager admMgr = new AdminManager();
		System.out.println("In loan req action Servlet--------- ");
		if (action.equalsIgnoreCase("delete")) {
			System.out.println("In loan Servlet delete--------- ");
			String nric = request.getParameter("nric"); 
			String reject="R";
			mgr.changeLoanStatus(nric,reject);
			
			request.setAttribute("loan", admMgr.getAllLoanRequests());
		}
		else if (action.equalsIgnoreCase("loanRequestAll")) {
			System.out.println("In loana Servlet all req--------- ");
			request.setAttribute("loan", admMgr.getAllLoanRequests());
		} 
		else if (action.equalsIgnoreCase("approve")) {
			System.out.println("In loan Servlet approve--------- ");
			String nric = request.getParameter("nric"); 
			String approve="A";
			mgr.changeLoanStatus(nric,approve);
			admMgr.createLoan(nric);
			request.setAttribute("loan", admMgr.getAllLoanRequests());
			
			
		}
		else {
			System.out.println("In loan Servlet else--------- ");
			request.setAttribute("loan", admMgr.getAllLoanRequests());
		}
		request.getRequestDispatcher(path).forward(request, response);

    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
