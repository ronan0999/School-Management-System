package model;
/**
 * <h1>Person</h1>
 * @author Ronan
 * The Person class models what information a person will store. It is a super class.
 */
public class Person {
	private Name name;
	private String email, phone;
	
	/**
	 * 1st constructor that will create a new person without a middle name.
	 * @param fname This is the first name of the person.
	 * @param lname This is the last name of the person.
	 * @param email This is the email of the person.
	 * @param phone This is the phone number of the person.
	 */
	public Person(String fname, String lname, String email, String phone) {
		super();
		this.name = new Name(fname, lname);
		this.email = email;
		this.phone = phone;
	}
	
	/**
	 * 2nd constructor that will create a new person with a middle name.
	 * @param fname This is the first name of the person.
	 * @param mname This is the middle name of the person.
	 * @param lname This is the last name of the person.
	 * @param email This is the email of the person.
	 * @param phone This is the phone number of the person.
	 */
	public Person(String fname, String mname, String lname, String email, String phone) {
		this.name = new Name(fname, mname, lname);
		this.email = email;
		this.phone = phone;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
