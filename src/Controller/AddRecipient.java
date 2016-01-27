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
import Bean.Recipient;
import DAOImpl.CustomerDaoImpl;


@WebServlet("/AddRecipient")
public class AddRecipient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecipient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="JSP/AddRecipient.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path="JSP/AddRecipient.jsp";
		String nric = (String) session.getAttribute("nric");
	
		

		
		PreferenceManager mgr=new PreferenceManager();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Recipient recp = new Recipient(name ,email);
		if(name != null && email != null){
			System.out.println("In add recipient  --------- "+recp);
			mgr.AddRecipient(nric ,recp);
		//	request.setAttribute("success", "Your Recipient is successfully updated");
			
			//session.setAttribute("loginuser",new CustomerDaoImpl().findCustomer(customer.getNric()));
			path = "JSP/confirmationTransfer.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		else{
			request.setAttribute("error","Your recipient information is invalid.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
