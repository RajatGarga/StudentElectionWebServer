package models;

public class Admin extends User {
	String pwd;
	String userName;

	public Admin(String firstName, String familyName, String dob, String email, String age, String pwd,
			String userName) {
		super(firstName, familyName, dob, email, age);
		this.pwd = pwd;
		this.userName = userName;
	}

	public Admin(String firstName, String familyName, String dob, String email, String age) {
		super(firstName, familyName, dob, email, age);
		this.pwd = null;
		this.userName = null;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}