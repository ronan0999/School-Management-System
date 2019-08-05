package model;

import java.util.ArrayList;
/**
 * <h1>School</h1>
 * @author Ronan
 * The School class models how a school looks like.
 */
public class School {
	private String schoolName;
	private ArrayList<ClassGroup> classList;
	//private static int id = 99;
	private int schoolId;
	
	/**
	 * Constructor that creates a new arrayList that will store all the ClassGroups in the school.
	 */
	public School(String name) {
		//id++;
		this.schoolName = name;
		classList = new ArrayList<ClassGroup>();
		//schoolId = id;
	}
	
	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public int getSchoolId() {
		return schoolId;
	}


	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * This methods will add new ClassGroups to the arrayList.
	 * @param c This is the ClassGroup object to be added
	 */
	public void add(ClassGroup c) {
		classList.add(c);
	}
	
	/**
	 * This method will remove a ClassGroup from the list.
	 * @param index This is the position at which the ClassGroup to be removed is at.
	 */
	public void remove(int index) {
		classList.remove(index);
	}
	
	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		return "School [classList=" + classList + "]";
	}
	
	
}
