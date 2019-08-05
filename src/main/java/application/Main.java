package application;

import view.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ClassGroup;
import model.Student;
import model.Teacher;

/**
 * <h1>Main</h1>
 * @author Ronan
 * The Main class will present all of the guis in tabs to the user.
 */
public class Main extends Application{
	private BorderPane mainPane;
	private Button submit;
	private TabPane tabs;
	private Group root;
	private Scene scene;
	@Override
	public void start(Stage primaryStage) {
		try {
			mainPane = new BorderPane();
			root = new Group();
			Scene scene = new Scene(root,800,800);
			
			tabs = new TabPane();
			tabs.getTabs().add(new StudentGUI());
			tabs.getTabs().add(new TeacherGUI());
			
			//tabs.getTabs().add(new PrizeGUI(this));
			
			mainPane.setCenter(tabs);
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(mainPane);
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassGroup cg1 = new ClassGroup();
		ClassGroup cg2 = new ClassGroup();
		
		Student s1 = new Student("asd", "iasjf", "asjd@asidh.com", "0856493221", "20/03/1998");
		Student s2 = new Student("asd", "aishdif", "iasjf", "poug4@ehrg.com", "0857894456", "07/12/1998");
		Student s3 = new Student("asd", "iasjf", "asd2@dsf2.com", "0857894112", "10/09/1997");
		Student s4 = new Student("asd", "poifhl", "iasjf", "sgr@2a1sd.com", "0859856632", "17/10/1998");
		
		cg1.add(s1);
		cg1.add(s3);
		cg2.add(s2);
		cg2.add(s4);
		
		cg1.list();
		System.out.println();
		cg2.list();
	}*/

}
