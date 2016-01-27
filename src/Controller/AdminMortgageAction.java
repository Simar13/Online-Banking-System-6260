package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BL.AdminManager;
import BL.PreferenceManager;


@WebServlet("/AdminMortgageAction")
public class AdminMortgageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String path = "/JSP/AdminMortgageRequest.jsp";
		String action = request.getParameter("action");
		PreferenceManager mgr=new PreferenceManager();
		AdminManager admMgr = new AdminManager();
		System.out.println("In mortgage req action Servlet--------- ");
		if (action.equalsIgnoreCase("delete")) {
			System.out.println("In mortgage Servlet delete--------- ");
			String nric = request.getParameter("nric"); 
			String reject="R";
			mgr.changeMortgageStatus(nric,reject);
			
			request.setAttribute("mortgage", admMgr.getAllMortgageRequests());
		}
		else if (action.equalsIgnoreCase("mortgageRequestAll")) {
			System.out.println("In mortgage Servlet all req--------- ");
			request.setAttribute("mortgage", admMgr.getAllMortgageRequests());
		} 
		else if (action.equalsIgnoreCase("approve")) {
			System.out.println("In mortgage Servlet approve--------- ");
			String nric = request.getParameter("nric"); 
			String approve="A";
			mgr.changeMortgageStatus(nric,approve);
			admMgr.createMortgage(nric);
			request.setAttribute("mortgage", admMgr.getAllMortgageRequests());
			
			
		}
		else {
			System.out.println("In mortgae Servlet else--------- ");
			request.setAttribute("mortgage", admMgr.getAllMortgageRequests());
		}
		request.getRequestDispatcher(path).forward(request, response);

    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
