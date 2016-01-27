package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.PreferenceManager;
import Bean.Customer;
import DAOImpl.CustomerDaoImpl;

/**
 * Servlet implementation class updateAddress
 */
@WebServlet("/updateAddress")
public class updateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("JSP/Profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		String nric = (String) session.getAttribute("nric");
		PreferenceManager mgr=new PreferenceManager();
		
	//	Customer customer=mgr.findCustomer(nric);
		String Address = request.getParameter("address");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("phonenumber");
		if(Address !=null && Email !=null && Phone !=null ){
			mgr.updateCustomerByNric(nric,Address,Email,Phone);
			request.setAttribute("error", "Your Profile has been successfully updated !!!!");
		}	
		else
			request.setAttribute("error","Updated information is invaild !");
		

		
		request.getRequestDispatcher("JSP/Profile.jsp").forward(request, response);
	}

}
