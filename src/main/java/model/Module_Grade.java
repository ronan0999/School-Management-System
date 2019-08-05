package model;
/**
 * <h1>Module_Grade</h1>
 * @author Ronan
 * The ModuleGrade class models how a ModuleGrade object looks and does.
 */
public class Module_Grade {
	private String moduleName;
	private int grade;
	
	/**
	 * 1st constructor that will create a ModuleGrade without a grade if it is not specified.
	 * @param name This is the name of the module.
	 */
	public Module_Grade(String name) {
		this.moduleName = name;
		this.grade = -1;
	}
	
	/**
	 * 2nd constructor that will create a ModuleGrade with a grade.
	 * @param name This is the name of the module
	 * @param grade this is the grade the student got for the module.
	 */
	public Module_Grade(String name, int grade) {
		this.moduleName = name;
		this.grade = grade;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	/**
	 * toString() method	 
	 * */
	@Override
	public String toString() {
		return "Module_Grade [moduleName=" + moduleName + ", grade=" + grade + "]";
	}
	
	
}
