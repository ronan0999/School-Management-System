package model;
/**
 * <h1>Name</h1>
 * The Name class shows structure of a name.
 * @author Ronan
 *
 */
public class Name {
	private String fname, mname, lname;
	/**
	 * 1st constructor that creates a name without a middle name.
	 * @param fname This is the first name.
	 * @param lname This is the last name.
	 */
	public Name(String fname, String lname) {
		this.fname = fname;
		this.mname = null;
		this.lname= lname;
	}
	
	/**
	 * 2nd constructor that creates a name with a middle name.
	 * @param fname This is the first name.
	 * @param mname This is the middle name.
	 * @param lname This is the last name.
	 */
	public Name(String fname, String mname, String lname) {
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		return "Name [fname=" + this.fname + ", mname=" + this.mname + ", lname=" + this.lname + "]";
	}
	
	
}
