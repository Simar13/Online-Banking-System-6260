package Bean;

public class BankBranch {
	private int BBID;
	private String location;
	private String name;
	private String description;
	
	public BankBranch(){
		
	}
	
	public BankBranch(int bBID, String location, String name, String description) {
		super();
		BBID = bBID;
		this.location = location;
		this.name = name;
		this.description = description;
	}
	
	public int getBBID() {
		return BBID;
	}


	public void setBBID(int bBID) {
		BBID = bBID;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
