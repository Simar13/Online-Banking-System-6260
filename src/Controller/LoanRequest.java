package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AdminManager;
import BL.PreferenceManager;
import Bean.Loan;
import DAOImpl.CustomerDaoImpl;


@WebServlet("/LoanRequest")
public class LoanRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In loan Servlet GET MEthod--------- ");
		String path="";
		String action = request.getParameter("action");
	
		if (action.equalsIgnoreCase("request")) {
		path="JSP/LoanRequest.jsp";
		}
		else if (action.equalsIgnoreCase("loan")) 
			path="JSP/LoanPayLanding.jsp";
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path="JSP/LoanRequest.jsp";
		String nric = (String) session.getAttribute("nric");
		System.out.println("In loan Servlet--------- ");

		
		PreferenceManager mgr=new PreferenceManager();
		String duration = request.getParameter("duration");
		String amount = request.getParameter("amount");
		String rate = request.getParameter("rate");
		String insType = request.getParameter("insType");
		CustomerDaoImpl cust = new CustomerDaoImpl();
	//	Loan payee = new Loan();
		if(duration != null && amount != null&& rate!=null&& insType!=null){
			Loan loan = cust.getLoan(nric);
			double out =loan.getOutstanding()  ;
			String check =String.valueOf(out);
			if( out>0)
			{
				request.setAttribute("error","You have a Loan in progess , so you are not eligible for another loan. Sorry ");
				path="JSP/LoanPayLanding.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
			else if( check == null || out<=0){		
			
			mgr.requestLoan(nric,duration ,amount,rate,insType);
		
			path = "JSP/confirmationTransfer.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			}
		}
		else{
			request.setAttribute("error","Your Loan information is invalid.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
