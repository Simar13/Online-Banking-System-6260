package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AccountManager;
import BL.PreferenceManager;
import Bean.Customer;
import DAOImpl.CustomerDaoImpl;


@WebServlet({"/forgetPassword"})
public class forgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/resetPassword1.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);	
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		session=request.getSession(true);
		
	//	String nric=(String) session.getAttribute("nric");
		String userid = request.getParameter("userid");
		System.out.println(userid);
		
		PreferenceManager mgr=new PreferenceManager();
		String path="/JSP/resetPassword1.jsp";
		Customer customer = new Customer();
			
		if(request.getParameter("userid")!= null)
		{
			
			System.out.println("user id is fine !!!!!!!!!!!!!!!!");
			
			try {
				customer = mgr.getCustomersByUserId(userid);
				String nric = customer.getNric();
				session.setAttribute("nric", nric);
				if(customer!=null){
					
						
					System.out.println("customer !!!!!" +customer);
					request.setAttribute("question1", customer.getQuestion1());
					request.setAttribute("question2", customer.getQuestion2());
					request.setAttribute("nric", customer.getNric());
	
					
					path="/JSP/resetPassword2.jsp";
					
				}
				else{
					System.out.println("customer null !!!!!!!!!!!!!!!!");
					request.setAttribute("error", "user id is not valid !");
				}
				
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
