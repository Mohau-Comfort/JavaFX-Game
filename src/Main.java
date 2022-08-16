
import java.io.File;
import java.net.MalformedURLException;

import csc2a.ui.Buttons;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Entry Point for the JavaFX Application
 * @author <217044163 Mahlakwane MC>
 *
 */

public class Main extends Application{
	
	/**
	 * Main entry point for the program
	 * @param args Command line arguments
	 */
	
	static Stage mainStage = null;
	private Buttons buttons = null;
	private String imgPath;


	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Default start method provided by the JavaFX Application
	 */
	/*
	@Override
	public void start(Stage primaryStage) throws Exception {
	//	 TODO: Set up your Scene and Stage 
		GamePane gPane = new GamePane();		
		Scene scene = new Scene(gPane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		gPane.requestFocus(); //This is done so the Pane accepts input from the keyboard and mouse
	}*/
	
	@SuppressWarnings("deprecation")
	private void StartContent() {
		
		BorderPane rootBorder = new BorderPane();
		
		Scene StartScene = new Scene(rootBorder, 800, 600);
		mainStage.setTitle("Treasure Hunter");
		mainStage.setScene(StartScene);
		mainStage.setResizable(false);
		
		File file = new File("./utils/Webp.net-resizeimage.jpg");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buttons = new Buttons(mainStage);
		
		Node indexImage = new ImageView(new Image(imgPath));
		rootBorder.setCenter(indexImage);
		rootBorder.setTop(buttons.btnCombo1());
		
		mainStage.show();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage stage) throws Exception {
		this.mainStage = stage;
		this.StartContent();
	}

} 

