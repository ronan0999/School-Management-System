package controller;

import view.TeacherGUI;
/**
 * <h1>TeacherController</h1>
 * @author Ronan
 * The TeacherController class gives functionality to the buttons in the TeacherGUI.
 */
public class TeacherController {
	DatabaseController dbController;
	//TeacherGUI gui;
	
	/**
	 * Constructor
	 */
	public TeacherController() {
		dbController = new DatabaseController();
		//gui = gui;
	}
	
	/**
	 * This method prints all the teachers
	 * @param gui This is the gui to print to.
	 */
	public void listTeachers(TeacherGUI gui) {
		dbController.getTeachers(gui);
	}
}
