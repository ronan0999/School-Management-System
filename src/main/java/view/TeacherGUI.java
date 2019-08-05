package view;

import controller.TeacherController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * The TeacherGUI class is an interface that allows the user to see all the teachers along with their degree.
 * @author Ronan
 *
 */
public class TeacherGUI extends Tab{
	
	private Label label;
	private BorderPane pane;
	//private TextField classGroupField, //fnameField, lnameField, mnameField;
	private Button listButton;//, addButton, removeButton, listButton;
	private HBox hb1;//, hb2, hb3;
	private VBox vb1;//, vb2, vb3;
	private TextArea area;
	private TeacherController controller;
	
	public TeacherGUI(){
		try {
			setText("Teachers");
			
			controller = new TeacherController();
			
			pane = new BorderPane();
			pane.setPadding(new Insets(10, 10, 10, 10));
			
			label = new Label("List Teachers");
			pane.setTop(label);
			
			listButton = new Button("List Teachers");
			listButton.setOnAction(e -> controller.listTeachers(this));
			
			area = new TextArea();
			area.setFont(Font.font("Monospace"));
			pane.setCenter(listButton);
			pane.setBottom(area);
			
			
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
}
