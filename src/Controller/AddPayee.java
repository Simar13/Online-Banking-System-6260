package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.PreferenceManager;
import Bean.Payee;


@WebServlet("/AddPayee")
public class AddPayee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="JSP/AddPayee.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path="JSP/AddPayee.jsp";
		String nric = (String) session.getAttribute("nric");
		
		

		
		PreferenceManager mgr=new PreferenceManager();
		String name = request.getParameter("name");
		String account = request.getParameter("accountNo");
		Payee payee = new Payee(name ,account);
		if(name != null && account != null){
			System.out.println("In add recipient  --------- "+payee);
			mgr.AddPayee(nric ,payee);
		//	request.setAttribute("success", "Your Recipient is successfully updated");
			
			//session.setAttribute("loginuser",new CustomerDaoImpl().findCustomer(customer.getNric()));
			path = "JSP/confirmationTransfer.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		else{
			request.setAttribute("error","Your Payee information is invalid.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
