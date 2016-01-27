package Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import BL.DepositManager;



@WebServlet("/deposit")
@MultipartConfig(maxFileSize = 4096000)    // upload file's size up to 4MB
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		 String firstName = request.getParameter("firstname");
	        String lastName = request.getParameter("lastname");
	    //    String nric = (String) session.getAttribute("nric");
	        String nric="cst1";
	        String bank = request.getParameter("bankname");
	        String accountno = request.getParameter("account");
	        
			String [] AccountTo= accountno.split("---");
			String AccountIdTo= AccountTo[0];
			String AccountTrTo= AccountTo[1];
	        String amount = request.getParameter("amount");
	        String chequeno = request.getParameter("cheqnumber");
	      //  String lastName = request.getParameter("lastName");
	         
	        InputStream inputStream = null; // input stream of the upload file
	         
	       
	        Part filePart = request.getPart("file");
	        if (filePart != null) {
	       
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	       
	            inputStream = filePart.getInputStream();
	        }
		
		DepositManager mgr=new DepositManager();
		RequestDispatcher dispatcher=null;
		
		
	//	String accountId=(String) session.getAttribute("accountId");
		
		if(mgr.DepositAmountByAccountId(nric, chequeno, bank, firstName, lastName,
				AccountIdTo, amount ,  inputStream)){
			String msg = "Deposit Successfull!!";
			request.setAttribute("success", msg);
			dispatcher=request.getRequestDispatcher("/JSP/confirmationTransfer.jsp");
			dispatcher.forward(request, response);
		}
		else{
			String er = "Deposit not successfull... Invalid Pin!!";
			request.setAttribute("error", er);
			dispatcher = request
					.getRequestDispatcher("/JSP/ChequeDeposit.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
