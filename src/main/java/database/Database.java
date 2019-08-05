package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.locks.StampedLock;
import model.*;
import view.StudentGUI;
import view.TeacherGUI;

/**
 * <h1>Database</h1>
 * @author Ronan
 * The Database class connects and handles queries to the schooldb database which stores all the school's information.
 */
public class Database {
	private static final String jdbc_url = "jdbc:derby:C:\\db-derby-10.14.2.0-bin\\bin\\schooldb;create=true";
	private Connection conn;
	private static Statement stmt;
	//private static PreparedStatement pstmt;
	
	/**
	 * Constructor
	 * Connects to the database.
	 */
	public Database() {
		try{
			System.out.println("beforeMade connection to db");
			this.conn= DriverManager.getConnection(jdbc_url);
			System.out.println("afterMade connection to db");
			if (this.conn!=null)
				System.out.println("Made connection to db");
			else
				System.out.println("didnt connect to db");
			
			stmt = this.conn.createStatement();
			/*ResultSet rs = stmt.executeQuery("select * from Student");
			
			while (rs.next()) {
				System.out.println(rs.getString("sId") + " : " + rs.getString("fname") + " : " + rs.getString("lname") + " : " + rs.getString("email")
				 + " : " + rs.getString("phone") + " : " + rs.getString("dob"));
				
			}*/
			
		}catch(SQLException e){}
	}
	
	/**
	 * This method prints all the students in the database.
	 */
	public void getStudents() {
		try {
			System.out.println("TABLE: STUDENTS");
			ResultSet rs = stmt.executeQuery("select * from Student");
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i = 1; i < 8; i++) {
				System.out.print(rsm.getColumnLabel(i) + " : ");
			}
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getString("sId") + " : " + rs.getString("fname") + " : " + rs.getString("mname") + " : " + rs.getString("lname") + " : " + rs.getString("email")
				 + " : " + rs.getString("phone") + " : " + rs.getString("dob"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method prints all the students in a specific class group/
	 * @param classId This is the class we want the students from.
	 * @param gui This is the gui we want to print to.
	 */
	public void getStudentsFromClass(String classId, StudentGUI gui) {
		try {
			//System.out.println("TABLE: STUDENTS");
			ResultSet rs = stmt.executeQuery("select s.sId, fname, mname, lname, email, phone, dob from Student s join ClassGroup c on s.sId = c.sId "
					+ "where c.classId = '" + classId + "' order by lname");
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i = 1; i < 8; i++) {
				System.out.print(rsm.getColumnLabel(i) + " : ");
				gui.getTextArea().appendText(rsm.getColumnLabel(i) + " : ");
			}
			System.out.println();
			gui.getTextArea().appendText("\n");
			while (rs.next()) {
				System.out.println(rs.getString("sId") + " : " + rs.getString("fname") + " : " + rs.getString("mname") + " : " + rs.getString("lname") + " : " + rs.getString("email")
				 + " : " + rs.getString("phone") + " : " + rs.getString("dob"));
				
				gui.getTextArea().appendText(rs.getString("sId") + " : " + rs.getString("fname") + " : " + rs.getString("mname") + " : " + rs.getString("lname") + " : " + rs.getString("email")
				 + " : " + rs.getString("phone") + " : " + rs.getString("dob") + "\n");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method prints all the teachers in the database.
	 * @param gui This is the gui we want to print to
	 */
	public void getTeachers(TeacherGUI gui) {
		try {
			System.out.println("TABLE: TEACHER");
			gui.getTextArea().appendText("TABLE: TEACHER\n");
			ResultSet rs = stmt.executeQuery("select * from Teacher");
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i = 1; i < 5; i++) {
				System.out.print(rsm.getColumnLabel(i) + " : ");
				gui.getTextArea().appendText(rsm.getColumnLabel(i) + " : ");
			}
			System.out.print(rsm.getColumnLabel(7) + " : ");
			gui.getTextArea().appendText(rsm.getColumnLabel(7) + "\n");
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getString("tId") + " : " + rs.getString("fname") + " : " + rs.getString("mname") + " : " + rs.getString("lname") + " : " 
									+ rs.getString("degree"));
				gui.getTextArea().appendText(rs.getString("tId") + " : " + rs.getString("fname") + " : " + rs.getString("mname") + " : " + rs.getString("lname") + " : " 
						+ rs.getString("degree") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public void getSchool() {
		try {
			System.out.println("TABLE: SCHOOL");
			ResultSet rs = stmt.executeQuery("select * from School");
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i = 1; i < 3; i++) {
				System.out.print(rsm.getColumnLabel(i) + " : ");
			}
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getString("schoolId") + " : " + rs.getString("name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getModule() {
		try {
			System.out.println("TABLE: MODULE");
			ResultSet rs = stmt.executeQuery("select * from Module");
			ResultSetMetaData rsm = rs.getMetaData();
			
			
			System.out.print(rsm.getColumnLabel(1) + " : ");
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getString("moduleName"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getClassGroup() {
		try {
			System.out.println("TABLE: CLASSGROUP");
			ResultSet rs = stmt.executeQuery("select * from ClassGroup");
			ResultSetMetaData rsm = rs.getMetaData();
			
			
			System.out.print(rsm.getColumnLabel(1) + " : ");
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getString("className") + " : " + rs.getString("sId"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	*/
	
	/**
	 * This method gets the modules and grades for a particular student
	 * @param sId This is the id od the student
	 * @param gui This is the gui to print to
	 */
	public void getModuleGrade(String sId, StudentGUI gui) {
		try {
			System.out.println("TABLE: MODULEGRADE");
			ResultSet rs = stmt.executeQuery("select * from ModuleGrade where sId = '" + sId + "'");
			ResultSetMetaData rsm = rs.getMetaData();
			
			for (int i = 1; i < 4; i++) {
				System.out.print(rsm.getColumnLabel(i) + " : ");
				gui.getTextArea().appendText(rsm.getColumnLabel(i) + " : ");
			}
			System.out.println();
			gui.getTextArea().appendText("\n");
			while (rs.next()) {
				System.out.println(rs.getString("moduleName") + " : " + rs.getString("sId") + " : " + rs.getInt("grade"));
				gui.getTextArea().appendText(rs.getString("moduleName") + " : " + rs.getString("sId") + " : " + rs.getInt("grade") + "\n");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will add a new student to the database.
	 * @param s This is the student we want to add.
	 */
	public void insertStudent(Student s) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("insert into Student (sId, fname, mname, lname, email, phone, dob) values (?, ?, ?, ?, ?, ?, ?)");
			/*stmt.executeUpdate("insert into Student (sId, fname, mname, lname, email, phone, dob) values(R" + s.getStudentId() + ", " + 
		s.getName().getFname() + ", " + s.getName().getMname() + ", " + s.getName().getLname() + ", " + s.getEmail() + ", " + s.getPhone() 
		+ ", " + s.getDob() + ")");*/
			pstmt.setString(1, s.getStudentId());
			pstmt.setString(2, s.getName().getFname());
			if (s.getName().getMname() == null)
				pstmt.setString(3, null);
			else
				pstmt.setString(3, s.getName().getMname());
			pstmt.setString(4, s.getName().getLname());
			pstmt.setString(5, s.getEmail());
			pstmt.setString(6, s.getPhone());
			pstmt.setString(7, s.getDob());
			pstmt.executeUpdate();
			
			System.out.println("A Student was inserted in the table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method adds a new teacher to the database.
	 * @param t This is the teacher we want to add.
	 */
	public void insertTeacher(Teacher t) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("insert into Teacher (sId, fname, mname, lname, email, phone, degree) values (?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, "T" + t.getTeacherId());
			pstmt.setString(2, t.getName().getFname());
			pstmt.setString(3, t.getName().getMname());
			pstmt.setString(4, t.getName().getLname());
			pstmt.setString(5, t.getEmail());
			pstmt.setString(6, t.getPhone());
			pstmt.setString(7, t.getDegree());
			pstmt.executeUpdate();
			
			System.out.println("A Teacher was inserted in the table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void insertSchool(School s) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("insert into School (schoolId, name) values (?, ?)");
			
			pstmt.setString(1, "S" + s.getSchoolId());
			pstmt.setString(2, s.getSchoolName());
			pstmt.executeUpdate();
			
			System.out.println("A School was inserted in the table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/**
	 * This method adds a new ModuleGrade to the database.
	 * @param mg This is the ModuleGrade to add.
	 * @param id This is the id of the student for whom we want to add the ModuelGrade.
	 */
	public void insertModuleGrade(Module_Grade mg, String id) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("insert into ModuleGrade (moduleName, sId, grade) values (?, ?, ?)");

			pstmt.setString(1,mg.getModuleName());
			pstmt.setString(2, id);
			pstmt.setInt(3, mg.getGrade());
			pstmt.executeUpdate();
			
			System.out.println("A new ModuleGrade was inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method adds a new ClassGroup to the database.
	 * @param className This is the name of the class.
	 * @param sId This is the id of the student we want to add to the class.
	 */
	public void insertClassGroup(String className, String sId) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("insert into ClassGroup (classId, sId) values (?, ?)");

			pstmt.setString(1,className);
			pstmt.setString(2, sId);
			pstmt.executeUpdate();
			
			System.out.println("A new ClassGroup was inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method deletes a student from the database.
	 * @param sId This is the id of the student to be removed
	 */
	public void deleteStudent(String sId) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("delete from Student where sId=?");

			pstmt.setString(1,sId);
			pstmt.executeUpdate();
			
			System.out.println("A new School was deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void deleteTeacher(String tId) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("delete Teacher where tId=?");

			pstmt.setString(1,tId);
			pstmt.executeUpdate();
			
			System.out.println("A new Teacher was deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteSchool(String schoolId) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("delete School where schoolId=?");

			pstmt.setString(1,schoolId);
			pstmt.executeUpdate();
			
			System.out.println("A new School was deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/**
	 * This method deletes a ModuleGrade form the database.
	 * @param moduleName This is the name of the module
	 * @param sId This is the id of the student
	 */
	public void deleteModuleGrade(String moduleName, String sId) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("delete from ModuleGrade where moduleName=? and sId=?");

			pstmt.setString(1,moduleName);
			pstmt.setString(2,sId);
			pstmt.executeUpdate();
			
			System.out.println("A new ModuleGrade was deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This methods deletes a student from a ClassGroup from the database.
	 * @param sId This is the id of the student
	 */
	public void deleteStudentClassGroup(String sId) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("delete from ClassGroup where sId=?");

			//pstmt.setString(1,className);
			pstmt.setString(1,sId);
			pstmt.executeUpdate();
			
			System.out.println("A new ModuleGrade was deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method updates a module.
	 * @param moduleName This is the name of the module to be updated
	 * @param sId This is the id of the student
	 * @param grade This is the grade the student got.
	 */
	public void editModuleGrade(String moduleName, String sId, int grade) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("update ModuleGrade set grade = ? where moduleName = ? and sId = ?");

			pstmt.setInt(1,grade);
			pstmt.setString(2, moduleName);
			pstmt.setString(3, sId);
			pstmt.executeUpdate();
			
			System.out.println("ModuleGrade was updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		Database db = new Database();
	}*/
}
