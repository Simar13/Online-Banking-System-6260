package DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Bean.Transaction;
import DAO.TransactionDao;
import Helper.ConnectionSetter;
import Helper.DateTimeParser;



public class TransactionDaoImpl implements TransactionDao {


	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	PreparedStatement ps=null;
	
	String query,error;
	
	@Override
	public ArrayList<Transaction> findTransactionByAccountId(String accountId) {
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
	
		query="select * from transaction where accountFromTransfer='"+accountId+"'";
		
		connection=ConnectionSetter.getConnection();
		
		try {
			
			statement = connection.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,"Executing retrieve: " + query);
			rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Transaction tran=new Transaction(rs.getInt(1), rs.getString(7), rs.getString(6),
						rs.getDouble(4), rs.getString(3), rs.getTimestamp(5));
				
				transactions.add(tran);
			}
			
		}catch (SQLException e) {
			error="Error in Retrieve :" + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
		}finally{
			close();
		}
		
		return transactions;
	}
	
	public void close(){
		try {
			if (rs!=null) {
				rs.close();
			}
			
			if(statement!=null){
				statement.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
			
		} catch (Exception e) {
			
		}
	}
		
	@Override
	//Create a transaction object with the data you have and pass here!
	public void insertTransaction(Transaction transaction,String nric) {
	//	int insert=0;
		openConnection();
		try {
			ps=connection.prepareStatement("insert into transaction(nric,accountToTransfer,Amount,Date,"
					+ "transactionType,accountFromTransfer,monthyear) values(?,?,?,?,?,?,?)");
			ps.setString(1,nric);
			ps.setString(6,transaction.getAccountId());
			ps.setString(5,transaction.getTransactionType());
			ps.setDouble(3, transaction.getTransactionAmount());
			ps.setString(2, transaction.getDepositToAccount());
			ps.setTimestamp(4, DateTimeParser.currentTimeStamp());
			ps.setTimestamp(7, DateTimeParser.monthYearStamp());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
	
	public Transaction insertWithdraw(Transaction transaction) {
		openConnection();
		try {
			ps=connection.prepareStatement("insert into transaction(accountId,transactionType,"
					+ "transactionAmount, transactionTime) values(?,?,?,?)");
			ps.setString(1,transaction.getAccountId());
			ps.setString(2,transaction.getTransactionType());
			ps.setDouble(3, transaction.getTransactionAmount());
			ps.setTimestamp(4, DateTimeParser.currentTimeStamp());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		return transaction;
	}

	@Override
	public ArrayList<Transaction> getTransactionByDate(String month, String year, String accountId) {
		openConnection();
		String monthyear =year+"-"+month+"-01 00:00:00";
		ArrayList<Transaction> transList=new ArrayList<Transaction>();

		System.out.println("from: "+month+" to: "+year);
		try {
			ps=connection.prepareStatement("select * from transaction  where " +
					"monthyear='"+monthyear+"'  and accountFromTransfer=? or monthyear='"+monthyear+"' and accountToTransfer=?");
		
			ps.setString(1, accountId);
			ps.setString(2, accountId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Transaction transaction = new Transaction(rs.getInt("transactionId"), rs.getString("accountFromTransfer"),
						rs.getString("transactionType"), rs.getDouble("Amount"),
						rs.getString("accountToTransfer"), rs.getTimestamp("Date"));
				
				transList.add(transaction);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return transList;
	}
	
	private void openConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeConnection() {
		// TODO Auto-generated method stub
		try {
			connection.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Transaction> getAllTransactions(String accId) {
		openConnection();
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		
		try {
			ps=connection.prepareStatement("select * from transaction where accountFromTransfer=?");
			ps.setString(1, accId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Transaction transaction = new Transaction(rs.getInt("transactionId"), rs.getString("accountFromTransfer"),
						rs.getString("transactionType"), rs.getDouble("transactionAmount"),
						rs.getString("depositToAccount"), rs.getTimestamp("transactionTime"));
				
				transList.add(transaction);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			closeConnection();
		return transList;
	}

	
}


	


