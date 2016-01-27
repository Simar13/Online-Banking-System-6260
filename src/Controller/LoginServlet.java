package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BL.AccountManager;
import BL.CustomerManager;
import Bean.BankAccount;
import Bean.BankAccountDetail;
import Bean.Customer;
import DAO.BankAccountDao;
import DAO.CustomerDao;
import DAOImpl.BankAccountDaoImpl;
import DAOImpl.CustomerDaoImpl;


@WebServlet({"/Login"})
public class LoginServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
       
HttpSession session;
    
    /**
     * @see HttpServlet#HttpServlet()
     */


	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String logout=request.getParameter("logout");
		String accountId=request.getParameter("accountId");
		
		if(logout!=null && logout.equalsIgnoreCase("true")){
			
			session.invalidate();
			System.out.println("IN lougout"  );
			response.sendRedirect("JSP/Login.jsp");
		}else{
			
			// System.out.println(c);
			AccountManager accountmanager = new AccountManager();
			BankAccount bankaccount = new BankAccount();
			ArrayList<BankAccountDetail> aidlist = new ArrayList<BankAccountDetail>();
			ArrayList<BankAccount> banckaccountlist = new ArrayList<BankAccount>();
			try {
				aidlist = new CustomerDaoImpl().getAccountDetailByCustomerID((String)session.getAttribute("nric"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
				//session.setAttribute("accountId",accountId);
			for(BankAccountDetail bad: aidlist){
				bankaccount = accountmanager.findBankAcc(bad.getAccountId());
				if("C".equalsIgnoreCase(bankaccount.getAccountType())){
					request.setAttribute("chequingBalance", bankaccount.getBalance());
					request.setAttribute("chequingName", bankaccount.getAccountId());
					System.out.println(bankaccount.getBalance());
				}
				if("S".equalsIgnoreCase(bankaccount.getAccountType())){
					request.setAttribute("SavingBalanc", bankaccount.getBalance());
					request.setAttribute("savingName", bankaccount.getAccountId());
					System.out.println(bankaccount.getBalance());
				}
				System.out.println(bankaccount);
				
			}
		
			
			String path= "JSP/Account.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		// TODO Auto-generated method stub
		String path = "";
	
		String name = request.getParameter("id");
		String password = request.getParameter("pwd");
		CustomerManager mgr = new CustomerManager();
		AccountManager accountmanager = new AccountManager();

		Customer c = new Customer();
		// System.out.println(c);
		
		c = mgr.getCustomerById(name, password);
		System.out.println("*************2222*************");
		System.out.println(c);
		ArrayList<BankAccountDetail> aidlist = new ArrayList<BankAccountDetail>();
		ArrayList<BankAccount> banckaccountlist = new ArrayList<BankAccount>();
		BankAccount bankaccount = new BankAccount();

		try {
			if(("C").equalsIgnoreCase(c.getUserType())){
			aidlist = new CustomerDaoImpl().getAccountDetailByCustomerID(c
					.getNric());
			System.out.println("aidlist.size()==" + aidlist.size());

			if (c.getUserid() != null && c.getPassword() != null && aidlist != null 
				&& ("A").equalsIgnoreCase(c.getStatus())	) {
				
				path = "JSP/Account.jsp";
			
				for(BankAccountDetail bad: aidlist){
					bankaccount = accountmanager.findBankAcc(bad.getAccountId());
					if("C".equalsIgnoreCase(bankaccount.getAccountType())){
						request.setAttribute("chequingBalance", bankaccount.getBalance());
						request.setAttribute("chequingName", bankaccount.getAccountId());
						System.out.println(bankaccount.getBalance());
					}
					if("S".equalsIgnoreCase(bankaccount.getAccountType())){
						request.setAttribute("SavingBalanc", bankaccount.getBalance());
						request.setAttribute("savingName", bankaccount.getAccountId());
						System.out.println(bankaccount.getBalance());
					}
					System.out.println(bankaccount);
					
				}
				session.setAttribute("aidlist", aidlist);
				session.setAttribute("c", c);
				
				/*Store in session*/
				CustomerDao customerDao=new CustomerDaoImpl();
				Customer customer=customerDao.getCustomersByIdPwd(c.getUserid(), c.getPassword());
				/*BankAccountDao BankAccountDao = new BankAccountDaoImpl();
				BankAccount BankAccount = BankAccountDao.findOneAccountByNRIC(customer.getNric());*/
				session.setAttribute("nric",customer.getNric());
			//	request.getSession().setAttribute("bankaccount",BankAccount );
				
			}else {
				path = "JSP/Login.jsp"; 
				request.setAttribute("message", "Deactivated User"); }
			
			}
			
			else if (c.getUserid() != null && c.getPassword() != null && ("A").equalsIgnoreCase(c.getUserType())	
					&&  ("A").equalsIgnoreCase(c.getStatus())	){
				path = "JSP/Admin.jsp";
			}
			else {
				path = "JSP/Login.jsp";
				request.setAttribute("message", "Invalid user name and password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	//	response.sendRedirect(arg0);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}