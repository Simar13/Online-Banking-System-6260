package Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import Bean.Cheque;
import Helper.ConnectionSetter;




@WebServlet("/AdminDeposit")
public class AdminDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	 private static final int BUFFER_SIZE = 4096000;
	 Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		String query, error;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path = "JSP/AdminChequeView.jsp";
		String chequeno=request.getParameter("chequeno");
		System.out.println("NRIC :"+ chequeno);
	//	AdminManager adminMgr=new AdminManager();
		Cheque cheque = new Cheque();
		ArrayList<Cheque> list = new ArrayList<Cheque>();
 

 
        query = "select * from cheque where status='P' and chequeno='"+chequeno+"' ";

		connection = ConnectionSetter.getConnection();
		//PrintWriter pw = response.getWriter();
		try {
			 response.setContentType("image/jpeg");
			statement = connection.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing retrieve: " + query);
			rs = statement.executeQuery(query);
           OutputStream outputStream = response.getOutputStream();
  //         Cheque cheque = new Cheque();
           while (rs.next()) {
               
               // inputStream.close();
               // outputStream.close();
              cheque.setAccountNo(rs.getString("accountno"));
              cheque.setAmount(rs.getString("amount"));
              cheque.setBank("bank");
              cheque.setChequeNo(rs.getString("chequeno"));
              cheque.setFirstName(rs.getString("firstname"));
              cheque.setLastName(rs.getString("lastname"));
              list.add(cheque);
              Blob blob = rs.getBlob("photo");
              int i= (int) blob.length();
              byte[] buffer=blob.getBytes(1, i);
                   	outputStream.write(buffer);               
              	outputStream.flush();
              	outputStream.close();
            }
           
            connection.close();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		request.setAttribute("list",list);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);		
	
	
		// TODO Auto-generated method stub
		//response.getWriter().println("<b>hello</b>");
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	
}
}
