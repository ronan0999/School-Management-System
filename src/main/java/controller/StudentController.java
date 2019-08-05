package controller;

import java.util.ArrayList;

import model.Module_Grade;
import model.Student;
import view.StudentGUI;

/**
 * <h1>StudentController</h1>
 * @author Ronan
 * The student controller gives functionality to the buttons in the StudentGUI.
 */
public class StudentController {
	DatabaseController dbController;
	StudentGUI gui;
	
	/**
	 * Constructor
	 *  
	 */
	public StudentController(StudentGUI g) {
		dbController = new DatabaseController();
		gui = g;
	}
	
	/**
	 * This method adds a new student to a class group
	 * @param className This is the name of the class group
	 * @param fname This is the first name.
	 * @param mname This is the middle name.
	 * @param lname This is the last name.
	 * @param email This is the email.
	 * @param phone This is the phone number.
	 * @param dob This is the date of birth.
	 * @param id This is the id of the student.
	 */
	public void addStudent(String className, String fname, String mname, String lname, String email, String phone, String dob, String id) {
		boolean ok = true;
		String[] list = new String[] {className, fname, mname, lname, email, phone, dob, id};
		for (int i = 0; i < list.length; i++) {
			if (i == 2)
				continue;
			else if (list[i].equals("")) {
				ok = false;
			}
		}
		
		if (ok == true) {
			Student s = null;
			if (mname.equals("")) {
				s = new Student(id, fname, lname, email, phone, dob);
			}
			else 
				s = new Student(id, fname, mname, lname, email, phone, dob);
			
			dbController.insertStudent(s);
			dbController.insertClassGroups(className, s.getStudentId());
		}
		else {
			System.err.println("The required fields are not all filled");
			gui.getTextArea().appendText("\n\nThe required fields are not all filled\n\n");
			
		}
		
		gui.clearFields();
	}
	
	/**
	 * This method removes a student.
	 * @param sId This is the id of the student.
	 */
	public void removeStudent(String sId) {
		if (!sId.equals(""))
			dbController.deleteStudent(sId);
		else {
			System.err.println("Please specify the student id");
			gui.getTextArea().appendText("\n\nPlease specify the student id\n\n");
		}
		gui.clearFields();
	}
	
	/**
	 * This method adds a ModuelGrade.
	 * @param moduleName This is the name of the module.
	 * @param sId This is the id of the student
	 * @param grade This is the grade the student got.
	 */
	public void addModuleGrade(String moduleName, String sId, String grade) {
		boolean ok = true;
		String[] list = new String[] {moduleName, sId, grade};
		for (int i = 0; i < list.length; i++) {
			if (i == 2)
				continue;
			else if (list[i].equals("")) {
				ok = false;
			}
		}
		
		if (ok == true) {
			Module_Grade mg = null;
			if (grade.equals("")) {
				mg = new Module_Grade(moduleName);
			}
			else {
				mg = new Module_Grade(moduleName, Integer.parseInt(grade));
			}
			dbController.insertModuleGrade(mg, sId);
		}
	
		else {
			System.err.println("The required fields are not all filled");
			gui.getTextArea().appendText("\n\nThe required fields are not all filled\n\n");
			
		}
		
		gui.clearFields();
	}
	
	/**
	 * This method removes a ModuleGrade.
	 * @param name This is the name of the module
	 * @param sId This is the id of the student
	 */
	public void removeModuleGrade(String name, String sId) {
		if (name.equals("") || sId.equals("")) {
			System.err.println("Please specify the module name and student id");
			gui.getTextArea().appendText("\n\nPlease specify the module name and student id\n\n");
		}
		else
			dbController.deleteModuleGrade(name, sId);
		
		gui.clearFields();
	}
	
	/**
	 * This method edits a ModuleGrade
	 * @param name This is the name of the module
	 * @param sId This is the id of the student
	 * @param grade This is the grade the student got.
	 */
	public void editModuleGrade(String name, String sId, String grade) {
		if (name.equals("") || sId.equals("") || Integer.parseInt(grade) < 0 || Integer.parseInt(grade) > 100) {
			System.err.println("The required fields are not all filled");
			gui.getTextArea().appendText("\n\nThe required fields are not all filled\n\n");
		}
		else
			dbController.updateModuleGrade(name, sId, Integer.parseInt(grade));
		
		gui.clearFields();
	}
	
	/**
	 * This method gets the modules and grades for a particular student
	 * @param sId This is the id od the student
	 * @param gui This is the gui to print to
	 */
	public void getModuleGrade(String sId, StudentGUI gui) {
		if (sId.equals("")) {
			System.err.println("Please specify the student id");
			gui.getTextArea().appendText("\n\nPlease specify the student id\n\n");
		}
		else
			dbController.getModuleGrade(sId, gui);
		gui.clearFields();
	}
	
	/**
	 * This method print and sort by last name all the students from a class group.
	 * @param className This is the name of the class group
	 * @param gui This is the gui to print to.
	 */
	public void sortAndListStudents(String className, StudentGUI gui) {
		if (className.equals("")) {
			System.err.println("Please specify the class group");
			gui.getTextArea().appendText("\n\nPlease specify the class group\n\n");
		}
		else
			dbController.getStudentsFromClass(className, gui);
		
		gui.clearFields();
	}
}
