package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AdminManager;
import Bean.BankAccount;
import Bean.Customer;
import Bean.Transaction;
import Helper.DateTimeParser;


@WebServlet("/AdminCreateUpdate")
public class AdminCreateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateUpdate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/AdminCustomerCreate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside createUpdate servlet");
		String path = "";
		AdminManager mgr=new AdminManager();
		String nric=(String) request.getParameter("nric");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String DOB=request.getParameter("dateofbirth");
		String nation=request.getParameter("nationality");
		String gender=request.getParameter("gender");
		String userId=request.getParameter("userid");
		String password=request.getParameter("password");
		String DOJ=request.getParameter("dateofjoining");
		String que1=request.getParameter("quest1");
		String que2=request.getParameter("quest2");
		String ans1=request.getParameter("answer1");
		String ans2=request.getParameter("answer2");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		//String accountId=(String)request.getParameter("accountId");
		if(nric != null && name != null && address != null && DOB != null && nation != null && gender != null && userId != null &&
				password != null && DOJ != null && que1 != null && que2 != null && ans1 != null && ans2 != null && email != null &&
				phone != null ){
			
			Customer c=new Customer(nric,name,address ,	DateTimeParser.parseDate(DOB),nation,gender,userId,password, 
					DateTimeParser.parseDate(DOJ),que1,que2,ans1,ans2,email,Long.parseLong(phone)
					,request.getParameter("usertype"),request.getParameter("status"));
			
			String insert=request.getParameter("Create");
			System.out.println("create button value :"+insert);
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Customer Insert Flag: "+ insert);
			
			if(insert.equalsIgnoreCase("Create")){
				System.out.println("Inside create"+insert);
				mgr.insertCustomer(c);
				request.setAttribute("customer", mgr.getCustomers());
			//	request.setAttribute("error","Customer created successfully !");
				path = "JSP/AdminCustomerCreateSuccess.jsp";
			}else{
				System.out.println("Inside update servlet :"+insert);
				mgr.updateCustomer(c);
				request.setAttribute("customer", mgr.findCustomer(nric));
				request.setAttribute("error","customer updated successfully !");
				path = "JSP/AdminCustomerUpdate2.jsp";
			}		
			
		}
		else
			request.setAttribute("error","Please fill all given fields !");
		

			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
	}

	
	

}
