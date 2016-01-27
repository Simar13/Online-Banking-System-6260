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
import Bean.Mortgage;
import DAOImpl.CustomerDaoImpl;


@WebServlet("/MortgageRequest")
public class MortgageRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MortgageRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="";
		String action = request.getParameter("action");
	
		if (action.equalsIgnoreCase("request")) {
		path="JSP/MortgageRequest.jsp";
		}
		else if (action.equalsIgnoreCase("mortgage")) 
			path="JSP/MortgagePayLanding.jsp";
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		String path="JSP/MortgageRequest.jsp";
		String nric = (String) session.getAttribute("nric");
		System.out.println("In loan Servlet--------- ");

		
		PreferenceManager mgr=new PreferenceManager();
		String duration = request.getParameter("duration");
		String amount = request.getParameter("amount");
		String rate = request.getParameter("rate");
		String income = request.getParameter("income");
		String expenditure = request.getParameter("expenditure");
		String price = request.getParameter("price");
		String down = request.getParameter("down");
		String insType = request.getParameter("insType");
		AdminManager admMgr = new AdminManager();	
		CustomerDaoImpl cust = new CustomerDaoImpl();
	//	Loan payee = new Loan();
		if(duration != null && amount != null&& rate!=null && income != null&& expenditure!=null && price != null&& down!=null&& insType!=null){
			Mortgage mort = cust.getMortgage(nric);
			double out =mort.getOutstanding()  ;
			String checkOut =String.valueOf(out);
			if( out>0)
			{
				request.setAttribute("error","You have a mortgage in progess , so you are not eligible for another mortgage. Sorry ");
				path="JSP/MortgagePayLanding.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
			else if( checkOut == null || out<=0){	
			double Depth  = admMgr.calculateDepthRaito(Double.parseDouble(expenditure), Double.parseDouble(income));
			double DownToPrice = admMgr.calculateMortgageRatioToDown(Double.parseDouble(price), Double.parseDouble(down));
			boolean check = admMgr.isEligibile(DownToPrice, Depth);
			if(check){
				mgr.requestMortgage(nric,duration ,amount,rate,income,expenditure,price,down,insType);
				path = "JSP/confirmationTransfer.jsp";
			}
			else{
				request.setAttribute("error","Your are not eligible for mortgage according to bank's policy. Please contact your local branch for futher information");
			}
		
			
			request.getRequestDispatcher(path).forward(request, response);
			}
		}
		else{
			request.setAttribute("error","Your Mortgage information is invalid.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
