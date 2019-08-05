package model;
/***
 * <h1>Student</h1>
 * The Student models what a student looks like. It inherits from the Person class.
 * @author Ronan
 *
 */
public class Student extends Person{
	private String dob;
	ModuleGradeList mgList;
	//private static int id = 9;
	private String studentId;
	
	/***
	 * 1st constructor that will create a Student without a middle name. For every Student created, a ModuleGradeList is created 
	 * to store the students modules and grades.
	 * 
	 * @param id This is the id of the Student
	 * @param fname This is the first name of the Student
	 * @param lname This is the last name of the Student
	 * @param email This is the email of the Student
	 * @param phone This is the phone number of the Student
	 * @param dob This is the date of birth of the Student
	 */
	public Student(String id, String fname, String lname, String email, String phone, String dob) {
		super(fname, lname, email, phone);
		//id++;
		this.dob = dob;
		mgList = new ModuleGradeList();
		this.studentId = id;
	}
	/***
	 * 2nd constructor that will create a Student with a middle name. For every Student created, a ModuleGradeList is created 
	 * to store the students modules and grades.
	 * 
	 * @param id This is the id of the Student
	 * @param fname This is the first name of the Student
	 * @param mname This is the middle name of the Student
	 * @param lname This is the last name of the Student
	 * @param email This is the email of the Student
	 * @param phone This is the phone number of the Student
	 * @param dob This is the date of birth of the Student
	 */
	public Student(String id, String fname, String mname, String lname, String email, String phone, String dob) {
		super(fname, mname, lname, email, phone);
		//id++;
		this.dob = dob;
		mgList = new ModuleGradeList();
		this.studentId = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void addModule(String moduleName, int grade) {
		mgList.add(new Module_Grade(moduleName, grade));
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void removeModule(int index) {
		mgList.remove(index);
	}
	
	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		return "Name:" + this.getName() + "\nDOB: " + this.getDob() + "\nEmail: " + this.getEmail() + "\nPhone: " + this.getPhone();
	}
	
	
}
