package BL;

import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Customer;
import DAO.CustomerDao;
import DAO.DaoFactory;

public class CustomerManager {

	public Customer getCustomerById(String name, String password) {
		CustomerDao dao=DaoFactory.getCustomerDaoObject();
		Customer c=null;
		try {
			c=dao.getCustomersByIdPwd(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		// TODO Auto-generated method stub
	}
	public ArrayList<String> getAccountIDListByNric(Customer c){
		CustomerDao dao=DaoFactory.getCustomerDaoObject();
		ArrayList<String>  aidlist=new ArrayList<String>();
		try {
			aidlist=dao.getAccountIDByNric(c.getNric());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aidlist;
	}

}
