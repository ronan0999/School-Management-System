package view;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

import controller.StudentController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * <h1>Student</h1>
 * @author Ronan
 * The StudentGUI class is an interface that allows the user to manage students and class groups.
 */
public class StudentGUI extends Tab{
	private BorderPane pane;
	private Label label;
	private TextField moduleField, gradeField, classField, fnameField, mnameField, lnameField, emailField, phoneField, dobField, idField;
	private Button addStudentButton, removeStudentButton, addModuleButton, removeModuleButton, editModuleButton, listButton, sortAndListButton, getModuleButton;
	private HBox hb1, hb2;
	private VBox vb, vb1, vb2;
	private TextArea area;
	private StudentController controller;
	private ArrayList<TextField> fieldArray;
	
	public StudentGUI(){
		try {
			setText("Manage Students");
			
			controller = new StudentController(this);
			
			pane = new BorderPane();
			pane.setPadding(new Insets(20, 20, 20, 20));
			
			label = new Label("Edit student's modules\nTo add a Student, enter the student's detail and a class group to which the student will be added.\n"
					+ "To remove a student enter the class group and the student id."
					+ "\nTo add/remove modules/grade enter the module, the grade and the studentID."
					+ "\nTo get the modules of a student, specify the student id."
					+ "\nTo sort and list, specify the class group");
			//label.fontProperty(Font.font(family));
			label.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
			fieldArray = new ArrayList<TextField>();
			
			moduleField = new TextField();
			moduleField.setPromptText("Enter a module");
			fieldArray.add(moduleField);
			gradeField = new TextField();
			//gradeField.prefWidth(60);
			gradeField.setPromptText("Enter a grade");
			fieldArray.add(gradeField);
			classField = new TextField();
			classField.setPromptText("Enter a class group");
			fieldArray.add(classField);
			fnameField = new TextField();
			fnameField.setPromptText("First Name");
			fieldArray.add(fnameField);
			mnameField = new TextField();
			mnameField.setPromptText("Middle Name (Optional)");
			fieldArray.add(mnameField);
			lnameField = new TextField();
			lnameField.setPromptText("Last Name");
			fieldArray.add(lnameField);
			emailField = new TextField();
			emailField.setPromptText("Email");
			fieldArray.add(emailField);
			phoneField = new TextField();
			phoneField.setPromptText("Phone");
			fieldArray.add(phoneField);
			dobField = new TextField();
			dobField.setPromptText("DOB");
			fieldArray.add(dobField);
			idField = new TextField();
			idField.setPromptText("Student ID");
			fieldArray.add(idField);
			
			
			addStudentButton = new Button("Add Student");
			addStudentButton.setOnAction(e -> controller.addStudent(classField.getText(), fnameField.getText(), mnameField.getText(), 
										lnameField.getText(), emailField.getText(), phoneField.getText(), dobField.getText(), idField.getText()));
			removeStudentButton = new Button("Remove Student");
			removeStudentButton.setOnAction(e -> controller.removeStudent(idField.getText()));
			addModuleButton = new Button("Add Module");
			addModuleButton.setOnAction(e -> controller.addModuleGrade(moduleField.getText(), idField.getText(), gradeField.getText()));
			removeModuleButton = new Button("Remove Module");
			removeModuleButton.setOnAction(e -> controller.removeModuleGrade(moduleField.getText(), idField.getText()));
			editModuleButton = new Button("Edit Module");
			editModuleButton.setOnAction(e -> controller.editModuleGrade(moduleField.getText(), idField.getText(), gradeField.getText()));
			getModuleButton = new Button("Get Modules");
			getModuleButton.setOnAction(e -> controller.getModuleGrade(idField.getText(), this));
			sortAndListButton = new Button("Sort&List");
			sortAndListButton.setOnAction(e -> controller.sortAndListStudents(classField.getText(), this));
			
			hb1 = new HBox();
			hb2 = new HBox();
			
			vb = new VBox();
			vb1 = new VBox();
			vb2 = new VBox();
			
			vb.getChildren().addAll(classField, fnameField, mnameField, lnameField, emailField, phoneField, dobField, idField, moduleField, gradeField);
			vb.setSpacing(8);
			vb.setAlignment(Pos.CENTER);
			/*vb1.getChildren().addAll(moduleField, gradeField);
			vb1.setSpacing(8);
			vb1.setAlignment(Pos.CENTER);*/
			vb2.getChildren().addAll(addStudentButton, removeStudentButton, addModuleButton, removeModuleButton, editModuleButton, getModuleButton, sortAndListButton);
			vb2.setSpacing(8);
			vb2.setAlignment(Pos.CENTER);
			
			hb1.getChildren().addAll(vb, vb2);
			hb1.setSpacing(10);
			hb1.setAlignment(Pos.CENTER);
			
			area = new TextArea();
			area.setFont(Font.font("Monospace"));
			
			
			//pane.setCenter(hb1);
			pane.setLeft(vb);
			//pane.setCenter(vb1);
			pane.setRight(vb2);
			pane.setTop(label);
			pane.setBottom(area);
			
			//pane.setPadding(new Insets(20, 20, 20, 20));
			
			setContent(pane);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is to get the TextArea.
	 * @return TextArea area
	 */
	public TextArea getTextArea() {
		return area;
	}
	
	public void clearFields() {
		for (int i = 0; i < fieldArray.size(); i++) {
			fieldArray.get(i).clear();
		}
	}
	
}
