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

import BL.PreferenceManager;
import Bean.Customer;

/**
 * Servlet implementation class passwordChange
 */
@WebServlet({"/forgetPasswordVerify"})
public class forgetPasswordVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetPasswordVerify() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/resetPassword2.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);	
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession(true);
		
	//	String userid=(String) session.getAttribute("userid");
	//	String userid = request.getParameter("userid");
	//	System.out.println(userid);
		
		PreferenceManager mgr=new PreferenceManager();
		String path="/JSP/resetPassword2.jsp";
		Customer customer = new Customer();
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String newPassword = request.getParameter("newpassword");
		String rePassword = request.getParameter("repassword");
		String nric = (String) session.getAttribute("nric");
		System.out.println("verify serlvet get attributes"+answer1+answer2+newPassword+rePassword+nric);
		String ans1 , ans2 ;
		
		if("nric"!= null)
		{
			
			System.out.println("nric is fine !!!!!!!!!!!!!!!!");
			
			
				customer = mgr.findCustomer(nric);
				if(customer!=null){
					
						
					System.out.println("customer in verify servlet !!!!!" +customer);
			
					ans1 = customer.getAnswer1();
					ans2 = customer.getAnswer2();
					
					if(answer1.equalsIgnoreCase(ans1)&& answer2.equalsIgnoreCase(ans2)){
						if(request.getParameter("newpassword").equals(request.getParameter("repassword")))
						{
							mgr.updatePassword(nric,newPassword);
							path="JSP/passwordSuccessChanged.jsp";
						}
						else{
							request.setAttribute("error", "New passwords does not match !");
						}
												
					}
					else{
						
							request.setAttribute("error", "Security answers does not match !");
						}
					
					
					
				}
				else{
					System.out.println("customer null !!!!!!!!!!!!!!!!");
					request.setAttribute("error", "user id is not valid !");
				}
				
			}
			 
			
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
