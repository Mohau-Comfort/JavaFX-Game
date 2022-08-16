package csc2a.ui;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 
 * GamePane provides a custom container to manage all game interactions
 * and host the GameCanvas
 * @author <217055163 Mahlakwane M.C>
 *
 */
public class GamePane extends StackPane{
	
	//Attributes
	private GameCanvas canvas; //You need the canvas so the visitor can draw on it
	
	
	/**
	 * Default constructor
	 */
	public GamePane() {
		super();
		
		//Create the canvas to draw on
		canvas = new GameCanvas();	
		//Bind the width and height so the canvas resizes with window		
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		
		/* TODO: Construct your GamePane as you see fit */
		
		/* TODO: Do you game logic using Event Handlers*/
		//For example
		this.setOnKeyPressed((event) -> {
			System.out.println("Key Pressed: " + event.getCode());
		}); 
		this.setOnMouseClicked((event) -> {
			System.out.println("Mouse Clicked: " + event.getButton());
		});
		this.setOnMouseMoved((event) -> {
			System.out.println("Mouse Moved: (" + event.getX() + ", " + event.getY() + ")");
		});		
		
		//Add canvas as a child of the Pane
		this.getChildren().add(canvas);
		
		/* TODO: Finish setting up your GamePane */
	}	
}
