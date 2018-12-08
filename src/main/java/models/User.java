package models;

public abstract class User {
	String firstName;
	String familyName;
	String dob;
	String email;
	String age;

	public User() {

	}

	public User(String firstName, String familyName, String dob, String email, String age) {
		super();
		this.firstName = firstName;
		this.familyName = familyName;
		this.dob = dob;
		this.email = email;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String string) {
		this.dob = string;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
