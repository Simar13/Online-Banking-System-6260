package DAO;

public interface BankAccountDetailDao {

	public void insertAccDetail(String nric, String accountId);

	public void deleteAccDetail(String nric, String accountId);

}
