package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BL.AdminManager;
import BL.PreferenceManager;
import DAOImpl.CustomerDaoImpl;


@WebServlet("/AdminDepositAction")
public class AdminDepositAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String path = "/JSP/AdminChequeView.jsp";
		String action = request.getParameter("action");
		String chequeNo = request.getParameter("chequeno");
		CustomerDaoImpl customerDaoImpl =new CustomerDaoImpl();
		System.out.println("In chequeaction Servlet--------- ");
		if (action.equalsIgnoreCase("delete")) {
			System.out.println("In cheque Servlet delete--------- ");
			String nric = request.getParameter("nric"); 
			String reject="R";
			customerDaoImpl.changeChequeStatus(chequeNo, reject);
			
			request.setAttribute("list",customerDaoImpl.getAllChequeRequests());
		}		
		else if (action.equalsIgnoreCase("approve")) {
			
			System.out.println("In cheque Servlet approve--------- ");
			String nric = request.getParameter("nric"); 
			String approve="A";
			customerDaoImpl.changeChequeStatus(chequeNo, approve);
			request.setAttribute("list",customerDaoImpl.getAllChequeRequests());
			
			
		}
		else if (action.equalsIgnoreCase("depositRequestAll")) { 
			System.out.println("In cheque Servlet else--------- ");
			request.setAttribute("list", customerDaoImpl.getAllChequeRequests());
			System.out.println("List size "+customerDaoImpl.getAllChequeRequests());
		}
		else{
			System.out.println("In cheque Servlet else--------- ");
			request.setAttribute("list", customerDaoImpl.getAllChequeRequests());
		}
		request.getRequestDispatcher(path).forward(request, response);

    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
