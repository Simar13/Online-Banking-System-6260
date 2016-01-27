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
import Bean.BankBranch;
import Bean.Customer;




@WebServlet("/AdminUpdateCustSearch")
public class AdminUpdateCustSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateCustSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminCustomerUpdate1.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);	
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession(true);
		String path = "JSP/AdminCustomerUpdate1.jsp";
		String nric=request.getParameter("nric");
		System.out.println("NRIC :"+ nric);
		AdminManager adminMgr=new AdminManager();
		
		if(nric!=null){
			Customer customer = adminMgr.findCustomer(nric);
			if(customer!=null){
					request.setAttribute("customer", customer);
					System.out.println("Inside update customer:" +customer);
					path = "JSP/AdminCustomerUpdate2.jsp";
			}
			else
				request.setAttribute("error","There is no custmer with provided customer ID !");
		}
		else{
			request.setAttribute("error","Please enter customer ID !");
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);		
	}
	
	
}
