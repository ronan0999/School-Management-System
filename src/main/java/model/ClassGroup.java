package model;

import java.util.ArrayList;

/**
 * <h1>ClassGroup</h1>
 * The ClassGroup class models how a class group looks like and what it does.
 * @author Ronan
 *
 */
public class ClassGroup {
	ArrayList<Student> studentList;
	
	/**
	 * Constructor
	 * Creates a new arrayList that will store the students in this new ClassGroup.
	 */
	public ClassGroup() {
		studentList = new ArrayList<Student>();
	}
	/**
	 * This method adds a new student to the ClassGroup.
	 * @param s This is the Student object to be added to the ClassGroup.
	 */
	public void add(Student s) {
		studentList.add(s);
	}
	
	/**
	 * This method removes a student from the ClassGroup.
	 * @param index This is the position at which the student to be removed is at.
	 */
	public void remove(int index) {
		studentList.remove(index);
	}
	
	/**
	 * This method lists all the students in the ClassGroup.
	 */
	public void list() {
		System.out.println("Class Details: ");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println("Student " + (i+1) + ": " + studentList.get(i).toString());
		}
	}
	
	
}
