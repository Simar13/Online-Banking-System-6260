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
import Bean.Mortgage;


@WebServlet("/AdminSearchMortgage")
public class AdminSearchMortgage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchMortgage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminMortgageDetails.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "JSP/AdminMortgageDetails.jsp";
		AdminManager mgr=new AdminManager();

		
		String mortgageid=(String)request.getParameter("mortgageid");
		//	String accountId="123";
			if(mortgageid !=null && mortgageid!=""){
				System.out.println("Inside search mortgage");
				Mortgage mortgage= mgr.getMortgageDetailsForSearch(mortgageid);
				if(mortgage!=null){
					
						request.setAttribute("mortgage",mortgage );
					//	request.setAttribute("accountId", accountId);
						System.out.println("search loan Done !!");
						path = "JSP/AdminMortgageDetails1.jsp";
				}
				else
				request.setAttribute("error","There is no custmer with provided customer ID !");
			
			}
			else
				request.setAttribute("error","Invalid loan Number/ID");
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}	

}
