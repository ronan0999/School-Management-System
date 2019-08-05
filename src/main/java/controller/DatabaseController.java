package controller;

import java.sql.Connection;
import model.*;
import view.StudentGUI;
import view.TeacherGUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import database.Database;
/**
 * <h1>DatabaseController</h1>
 * The DatabaseController class interacts with the database. 
 * @author Ronan
 *
 */
public class DatabaseController {
	private Database db;
	//private static Statement stmt;
	
	/**
	 * Constructor
	 * Creates a new database connection.
	 */
	public DatabaseController() {
		db = new Database();
		/*try {
			stmt = db.getConn().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	
	
	/*public void getStudents() {
		db.getStudents();
	}*/
	
	/**
	 * This method prints all the students from a class in order of last name.
	 * @param className This is the name of the class group
	 * @param gui This is the gui to print to.
	 */
	public void getStudentsFromClass(String className, StudentGUI gui) {
		db.getStudentsFromClass(className, gui);
	}
	
	/**
	 * This method prints all the teachers.
	 * @param gui This is the gui to print to.
	 */
	public void getTeachers(TeacherGUI gui) {
		db.getTeachers(gui);
	}
	
	/**
	 * This method gets the modules and grades for a particular student
	 * @param sId This is the id od the student
	 * @param gui This is the gui to print to
	 */
	public void getModuleGrade(String sId, StudentGUI gui) {
		db.getModuleGrade(sId, gui);
	}
	
	/*public void getModule() {
		db.getModule();
	}
	
	
	
	public void getSchool() {
		db.getSchool();
	}*/
	
	/**
	 * This method inserts a new student to the database
	 * @param s This is the student to be inserted.
	 */
	public void insertStudent(Student s) {//(String fname, String mname, String lname, String email, String phone, String dob) {
		/*Student s = null;
		if (mname == null) {
			s = new Student(fname, lname, email, phone, dob);
		}
		else {
			s = new Student(fname, mname, lname, email, phone, dob);
		}*/
		
		db.insertStudent(s);
	}
	
	/*public void insertTeacher(String fname, String mname, String lname, String email, String phone, String degree, String id) {
		Teacher t = null;
		if (mname == null) {
			t = new Teacher(id, fname, lname, email, phone, degree);
		}
		else {
			t = new Teacher(id, fname, mname, lname, email, phone, degree);
		}
		
		db.insertTeacher(t);
	}
	
	public void insertSchool(String schoolName) {
		School school = new School(schoolName);
		
		db.insertSchool(school);
	}*/
	
	/**
	 * This method inserts a new ModuleGrade to the database
	 * @param mg This is the ModuleGrade to be inserted
	 * @param sId This is the id of the student.
	 */
	public void insertModuleGrade(Module_Grade mg, String sId) {
		/*Module_Grade mg = null;
		
		if (grade < 0) {
			mg = new Module_Grade(moduleName);
		}
		else {
			mg = new Module_Grade(moduleName, grade);
		}*/
		db.insertModuleGrade(mg, sId);
	}
	
	/**
	 * This method inserts a student to a ClassGroup in the database
	 * @param className This is the name of the class group
	 * @param sId This is the id of the student.
	 */
	public void insertClassGroups(String className, String sId) {
		db.insertClassGroup(className, sId);
	}
	
	/**
	 * This method deletes a student from the database
	 * @param sId This is the id of the student
	 */
	public void deleteStudent(String sId) {
		db.deleteStudent(sId);
		db.deleteStudentClassGroup(sId);
	}
	 /**
	  * This method deletes a module grade for a student.
	  * @param name This is the name of the module
	  * @param sId This is the id of the student.
	  */
	public void deleteModuleGrade(String name, String sId) {
		db.deleteModuleGrade(name, sId);
	}
	
	/**
	 * This method adds a grade to a module for a student.
	 * @param name This is the name of the module.
	 * @param sId This is the id of the student
	 * @param grade This is the grade the student got.
	 */
	public void updateModuleGrade(String name, String sId, int grade){
		db.editModuleGrade(name, sId, grade);
	}
}
