package model;
/**
 * <h1>Teacher</h1>
 * @author Ronan
 * The Teacher class models how a Teacher looks like. It inherits from the Person class.
 */
public class Teacher extends Person{
	private String degree;
	//private static int id = 49;
	private String teacherId;
	
	/**
	 * 1st constructor that will create a new Teacher without a middle name.
	 * @param id This is the id of the teacher.
	 * @param fname This is the first name of the teacher.
	 * @param lname This is the last name of the teacher.
	 * @param email This is the email of the teacher.
	 * @param phone This is the phone number of the teacher.
	 * @param degree This is the degree that the teacher has.
	 */
	public Teacher(String id, String fname, String lname, String email, String phone, String degree) {
		super(fname, lname, email, phone);
		//id++;
		this.degree = degree;
		this.teacherId = id;
	}
	
	/**
	 * 2nd constructor that will create a new Teacher with a middle name.
	 * @param id This is the id of the teacher.
	 * @param fname This is the first name of the teacher.
	 * @param mname This is the middle of the teacher.
	 * @param lname This is the last name of the teacher.
	 * @param email This is the email of the teacher.
	 * @param phone This is the phone number of the teacher.
	 * @param degree This is the degree that the teacher has.
	 */
	public Teacher(String id, String fname, String mname, String lname, String email, String phone, String degree) {
		super(fname, mname, lname, email, phone);
		//id++;
		this.degree = degree;
		this.teacherId = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		return "Teacher [degree=" + degree + "]";
	}
	
	
	
}
