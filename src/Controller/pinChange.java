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
 * Servlet implementation class pinChange
 */
@WebServlet("/pinChange")
public class pinChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pinChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		
		String accountId=(String) session.getAttribute("accountId");
		
		PreferenceManager mgr=new PreferenceManager();
		String path="/pages/client/pinchange.jsp";
			
		
		if(request.getParameter("newPIN").equals(request.getParameter("newPIN2")))
		{
			int oldPIN=Integer.parseInt(request.getParameter("oldPIN"));
			
			if(mgr.checkPIN(oldPIN,accountId)){
				
				int newPIN=Integer.parseInt(request.getParameter("newPIN"));
				mgr.updatePIN(accountId,newPIN);
				request.setAttribute("success", "Successfully update Bank account PIN.");
				
				path="pages/client/successMessage.jsp";
				
			}else{
				request.setAttribute("error", "Existing PIN number is not valid !");
			}
			
		}else{
			request.setAttribute("error", "New PIN numbers are not same !");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
