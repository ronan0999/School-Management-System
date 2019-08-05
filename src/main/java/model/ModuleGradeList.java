package model;

import java.util.ArrayList;
import java.util.Map;
/**
 * <h1>Student</h1>
 * @author Ronan
 * The ModuleGradeList class will store all the modules and grades for a student.
 */
public class ModuleGradeList {
	//ArrayList<Module_Grade> mglist;
	ArrayList<Module_Grade> mglist;
	private final int maxModules;
	private int numModules;
	
	/**
	 * Constructor
	 * A new arrayList is created. A max number is set as a student cannot have more than 6 modules
	 */
	public ModuleGradeList() {
		this.mglist = new ArrayList<Module_Grade>();
		this.maxModules = 6;
		this.numModules = 0;
	}
	
	/**
	 * This method adds a new ModuleGrade to the list.
	 * @param mg This the ModuleGrade object to be added.
	 */
	public void add(Module_Grade mg) {
		if (this.numModules < this.maxModules){
			this.mglist.add(mg);
			this.numModules++;
		}
		else {
			System.out.println("You cannot have more than 6 modules");
		}
	}
	
	/**
	 * This method removes a ModuleGrade from the list. 
	 * @param index This is the position at which the ModuleGrade to be removed is at.
	 */
	public void remove(int index) {
		if (numModules > 0) {
			this.mglist.remove(index);
			this.numModules--;
		}
		else {
			System.out.println("There are no modules");
		}
	}

	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		String modulesDetails = "Number of modules: " + numModules;
		for (int i = 0; i < maxModules; i++) {
			modulesDetails += "\nModule " + i + ": " + mglist.get(i).getModuleName() + " -> " + mglist.get(i).getGrade();
		}
		return modulesDetails + "\n";
	}
	
	
}
