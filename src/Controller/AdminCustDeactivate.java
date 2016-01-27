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
import Bean.Customer;



@WebServlet("/AdminCustDeactivate")
public class AdminCustDeactivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCustDeactivate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "JSP/AdminCustomerDeactivate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession(true);
		String path = "JSP/AdminCustomerDeactivate.jsp";
		String nric=request.getParameter("nric");
		String name=request.getParameter("name");
		String status=request.getParameter("status");
		System.out.println("NRIC :"+ nric);
		AdminManager adminMgr=new AdminManager();
		Customer customer = null;
		if(nric!=null && name==null){
		 customer = adminMgr.findCustomer(nric);
			if(customer!=null){
					request.setAttribute("customer", customer);
					System.out.println("Inside deactivate customer success" +customer);
					path = "JSP/AdminCustomerDeactivateTwo.jsp";
			}
			else
				request.setAttribute("error","There is no custmer with provided customer ID !");
		}
		else if(nric==null && name==null){
			request.setAttribute("error","Please enter customer ID !");
			 path = "JSP/AdminCustomerDeactivate.jsp";
			
		}
		else if(nric!=null && name!=null){
			if(status.equalsIgnoreCase("D") || status.equalsIgnoreCase("A")){
				System.out.println("Before deactivation" );
			  adminMgr.deactivateCustomerByNric(nric,status);
			  customer = adminMgr.findCustomer(nric);
			  System.out.println("After deactivation" +customer);
			  request.setAttribute("customer", customer);
			  request.setAttribute("error","Customer deactivated successfully !");
			  path = "JSP/AdminCustomerDeactivateTwo.jsp";
			}
			else{
				request.setAttribute("error","Please enter only A or D in status field !");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);		
	}
	
	
}
