package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AccountManager;
import BL.PreferenceManager;
import DAOImpl.CustomerDaoImpl;

/**
 * Servlet implementation class passwordChange
 */
@WebServlet({"/passwordChange"})
public class passwordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordChange() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path="/JSP/passwordChange.jsp";
    	request.getRequestDispatcher(path).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		
		String nric = (String) session.getAttribute("nric");
		System.out.println(nric);
		
		PreferenceManager mgr=new PreferenceManager();
		String path="/JSP/passwordChange.jsp";
			
		
		if(request.getParameter("newPassword").equals(request.getParameter("rePassword")))
		{
			String oldPIN= request.getParameter("oldPassword");
			System.out.println("new passwords matched !!!!!!!!!!!!!!!!");
			
			if(mgr.checkPassword(oldPIN,nric)){
				
				String newPassword=request.getParameter("newPassword");
				System.out.println("old password matched !!!");
				mgr.updatePassword(nric,newPassword);
				System.out.println("password changed !!!!!" +newPassword);
				request.setAttribute("success", "Successfully update bank portal password.");
				
				path="JSP/passwordSuccessChanged.jsp";
				
			}else{
				request.setAttribute("error", "Existing password  is not valid !");
			}
			
		}else{
			request.setAttribute("error", "New passwords does not match !");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
